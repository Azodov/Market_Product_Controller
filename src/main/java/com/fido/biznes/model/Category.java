package com.fido.biznes.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "categoryname")
    private String name;
    @Column(name = "cid")
    private Long cid;
}
