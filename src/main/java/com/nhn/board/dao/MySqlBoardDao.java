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
	public List<BoardEntity> selectList() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try {
			return sqlSession.selectList("com.nhn.board.dao.BoardDao.selectList");
		} finally {
			sqlSession.close();
		}
	}
	
	@Override
	public int insert(BoardEntity entity) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try {
			sqlSession.insert("com.nhn.board.dao.BoardDao.insert", entity);
			sqlSession.commit();
			return entity.getBno();
		} finally {
			sqlSession.close();
		}
	}
	
	@Override
	public BoardEntity selectOne(int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		try {
			return sqlSession.selectOne("com.nhn.board.dao.BoardDao.selectOne", bno);
		} finally {
			sqlSession.close();
		}
	}
	
	@Override
	public int update(BoardEntity entity) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		try {
			int count = sqlSession.update("com.nhn.board.dao.BoardDao.update", entity);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}
	
	@Override
	public void delete(int bno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try {
			sqlSession.delete("com.nhn.board.dao.BoardDao.delete", bno);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
