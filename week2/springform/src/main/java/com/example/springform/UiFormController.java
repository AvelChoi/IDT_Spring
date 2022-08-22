package com.example.springform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class UiFormController {

    @GetMapping("/uiform")
    public String uiform(@RequestParam String title, String exercise, String[] vehicles, String fruits, String review, Model model) {
        model.addAttribute("title", title == null? "" : title);
        model.addAttribute("exercise", exercise == null? "" : exercise);
        model.addAttribute("vehicles", vehicles == null? new ArrayList<String>() : Arrays.asList());
        model.addAttribute("fruits", fruits == null? "" : fruits);
        model.addAttribute("review", review == null? "" : review);
        return "uiform";
    }

}
