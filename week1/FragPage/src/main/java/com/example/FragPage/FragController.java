package com.example.FragPage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/board")
    public String board() {
        return "board";
    }

    @GetMapping("/files")
    public String files() {
        return "files";
    }

    @GetMapping("/qna")
    public String qna() {
        return "qna";
    }

    @GetMapping("/mission")
    public String thymeleafapp(Model model) {
        model.addAttribute("genders", new boolean[]{true, true, true, false});
        return "mission";
    }

    @GetMapping("/seats")
    public String seats(Model model) {
//        int[] seatNum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        boolean[] seatStatus = {true, false, true, true, false, true, false, false, false, true};
//        model.addAttribute("seatNum", seatNum);
//        model.addAttribute("seatStatus", seatStatus);

        int[] s = {1, 5, 10};
        boolean[] list = new boolean[10];

        for(int seat:s) {
            list[seat - 1] = true;
        }

        model.addAttribute("seatStatus", list);


        return "seats";
    }


}
