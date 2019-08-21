package com.springmvc.dao;

import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.MemberBean;


@Repository
public class MemberDAOImpl implements MemberDAO {
	
		//	
		//	//스프링에서 DB 연동 정보를 받아서 sql 구문을 실행하는 프로그램(JdbcTemplate) 사용 
		//	JdbcTemplate jdbcTemplate;
		//	
		//	// DB 연동 => root-context.xml 에 객체 생성한거 받아서 사용 == @Inject 붙여주기
		//	@Inject
		//	public void setDataSource(DataSource dataSource) {
		//		jdbcTemplate = new JdbcTemplate(dataSource);
		//	}
	
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mapper.MemberMapper";
	
	
	//--- insert ---
	//String insertsql = "INSERT INTO member(id,pass,name,reg_date) VALUES(?,?,?,?)";
	@Override
	public void insert(MemberBean mb) {
		System.out.println("MemberDAOImpl insert(mb)");
		// "'"+${name}+"'"
		// insertsql 실행
		// jdbcTemplate.update(insertsql, mb.getId(), mb.getPass(), mb.getName(), mb.getReg_date());
		
		sqlSession.insert(namespace+".insert",mb);
		
		// sqlSession.selectList(statement);
		// sqlSession.selectOne(statement);
	}


	@Override
	public MemberBean login(MemberBean mb) {
		return sqlSession.selectOne(namespace+".login", mb);
	}


	@Override
	public MemberBean info(String id) {
		return sqlSession.selectOne(namespace+".info",id);
	}


	@Override
	public void update(MemberBean mb) {
		sqlSession.update(namespace+".update", mb);
	}


	@Override
	public void delete(MemberBean mb) {
		sqlSession.delete(namespace+".delete", mb);
	}


	@Override
	public List<MemberBean> list() {
		return sqlSession.selectList(namespace+".list");
	}
	
	
	
	
	
	
}
