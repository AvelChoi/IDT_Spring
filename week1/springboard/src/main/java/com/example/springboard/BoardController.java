package com.example.springboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board")
    public String openBoardList(Model model) throws Exception {
        model.addAttribute("list", boardService.selectAll());
        return "board";
    }

    @GetMapping("/delete/{boardIdx}")
    public String deleteBoard(@RequestParam int boardInx) throws Exception {
        boardService.delete(boardInx);

        return "redirect:/board";
    }

    @GetMapping("/read/{boardIdx}")
    public String openBoardDetail(@PathVariable("boardIdx") int boardIdx, Model model) {
        BoardEntity board = boardService.read(boardIdx);
        model.addAttribute("board", board);
    }


}
