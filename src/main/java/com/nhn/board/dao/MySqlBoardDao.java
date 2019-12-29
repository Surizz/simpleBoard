package com.nhn.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nhn.board.vo.BoardEntity;

@Repository("boardDao")
public class MySqlBoardDao implements BoardDao{	
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public List<BoardEntity> selectList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try {
			return sqlSession.selectList("com.nhn.board.dao.BoardDao.selectList");
		} finally {
			sqlSession.close();
		}
	}
		
}
