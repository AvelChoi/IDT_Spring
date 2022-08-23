package com.example.springbook;

import java.util.ArrayList;

public class CartServiceImpl implements CartService {

    // 빈 arraylist 하나 생성
    ArrayList<String> carts = new ArrayList<>();

    @Override
    public ArrayList<String> selectAll() {
        return null;
    }

    @Override
    public void insert(String cart) {
        carts.add(cart);

    }
}
