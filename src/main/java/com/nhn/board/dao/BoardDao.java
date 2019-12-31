package com.nhn.board.dao;

import java.util.List;

import com.nhn.board.vo.BoardEntity;

public interface BoardDao {
	List<BoardEntity> selectList() throws Exception;
	int insert(BoardEntity entity) throws Exception;
	BoardEntity selectOne(int bno) throws Exception;
	int update(BoardEntity entity) throws Exception;
	void delete(int bno) throws Exception;
}
