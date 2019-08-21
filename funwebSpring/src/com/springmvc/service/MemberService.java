package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.MemberBean;


public interface MemberService {
	
	public void insert(MemberBean mb);

	public MemberBean login(MemberBean mb);

	public MemberBean info(String id);

	public void update(MemberBean mb);
	
	public void delete(MemberBean mb);

	public List<MemberBean> list();



}
