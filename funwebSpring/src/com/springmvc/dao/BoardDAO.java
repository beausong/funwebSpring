package com.springmvc.dao;

import java.util.List;

import com.springmvc.domain.BoardBean;
import com.springmvc.domain.PageBean;


public interface BoardDAO {

	public Integer maxNum();  // 리턴값 int 해도 상관없음 (자동 형변환해준다)

	public void write(BoardBean bb);

	public int getBoardCount();

	public List<BoardBean> list(PageBean pb);

}
