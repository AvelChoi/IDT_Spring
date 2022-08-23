package com.example.loginbasic;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginIntercept implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 컨트롤러로 request가 왔다갔다 하는데, 그걸 가로채서 어떤 동작을 할 수 있게 한다.
        // login 정보가 없을 경우 인터럽트하게 만드는 코드를 작성하려 한다.
        StringBuffer url = request.getRequestURL();
        String userId = (String) request.getSession().getAttribute("userId");

        // mapping 허용: true, 불허: false

        if (userId == null) {
            response.sendRedirect("/loginform");
            return false;
        } else if (url.toString().contains("/admin") && !userId.equals("admin")) {
            // admin 페이지로 왔는데 admin이 아닐 때
            response.setContentType("text/html; charset=UTF-8");
            response.setContentType("<script> alert('관리자로 로그인 했습니다') location.href='/loginform'; </script>");
            return false;
        } else {
            return true;
        }
    }
}
