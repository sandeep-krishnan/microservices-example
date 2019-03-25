package com.example.catalog;

import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class ProductResponse {
    private Long id;

    private String name;

    private String description;

    private String imageName;

    public ProductResponse(Product product, Image image) {
        BeanUtils.copyProperties(product, this);
        imageName = (image != null? image.getName() : "");
    }
}
