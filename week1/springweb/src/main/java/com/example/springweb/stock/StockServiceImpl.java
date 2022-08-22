package com.example.springweb.stock;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private ArrayList<Stock> stocks = new ArrayList() {
        {
            add(new Stock("267850", "아시아나IDT", 14100));
            add(new Stock("020560", "아시아나항공", 15250));

        }
    };

    @Override
    public List<Stock> findAll(Model model) {
        model.addAttribute("stocks", stocks);
        return stocks;
    }

    @Override
    public Stock findByStockNo(String stockNo) {
        return stocks.stream().filter(
                m -> m.getComCode().equals(stockNo)
        ).findAny().get();
    }

    @Override
    public void delete(String stockNo) {
        Stock stock = stocks.stream().filter(
                m -> m.getComCode().equals(stockNo)).findAny().get();
        stocks.remove(stock);
    }
}
