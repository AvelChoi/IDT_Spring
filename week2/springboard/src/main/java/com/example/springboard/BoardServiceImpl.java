package com.example.springboard;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    ArrayList<BoardEntity> boardEntities = new ArrayList<>() {{
        add(new BoardEntity(1, "제목1", "내용1"));
        add(new BoardEntity(2, "제목2", "내용2"));
        add(new BoardEntity(3, "제목3", "내용3"));
        add(new BoardEntity(4, "제목4", "내용4"));
    }};

    @Override
    public List<BoardEntity> selectAll() throws Exception {

        return boardEntities;
    }

    @Override
    public BoardEntity selectOne(int boardIdx) throws Exception {

        return boardEntities.stream().filter(b -> b.getBoardIdx() == boardIdx ).findAny().get();

    }

    @Override

    public BoardEntity read(int boardIdx) throws Exception {
        BoardEntity find = selectOne(boardIdx);
        find.setHitCnt(find.getHitCnt() + 1); //hitCnt 증가

        return find;
    }

    @Override
    public void insert(BoardEntity board) throws Exception {
        boardEntities.add(board);
    }

    @Override
    public void delete(int boardIdx) throws Exception {
        BoardEntity find = selectOne(boardIdx);
        boardEntities.remove(find);
    }
/*
 private int boardIdx;
    private String title;
    private String contents;
    private int hitCnt = 0;
    private String creatorId;		//작성자
    private LocalDateTime createdDatetime = LocalDateTime.now();
    private LocalDateTime updatedDatetime;
* */
    @Override
    public void update(BoardEntity board) throws Exception {

        BoardEntity find = selectOne(board.getBoardIdx());  //기존 board


        find.setContents(board.getContents());
        find.setTitle(board.getTitle());
        find.setHitCnt(board.getHitCnt());
        find.setCreatorId(board.getCreatorId());
        find.setCreatedDatetime(board.getCreatedDatetime());
        find.setUpdatedDatetime(LocalDateTime.now());

    }
}
