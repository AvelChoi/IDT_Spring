package com.example.springform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class BasicController2 {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.addValidators(new MemberValidator());
        // 이 validation에 있는 코드를 적용시킴
        // add 코드들은 이벤트 등록할 때 주로 볼 수 있다고 한다...
    }
    
    // valid5?age=105
    @RequestMapping("/valid5")
    public String valid5(@Valid Member member, BindingResult bindingResult, Model model) {
        // 만약 age에 aaa를 넣으면 자바 기본 에러 코드가 표시된다.
        return "valid3";
    }

    @GetMapping("/addform")
    public String addform(Model model) {
        // addform.html을 호출해서 내용을 작성
        // summit 버튼을 누르면 add 페이지가 나오게 된다...?
        model.addAttribute("member", new Member("", 0, "aaa@aaa.com"));

        return "addform";
    }
    
    // 실제로 값을 넣고 실행하게 된 부분
    // 유효한 데이터인지 확인하기 위해서 valid를 확인하게 된 것.
    @GetMapping("/add")
    public String add(@Valid Member member, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addform";
        } else {
            return "redirect:/";
        }
    }


}
