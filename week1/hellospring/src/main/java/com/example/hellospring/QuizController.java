package com.example.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
public class QuizController {

    @RequestMapping("/quiz")
    public String quiz(Model model) {
        String[] numList = {"11", "22", "33", "44", "55", "66", "77", "88", "99"};
//        퀴즈 리스트: 기차, 집, 학교, 파이썬, 헤드폰, 책, 비행기, 시계, 블루투스
        String[] quizList = {"train.png", "house.png", "school.png", "python.png", "headphone.png", "book.png",
                "plane.png", "watch.png", "bluetooth.png"};

        int a[] = new int[3];
        Random r = new Random();

        for (int i=0; i<3; i++) {
            a[i] = r.nextInt(8)+1;
            for (int j=0; j<i; j++) {
                if (a[i] == a[j]) {
                    i--;
                }
            }
        }

        for (int i=0; i<a.length; i++) {
            System.out.println("랜덤 숫자 출력");
            System.out.println(a[i]);
        }


        model.addAttribute("question0", numList[a[0]]);
        model.addAttribute("question1", numList[a[1]]);
        model.addAttribute("question2", numList[a[2]]);

        model.addAttribute("pic0", quizList[a[0]]);
        model.addAttribute("pic1", quizList[a[1]]);
        model.addAttribute("pic2", quizList[a[2]]);


        return "quiz";
    }
}
