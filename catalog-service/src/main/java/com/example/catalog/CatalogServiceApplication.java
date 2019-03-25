package com.example.catalog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableBinding(ImageStream.class)
@EnableCaching
public class CatalogServiceApplication {

  private static final Logger logger = LoggerFactory.getLogger(CatalogServiceApplication.class);

  @Autowired
  private ImageService imageService;

  @StreamListener(ImageStream.INPUT)
  public void logImageChange(ImageChangeModel imageChangeModel) {
    logger.info("Received message " + imageChangeModel);
    imageService.evictCache(imageChangeModel.getImageId());
  }

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
        product.setImageId("1");
        repository.save(product);

        product = new Product();
        product.setName("Rice");
        product.setDescription("Lots of rice");
        product.setImageId("2");
        repository.save(product);
      }
    };
  }
}
