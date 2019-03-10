package com.example.catalogservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ImageService imageService;

    @GetMapping("{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        Collection<String> imageNames = imageService.getImageNames();
        System.out.println("Image names are " + imageNames);
        return productRepository.findById(id).orElse(null);
    }
}
