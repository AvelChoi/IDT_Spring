package com.example.springform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class QueryController {

    // q?keyword=hello
    // q?keyword=한글
    @GetMapping("/q")
    @ResponseBody
    public String q(String keyword) {
        return "keyword = " + keyword;
    }

    // 이 경우에는 키워드를 입력해주지 않으면 주소가 아예 동작하지 않는다.
    @GetMapping("/q1")
    @ResponseBody
    public String q1(@RequestParam String keyword) {
        return "keyword = " + keyword;
    }

    // q2?keyword=hello&page=4
    @GetMapping("/q2")
    @ResponseBody
    public String q2(@RequestParam String keyword, Integer page) {
        return "keyword: " + keyword + "/ page: " + page;
    }

    // q3?page=5&keyword=h
    @GetMapping("/q3")
    @ResponseBody
    public String q3(@RequestParam String keyword, @RequestParam int page) {
        return "keyword: " + keyword + "/ page: " + page;
    }

    // q4?keyword=h
    @GetMapping("/q4")
    @ResponseBody
    public String q4(@RequestParam(required = false) String keyword, @RequestParam(defaultValue = "1") Integer page) {
        return "keyword: " + keyword + "/ page: " + page;
    }

    @GetMapping("/q5/{id}")
    @ResponseBody
    public String q5(@PathVariable int id) {
        return "id: " + id;
    }

    @GetMapping("/q6/{id}/{name}")
    @ResponseBody
    public String q6(@PathVariable int id, @PathVariable String name) {
        return "id: " + id + ", name: " + name;
    }

    // http://localhost:8080/q7?id=6&name=hello
    @GetMapping("/q7")
    @ResponseBody
    public String q7(@RequestParam Map<String, String> query) {
        return "data: " + query + "<br>";
    }

    // q8/name=lee&age=10
    @GetMapping("/q8")
    @ResponseBody
    public String q8(Member member) {
        return "data: " + member;
    }

    @GetMapping("/weather/{city}")
    @ResponseBody
    public String weather(@PathVariable String city) {
        return String.format("<a href=https://search.naver.com/search.naver?where=nexearc&query=%s target='_blank'>%s</a>", city, city);
    }

}
