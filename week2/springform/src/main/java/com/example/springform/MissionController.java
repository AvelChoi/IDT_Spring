package com.example.springform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MissionController {

    @RequestMapping("/seats")
    public String seats(@RequestParam HashMap query, Model model) {
        // 좌석 true false
        boolean[] seats = new boolean[10];

        model.addAttribute("seats", seats);

        // 체크된 키에 대해서 seats 리스트의 값을 true로 바꿔준다.
        for (Object key : query.keySet()) {
            // ans3의 값에서 ans를 빈 문자열로 바꿔준다. 이후 Integer로 바꿔서 인덱스로 사용
            int index = Integer.parseInt(key.toString().replace("ans", ""));
            seats[index - 1] = true;

        }

        return "seats";
    }

    @RequestMapping("/survey")
    public String survey(Model model) {
        ArrayList<Survey> surveys = new ArrayList() {
            {
                add(new Survey(1, "여행에 대한 만족도는? (1)", 0));
                add(new Survey(2, "여행에 대한 만족도는? (2)", 0));
                add(new Survey(2, "여행에 대한 만족도는? (3)", 0));
                add(new Survey(4, "기타 하고 싶은 말은?", 1));
                add(new Survey(5, "가장 친절한 직원은?", 1));
                add(new Survey(2, "여행에 대한 만족도는? (6)", 0));
                add(new Survey(7, "응원의 말은?", 1));
            }
        };

        model.addAttribute("surveys", surveys);

        return "survey";
    }

    @RequestMapping("/commit")
    public String survey(@RequestParam HashMap<String, String> query, Model model) {
        String[] answers = new String[query.size()];

        for (Map.Entry<String, String> entry : query.entrySet()) {
            int index = Integer.parseInt(entry.getKey().replace("ans", ""));
            answers[index - 1] = entry.getValue();
        }

        model.addAttribute("answers", answers);

        return "commit";
    }
}
