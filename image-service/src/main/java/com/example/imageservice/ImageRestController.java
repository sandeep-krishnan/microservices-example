package com.example.imageservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

@RestController("/api/image")
public class ImageRestController {

  @GetMapping
  public Collection<String> getImageName() {
    return Arrays.asList("Taj Mahal", "Great Wall of China");
  }
}
