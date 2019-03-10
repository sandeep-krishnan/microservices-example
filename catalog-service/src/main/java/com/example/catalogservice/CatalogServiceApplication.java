package com.example.catalogservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class CatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner demoData(ProductRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                Product product = new Product();
                product.setName("Rice");
                product.setDescription("Lots of rice");
                repository.save(product);
            }
        };
    }
}
