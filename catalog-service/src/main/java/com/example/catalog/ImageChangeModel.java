package com.example.catalog;

import lombok.Data;

@Data
public class ImageChangeModel {
  private String action;
  private String imageId;

  public ImageChangeModel(String action, String imageId) {
    this.action = action;
    this.imageId = imageId;
  }
}
