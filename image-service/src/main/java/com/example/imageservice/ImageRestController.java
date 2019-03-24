package com.example.imageservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@RestController
@RequestMapping("/api/images")
public class ImageRestController {

  @Autowired private ImageRepository imageRepository;

  @GetMapping("")
  public Collection<Image> getImages() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
    }

    return imageRepository.findAll();
  }

  @GetMapping(path = "{id}")
  public Image getImage(@PathVariable("id") String id) {
    return imageRepository.findById(id).orElse(null);
  }

  @PutMapping(path = "{id}")
  public Image updateImage(@PathVariable("id") String id, @RequestBody @NotEmpty String imageName) {
    Image image = imageRepository.findById(id).orElse(null);
    if (image == null) {
      return null;
    }

    image.setName(imageName);
    return imageRepository.save(image);
  }

  @PostMapping("")
  public Image createImage(@RequestBody String imageName) {
    return imageRepository.save(new Image(imageName));
  }
}
