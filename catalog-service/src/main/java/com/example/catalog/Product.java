package com.example.catalog;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @SequenceGenerator(name="product_pkey_sequence",sequenceName="product_pkey_sequence", initialValue=0, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="product_pkey_sequence")
    private Long id;

    private String name;

    private String description;

    private String imageId;
}
