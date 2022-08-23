package com.example.springbook;

import java.util.ArrayList;

public interface BookService {
    ArrayList<Book> selectAll();
    ArrayList<Book> selectByCategory(String category);
    ArrayList<Book> selectByKeyword(String keyword);
    Book selectOne(int bookId);
    void delete(int bookId);
    void addComment(int bookId, String comment);

}
