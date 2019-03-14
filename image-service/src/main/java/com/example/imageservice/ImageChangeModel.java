package com.example.imageservice;

public class ImageChangeModel {
  private String action;
  private Long imageId;

  public ImageChangeModel(String action, Long imageId) {
    this.action = action;
    this.imageId = imageId;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public Long getImageId() {
    return imageId;
  }

  public void setImageId(Long imageId) {
    this.imageId = imageId;
  }
}
