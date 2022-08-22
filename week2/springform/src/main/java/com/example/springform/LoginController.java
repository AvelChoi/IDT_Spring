package com.example.springform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping("/main")
    @ResponseBody
    public String main() {
        return "main page";
    }

    @GetMapping("/login")
    @ResponseBody
    public String loginGet(@RequestParam String id, @RequestParam String pw, Model model) {
        String html = "";

        if (id.equals("userId") && pw.equals("userPw")) {
            html += "<script> alert('success'); location href = '/main'; </script>";
        } else {
            html += "로그인 실패 <a href='/loginform.html'> 다시 로그인 </a>";
        }

        return html;
    }

    @PostMapping("/login")
    @ResponseBody
    public String loginPost() {
        String html = "";
        return html;
    }
}
