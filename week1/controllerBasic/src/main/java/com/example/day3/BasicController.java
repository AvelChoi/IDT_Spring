package com.example.day3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class BasicController {

    public ArrayList<Book> books = new ArrayList<>();

    public BasicController() {
        books.add(new Book(1, "점프 투 스프링부트", "박응용", "IT", 20000,
                "jumptoSpringBoot.png", "https://wikidocs.net/book/7601"));
        books.add(new Book(2, "이것이 자바다", "신용권", "IT", 27000,
                "thisisJava.jpg", "http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788968481475&orderClick=LAG&Kc="));
        books.add(new Book(3, "스페셜티 커피, 샌프란시스코에서 성수까지", "심재범", "요리", 16200,
                "specialty.jpg", "http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9791192169088&orderClick=LAG&Kc=#N"));
    }

    @RequestMapping("/")
    public String thymeleafbasic(Model model) {
        model.addAttribute("name", "홍길동");
        model.addAttribute("html", "<p style=\"color:red;\"> This is a paragraph. </p>");
        model.addAttribute("image", "python.png");
        model.addAttribute("id", 10);

        model.addAttribute("book", books.get(0));

        model.addAttribute("age", 10);

        String[] datas = {"사과", "배", "귤", "바나나", "포도"};
        model.addAttribute("datas", datas);

        model.addAttribute("books", books);

        return "main";
    }

    @RequestMapping("/fragment")
    public String fragment() {
        return "fragment";
    }
    

}
