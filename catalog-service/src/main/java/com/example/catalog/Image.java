package com.example.catalog;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Image implements Serializable {
    private String id;
    private String name;
}
