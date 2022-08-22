package com.example.day3;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Book {
    private int id;
    private String title;
    private String author;
    private String category;
    private int price;

    private String img;
    private String url;



}
