package com.fido.biznes.controller;

import com.fido.biznes.config.CurrencyFormatter;
import com.fido.biznes.model.Category;
import com.fido.biznes.model.Product;
import com.fido.biznes.repository.CategoryRepository;
import com.fido.biznes.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class AdminController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    CurrencyFormatter currencyFormatter = new CurrencyFormatter();

    public AdminController(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @GetMapping
    public String index() {
        return "index";
    }


    @GetMapping({"/admin/products", "/admin"})
    public String getAllProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "admin/private-products";
    }

    @GetMapping("/admin/addCategory/new")
    public String getAllCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/create_category";
    }

    @GetMapping("/admin/addProduct/new")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryRepository.findAll());
        return "admin/create_product";
    }

    @PostMapping("/admin/addProduct")
    public String addProduct(@ModelAttribute("product") Product product) {
        product.setProductPrice(currencyFormatter.formatDecimal(product.getProductPrice()));
        productRepository.save(product);
        return "redirect:/admin/products";
    }

    @PostMapping("/admin/addCategory")
    public String addCategory(@ModelAttribute("category") Category category) {
        categoryRepository.save(category);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/admin/products";
    }
    
}
