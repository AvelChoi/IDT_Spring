package com.example.springweb.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class genderController {

    @Autowired
    private MemberService memberService;
    // 어떤 타입을 보고서 해당 타입의 객체를 연결해주는 역할을 한다.
    // Autowired를 붙임에 따라 service 어노테이션이 붙어있는 서비스에 붙을 수 있다.

    @GetMapping("/genderlist")
    public String genderlist(@RequestParam boolean gender, Model model) {
        model.addAttribute("members", memberService.findByGender(gender));

        return "memberlist";
    }

}
