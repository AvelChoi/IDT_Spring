package com.example.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class BasicController {
    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Hello";
    }

    @GetMapping("name")
    @ResponseBody
    public String main() {
        return "<h1>Hello, What's your name?</h1>";
    }

    //    일단 이 어노테이션을 단 순간부터 컨테이너는 today로 인식한다.
//    다만 관습상 함수명과 동일하게 가져간다.
    @GetMapping("today")
    @ResponseBody
    public String today() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String toDay = String.format("오늘은 <h1> %s</h1>입니다", formatter.format(date));
        return toDay;
    }

    //    전역변수로 cnt를 설정
    int cnt = 90;

    @GetMapping("/count")
    @ResponseBody
    public String count() {
        cnt += 1;

        String[] emoji = {"0️⃣", "1️⃣", "2️⃣", "3️⃣", "4️⃣", "5️⃣", "6️⃣", "7️⃣", "8️⃣", "9️⃣"};

        String emoji_result = "";

        if (cnt < 10) {
            emoji_result = emoji[cnt];
        } else if (cnt < 100) {
            int oneNum;
            int tenNum;

            tenNum = cnt / 10;
            oneNum = cnt % 10;

            emoji_result = emoji[tenNum] + emoji[oneNum];

        } else if (cnt < 1000) {
            String html = "";

            String cntCtr = String.valueOf(cnt);

            for (int i = 0; i < cntCtr.length(); i++) {
                char c = cntCtr.charAt(i);
                String result = String.format("<img src = 'img/%c.png' width='50/'>", c);
                html += result;

            }


        }

        String result = String.format("방문자 수는 %s입니다.", emoji_result);

        return result;
    }

    @GetMapping("banner")
    @ResponseBody
    public String banner() {
        String galaxyZfold = "https://www.samsung.com/sec/galaxy-z-fold4/preorder/?cid=sec_paid_display_naver-coupleboard_f2h22-q4_pre-order_f2h22-q4_banner_220816-q4-a1_new-none&utm_source=naver-coupleboard&utm_medium=display&utm_campaign=f2h22-q4-pre-order&utm_content=220816-q4-a1&utm_term=new-none&_AT=041214AB01AD0351846B";
        String naver = "https://naver.com";
        String[] arrHref = {galaxyZfold, naver};
        String[] arrSrc = {"fold.jpg", "naver.png"};

        String html = "";

        for (int i=0; i<arrHref.length; i++) {
            html += String.format("<a href='%s'> <img src='/src/main/resources/img/%s' width='100' height='50'/> </a>", arrHref[i], arrSrc[i]);
        }

        return html;
    }



}
