package com.example.catalog;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class ImageServiceImpl implements ImageService {

  private static final Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);

  @Autowired private ImageRestClient imageClient;

  @Override
  @HystrixCommand(fallbackMethod = "getBlankImageNames")
  public Collection<Image> getImageNames() {
    return imageClient.getImageNames();
  }

  public Collection<Image> getBlankImageNames() {
    return Collections.emptyList();
  }

  @Override
  @HystrixCommand
  @Cacheable(value = "imageCache", key = "#id")
  public Image getImageById(String id) {
    logger.info("Getting image " + id);
    return imageClient.getImageById(id);
  }

  @CacheEvict(value = "imageCache", key = "#id")
  public void evictCache(String id) {
    logger.info("Evicting image with id " + id);
  }
}
