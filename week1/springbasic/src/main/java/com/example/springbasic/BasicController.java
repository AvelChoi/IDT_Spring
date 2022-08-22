package com.example.springbasic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class BasicController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/banners")
    public String banners(Model model) {

        // 배너에는 이미지, 링크가 있어야 한다.
        ArrayList<Link> banners = new ArrayList<>();
        banners.add(new Link("http://www.google.com", "google.png"));
        banners.add(new Link("http://www.naver.com", "naver.png"));
        banners.add(new Link("http://www.daum.net", "daum.png"));

        model.addAttribute("banners", banners);

        return "banners";
    }

    @GetMapping("/banners2")
    public String banners2(Model model) {
        ArrayList<ppl> banners2 = new ArrayList<>();
        banners2.add(new ppl("홍길동", 20, false));
        banners2.add(new ppl("신사임당", 15, true));
        banners2.add(new ppl("강감찬", 35, false));

        model.addAttribute("banners2", banners2);

        return "banners2";
    }



}
