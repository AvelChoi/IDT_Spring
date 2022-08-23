package com.example.loginbasic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping("/")
    // userid를 받아서 홈으로 넘겨준다
    public String home(HttpServletRequest request, Model model) {
        String userId = (String) request.getSession().getAttribute("userId");
        model.addAttribute("userId", userId);
        return "home";
    }

    @RequestMapping("/loginform")
    // 아이디의 경우 필수 조건을 false 처리하고, 기본값을 빈 문자열로 만든다.
    public String loginfrom(@RequestParam(required = false, defaultValue = "") String userId, Model model) {
        model.addAttribute("userId", userId);
        return "loginform";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, @RequestParam String userId, @RequestParam String userPwd) {
        // 로그인 인증이 된다면 "/" 루트로 이동
        // 그렇지 않다면 /loginform으로 이동
        // 인증된 사용자에 대해서 아이디에 세션 변수를 할당해준다

        if (userId.equals(userPwd)) {
            request.getSession().setAttribute("userId", userId);
            return "redirect:/";
        } else {
            return "redirect:/loginform?userId=" + userId;
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("userId");
        return "redirect:/";
    }

    @RequestMapping("/service1")
    @ResponseBody
    public String service1(HttpServletRequest request) {
        // userid 세션 변수가 존재할 경우에는 서비스
        // 그렇지 않을 경우에는 loginform으로 이동

        if (request.getSession().getAttribute("userId") == null) {
            return "<script> location.href='/loginform'; </script>";
        } else {
            return "service1 실행중";
        }

    }

    @RequestMapping("/service2")
    @ResponseBody
    public String service2(HttpServletRequest request) {
        // userid 세션 변수가 존재할 경우에는 서비스
        // 그렇지 않을 경우에는 loginform으로 이동

        if (request.getSession().getAttribute("userId") == null) {
            return "<script> location.href='/loginform'; </script>";
        } else {
            return "service2 실행중";
        }

    }

}
