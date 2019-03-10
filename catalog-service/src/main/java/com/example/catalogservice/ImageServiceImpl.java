package com.example.catalogservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRestClient imageClient;

    @Override
    @HystrixCommand(fallbackMethod = "getBlankImageNames")
    public Collection<String> getImageNames() {
        return imageClient.getImageNames();
    }

    public Collection<String> getBlankImageNames() {
        return Collections.emptyList();
    }
}
