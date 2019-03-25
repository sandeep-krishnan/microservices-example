package com.example.catalog;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRestClient imageClient;

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
    @Cacheable(value= "imageCache", key= "#id")
    public Image getImageById(String id) {
        System.out.println("Getting image " + id);
        return imageClient.getImageById(id);
    }

    @CacheEvict(value= "imageCache", key= "#id")
    public void evictCache(String id) {
        System.out.println("Evicting image with id " + id);
    }
}
