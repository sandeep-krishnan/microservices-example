package com.example.catalogservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner demoData(ProductRepository repository) {
        return args -> {
            Product product = new Product();
            product.setName("Rice");
            product.setDescription("Lots of rice");
            repository.save(product);
        };
    }
}
