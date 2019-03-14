package com.example.imageservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleSourceBean {
  private Source source;

  @Autowired
  public SimpleSourceBean(Source source) {
    this.source = source;
  }

  public void publishChange(String action, Long imageId) {
    ImageChangeModel imageChangeModel = new ImageChangeModel(action, imageId);
    source.output().send(MessageBuilder.withPayload(imageChangeModel).build());
  }
}
