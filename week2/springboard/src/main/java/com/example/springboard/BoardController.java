package com.example.springboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/board")
    public String openBoardList(Model model) throws Exception {

        model.addAttribute("list", boardService.selectAll());

        return "/board/boardList";

    }

/*
    @GetMapping("/delete")  // /delete?boardIdx=1
    public String deleteBoard(@RequestParam int boardIdx) throws Exception {

        boardService.delete(boardIdx);

        return "redirect:/board";

    }
*/

    @GetMapping("/delete/{boardIdx}")  //     /delete/1
    public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {

        boardService.delete(boardIdx);

        return "redirect:/board";

    }

    @GetMapping("/read/{boardIdx}")
    public String openBoardDetail(@PathVariable("boardIdx") int boardIdx, Model model) throws Exception{
        BoardEntity board = boardService.read(boardIdx);
        model.addAttribute("board", board);

        return "/board/boardDetail";
    }



}
