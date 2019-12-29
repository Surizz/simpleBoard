package com.nhn.board.dao;

import java.util.List;

import com.nhn.board.vo.BoardEntity;

public interface BoardDao {
	List<BoardEntity> selectList() throws Exception;
	int insert(BoardEntity entity) throws Exception;
}
