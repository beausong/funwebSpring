package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.BoardBean;
import com.springmvc.domain.PageBean;


public interface BoardService {

	public void write(BoardBean bb);

	public int getBoardCount();

	public List<BoardBean> list(PageBean pb);

}
