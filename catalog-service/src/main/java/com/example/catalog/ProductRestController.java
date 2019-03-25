package com.example.catalog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

  private Logger logger = LoggerFactory.getLogger(ProductRestController.class);

  @Autowired private ProductRepository productRepository;

  @Autowired private ImageService imageService;

  @GetMapping
  public Collection<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @GetMapping("{id}")
  public ProductResponse getProduct(@PathVariable("id") Long id) {
    Product product = productRepository.findById(id).orElse(null);

    Image image = null;
    if (product != null && product.getImageId() != null) {
      image = imageService.getImageById(product.getImageId());
      logger.info("Image is " + image);
    }

    return new ProductResponse(product, image);
  }
}
