package com.example.springweb.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;
    // 어떤 타입을 보고서 해당 타입의 객체를 연결해주는 역할을 한다.
    // Autowired를 붙임에 따라 service 어노테이션이 붙어있는 서비스에 붙을 수 있다.

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/memberlist")
    public String memberlist(Model model) {

        model.addAttribute("members", memberService.findAll());

        return "memberlist";
    }

    @GetMapping("/memberread")
    public String memberread(@RequestParam String userId, Model model) {
        model.addAttribute("member", memberService.findByUserId(userId));
        return "memberread";
    }

    @GetMapping("/memberdelete")
    public String memberdelete(@RequestParam String userId, Model model) {
        memberService.delete(userId);
        return "redirect:/memberlist";
    }
}
