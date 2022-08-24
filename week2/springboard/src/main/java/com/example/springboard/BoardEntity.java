package com.example.springboard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @AllArgsConstructor @NoArgsConstructor
public class BoardEntity {

    private int boardIdx;
    private String title;
    private String contents;
    private int hitCnt = 0;
    private String creatorId;		//작성자
    private LocalDateTime createdDatetime = LocalDateTime.now();
    private LocalDateTime updatedDatetime;

    public BoardEntity(int boardIdx, String title, String contents){
        this.boardIdx = boardIdx;
        this.title = title;
        this.contents = contents;
        this.creatorId = "guest";
    }



}
