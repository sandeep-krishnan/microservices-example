package com.example.imageservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleSourceBean {
  @Autowired
  private ImageStream imageStream;

  public void publishChange(String action, String imageId) {
    ImageChangeModel imageChangeModel = new ImageChangeModel(action, imageId);
    MessageChannel messageChannel = imageStream.outboundImage();
    messageChannel.send(MessageBuilder.withPayload(imageChangeModel).build());
  }
}
