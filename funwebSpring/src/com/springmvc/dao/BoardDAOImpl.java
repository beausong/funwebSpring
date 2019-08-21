package com.springmvc.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.BoardBean;
import com.springmvc.domain.PageBean;


@Repository
public class BoardDAOImpl implements BoardDAO {

	// DB 연동 (mybatis 사용)
	// => root-context.xml 에 생성한 mybatis 객체 받아서 사용 : @Inject 붙여주기
	@Inject
	private SqlSession sqlSession; 
	
	private static final String namespace = "com.itwillbs.mapper.BoardMapper";

	// DB 작업
	// => boardMapper.xml 에 저장된 DB 작업을 아이디로 불러 사용
	@Override
	public Integer maxNum() {
		return sqlSession.selectOne(namespace+".maxNum");   // ".아이디이름"
	}

	@Override
	public void write(BoardBean bb) {
		sqlSession.insert(namespace + ".write", bb);
	}

	@Override
	public int getBoardCount() {
		return sqlSession.selectOne(namespace+".getBoardCount");
	}

	@Override
	public List<BoardBean> list(PageBean pb) {
		return sqlSession.selectList(namespace+".list", pb);
	}

}
