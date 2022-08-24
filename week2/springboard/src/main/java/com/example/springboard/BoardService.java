package com.example.springboard;

import java.util.List;

public interface BoardService {
	List<BoardEntity> selectAll() throws Exception;
	BoardEntity selectOne(int boardIdx) throws Exception;

	BoardEntity read(int boardIdx) throws Exception;

	void insert(BoardEntity board) throws Exception;

	void delete(int boardIdx) throws Exception;
	void update(BoardEntity board) throws Exception;

}
