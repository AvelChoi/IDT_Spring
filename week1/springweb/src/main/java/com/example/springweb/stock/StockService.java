package com.example.springweb.stock;

import org.springframework.ui.Model;

import java.util.List;

public interface StockService {

    List<Stock> findAll(Model model);

    Stock findByStockNo(String stockNo);

    void delete(String stockNo);
}
