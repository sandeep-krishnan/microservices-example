package com.example.catalog;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ImageStream {
  String INPUT = "imageChangeTopic-out";

  @Input(INPUT)
  SubscribableChannel inboundImage();
}
