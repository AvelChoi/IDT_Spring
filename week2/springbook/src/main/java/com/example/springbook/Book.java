package com.example.springbook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int bookId;
    private String title;
    private String author;
    private String category;
    private int price;

    private String image;
    private String url;

    private String[] comments;
}
