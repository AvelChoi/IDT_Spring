package com.example.springboard;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class BoardServiceImpl implements BoardService {

    ArrayList<BoardEntity> boardEntities = new ArrayList() {
        {
            add(new BoardEntity(1, "제목1", "내용1"));
            add(new BoardEntity(1, "제목2", "내용2"));
            add(new BoardEntity(1, "제목3", "내용3"));
            add(new BoardEntity(1, "제목4", "내용4"));
        }
    };

    @Override
    public List<BoardEntity> selectAll() throws Exception {
        return boardEntities;
    }

    @Override
    public BoardEntity selectOne(int boardIdx) throws Exception {

        return null;
    }

    @Override
    public BoardEntity read(int boardIdx) throws Exception {
        BoardEntity find = selectOne(boardIdx);
        find.setHitCnt(find.getHitCnt() + 1);
        return find;
    }

    @Override
    public void insert(BoardEntity board) throws Exception {

    }

    @Override
    public void delete(int boardIdx) throws Exception {
        BoardEntity find = selectOne(boardIdx);
        boardEntities.remove(find);
    }

    @Override
    public void update(BoardEntity board) throws Exception {
        BoardEntity find = selectOne(board.getBoardIdx());

        find.setContents(board.getContents());
        find.setTitle(board.getTitle());
        find.setHitCnt(board.getHitCnt());
        find.setCreatorId(board.getCreatorId());
        find.setCreatedDatetime(board.getCreatedDatetime());
        find.setUpdatedDatetime(board.getUpdatedDatetime());

    }
}
