package com.example.springweb.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/stockHome")
    public String stockHome() {
        return "stockHome";
    }

    @GetMapping("/stockList")
    public String stockList(Model model) {
        model.addAttribute("stocks", stockService);
        return "stockList";
    }

    @GetMapping("/stockDelete")
    public String stockDelete(@RequestParam String comCode, Model model) {
        stockService.delete(comCode);
        return "redirect:/stockList";
    }

}
