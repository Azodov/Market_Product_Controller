package com.fido.biznes.controller;


import com.fido.biznes.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private final ProductRepository productRepository;

    public UserController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/user/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "user/products";
    }
}
