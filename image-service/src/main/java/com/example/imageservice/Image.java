package com.example.imageservice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class Image {
  @Id
  private String id;
  private String name;

  public Image(String name) {
    this.name = name;
  }
}
