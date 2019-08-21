package com.springmvc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.springmvc.dao.MemberDAO;
import com.springmvc.domain.MemberBean;



@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	MemberDAO memberDao;
	// MemberDAO memberDAO = new MemberDAOImpl();

	public void insert(MemberBean mb) {
		System.out.println("MemberServiceImpl - insert(mb)");
		
		memberDao.insert(mb);
		
	}

	@Override
	public MemberBean login(MemberBean mb) {
		return memberDao.login(mb);
	}

	@Override
	public MemberBean info(String id) {
		return memberDao.info(id);
	}

	@Override
	public void update(MemberBean mb) {
		memberDao.update(mb);
	}

	@Override
	public void delete(MemberBean mb) {
		memberDao.delete(mb);
		
	}

	@Override
	public List<MemberBean> list() {
		return memberDao.list();
	}
	
	

}
