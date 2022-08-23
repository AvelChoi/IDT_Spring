package com.example.loginbasic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

@Controller
public class BasicController {

    @RequestMapping("/session")
    @ResponseBody
    public String session(HttpServletRequest request) {
        return "session id: " + request.getSession().getId();
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(HttpServletRequest request) {
        request.getSession().setAttribute("userId", "hong");
        request.getSession().setAttribute("userNNam", "홍길동");
        return "session add";
    }

    @RequestMapping("/get")
    @ResponseBody
    public String get(HttpServletRequest request) {
        String userId = (String) request.getSession().getAttribute("userId");
        String userName= (String) request.getSession().getAttribute("userName");

        if (userId == null) userId ="X";
        if (userName == null) userName = "X";

        return "session get: " + userId + "/" +userName;
    }

    @RequestMapping("/remove")
    @ResponseBody
    public String remove(HttpServletRequest request) {
        request.getSession().removeAttribute("userId");
        request.getSession().removeAttribute("userName");
        return "session remove";
    }
}
