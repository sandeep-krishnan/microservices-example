package com.example.imageservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableBinding(Source.class)
public class ImageServiceApplication {

  @Autowired private ImageRepository imageRepository;

  public static void main(String[] args) {
    SpringApplication.run(ImageServiceApplication.class, args);
  }

  @Bean
  public CommandLineRunner insertDefaultData() {
    return args -> {
      if (imageRepository.count() == 0) {
        imageRepository.save(new Image("Taj Mahal"));
        imageRepository.save(new Image("Great Wall of China"));
      }
    };
  }
}
