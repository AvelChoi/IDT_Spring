package com.example.springbook;

import java.util.ArrayList;

public interface CartService {

    ArrayList<String> selectAll();
    void insert(String cart);

}
