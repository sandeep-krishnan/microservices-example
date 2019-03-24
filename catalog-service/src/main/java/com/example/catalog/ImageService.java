package com.example.catalog;

import java.util.Collection;

public interface ImageService {
    Collection<Image> getImageNames();
    Image getImageById(String id);
}
