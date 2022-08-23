package com.example.springbook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/loginform")
    public String loginform(String userId, Model model) {
        return "loginform";
    }

}
