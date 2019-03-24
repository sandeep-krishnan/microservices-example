package com.example.imageservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageChangeModel {
  private String action;
  private String imageId;

  public ImageChangeModel(String action, String imageId) {
    this.action = action;
    this.imageId = imageId;
  }
}
