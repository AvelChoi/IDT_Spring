package com.example.springbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.ArrayList;

@Controller
public class BasicController {

    @Autowired
    private CartService cartService;

    @Autowired
    private BookService bookSerivce;


    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/loginform")
    public String loginform(@RequestParam(required = false, defaultValue = "") String userId, Model model) {
        model.addAttribute("userId", userId);
        return "loginform";
    }

    @RequestMapping("login")
    public String login(HttpServletRequest request, @RequestParam String userId, @RequestParam String userPwd) {
        if (userId.equals(userPwd)) {
            request.getSession().setAttribute("userId", userId);
            return "redirect:/";
        } else {
            return "redirect:/loginform?userId=" + userId;
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("userId");
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request, Model model) {
        model.addAttribute("userId", request.getSession().getAttribute("userId"));
        return "list";
    }

    @RequestMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        ArrayList<Book> result = bookSerivce.selectByKeyword(keyword);
        model.addAttribute("result", result);


        return "search";
    }

    @RequestMapping("/read")
    public String read(@RequestParam int bookId, Model model) {
        model.addAttribute("book", bookSerivce.selectOne(bookId));
        return "read";
    }

    @RequestMapping("/comment")
    // ??? ????????? ???????????? ???????????? ???????????? ??????.
    // ????????? comment ??????
    public String comment(@RequestParam int bookId, @RequestParam String comment) {
        bookSerivce.addComment(bookId, comment);
        // ????????? ?????? ?????? ????????? ?????? ?????? ???????????? ?????????
        return "redirect:/read?bookId=" + bookId;
    }

    @RequestMapping("/cart")
    // ?????? ???????????? ??????
    public String cart(@RequestParam int bookId, @RequestParam int qty, Model model) {
        DecimalFormat df = new DecimalFormat("###,###");
        Book find = bookSerivce.selectOne(bookId);
        String log = String.format("??????: %s / ??????: %d??? * %d??? => ??????: %d???", find.getTitle(), qty, df.format(find.getPrice()*qty));

        cartService.insert(log);

        model.addAttribute("carts", cartService.selectAll());


        return "cart";
    }


}
