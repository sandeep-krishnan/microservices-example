package com.example.catalog;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@FeignClient("image-service")
public interface ImageRestClient {
    @RequestMapping(method = RequestMethod.GET, value = "/api/images", consumes = "application/json")
    Collection<Image> getImageNames();

    @RequestMapping(method = RequestMethod.GET, value = "/api/images/{id}", consumes = "application/json")
    Image getImageById(@PathVariable("id") String id);
}
