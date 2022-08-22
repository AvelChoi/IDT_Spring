package com.example.springform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

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
}
