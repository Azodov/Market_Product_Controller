package com.fido.biznes.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "producctype")
    private String productType;

    @Column(name = "productname")
    private String productName;

    @Column(name = "productprice")
    private String productPrice;

    @Column(name = "productcount")
    private String productCount;

}
