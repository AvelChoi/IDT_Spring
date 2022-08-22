package com.example.hellospring;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class ViewController {

    //    넓은 의미의 매핑
    @RequestMapping("/view1")
    public String view1() {
        return "view1";
    }

    @RequestMapping("/view3")
    public ModelAndView view3() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "이순신");
        modelAndView.setViewName("view2");
        return modelAndView;
    }

    @RequestMapping("/view4")
    public String view4(Model model) {
        Person p = new Person("lee", 50);
        model.addAttribute("person", p);

        HashMap map = new HashMap();
        map.put("title", "Spring 기초");
        map.put("author", "홍길동");

//        model.addAttribute("person", p);
        model.addAttribute("book", map);

        model.addAttribute("url", "http://naver.com");
        model.addAttribute("image", "naver.jpg");

        return "view4";
    }

    @RequestMapping("view5")
    public String view5(Model model) {
        String html = "";
        String[] arrHref = {"http://google.com", "http://daum.net"};
        String[] arrSrc = {"google.jpg", "daum.jpg"};

        model.addAttribute("title", "영화소개");
        model.addAttribute("main", "movie.jpg");

        for (int i = 0; i < arrHref.length; i++) {
            model.addAttribute("href" + i, arrHref[i]);
            model.addAttribute("src" + i, arrSrc[i]);
        }

        return "view5";
    }

    @RequestMapping("/rsp")
    public String rsp(Model model) {
        String[] arrPic = {"r.jpg", "s.jpg", "p.jpg"};
        String[] resultPic = {"win.jpg", "lose.jpg", "draw.jpg"};

        int p1 = (int) (Math.random() * 3);
        int p2 = (int) (Math.random() * 3);

        System.out.println(p1 + ", " + p2);

//        계산 부분
        int score = p1 - p2;
        int result = 0;
        if (score == 0) {
            result = 2;
        } else if (score == -1 || score == 2) {
            result = 0;
        } else {
            result = 1;
        }

//        모범답안: 2차원 리스트
        int[][] matrix = {
                {0, 2, 1},
                {1, 0, 2},
                {2, 1, 0}
        };

        int compare = matrix[p1][p2];

        model.addAttribute("p1", arrPic[p1]);
        model.addAttribute("p2", arrPic[p2]);
        model.addAttribute("result", resultPic[result]);


        return "rsp";
    }

}
