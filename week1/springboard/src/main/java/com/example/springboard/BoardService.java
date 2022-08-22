package com.example.springboard;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    List<BoardEntity> selectAll() throws Exception;
    BoardEntity selectOne(int boardIdx) throws Exception;
    BoardEntity read(int boardIdx) throws Exception;
    void insert(BoardEntity board) throws Exception;
    void delete(int boardIdx) throws Exception;
    void update(BoardEntity board) throws Exception;
}
