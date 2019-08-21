package com.springmvc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.springmvc.dao.BoardDAO;
import com.springmvc.domain.BoardBean;
import com.springmvc.domain.PageBean;


@Service
public class BoardServiceImpl implements BoardService {

	@Inject   // 자동으로 BoardDAOImpl 객체 생성
	BoardDAO boardDAO;
	
	@Override
	public void write(BoardBean bb) {
		// 글번호 구해서 저장
		bb.setNum(boardDAO.maxNum()+1);
		// 글 등록
		boardDAO.write(bb);
	}

	@Override
	public int getBoardCount() {
		return boardDAO.getBoardCount();
	}

	@Override
	public List<BoardBean> list(PageBean pb) {
		// startRow : 시작 행 번호 = (현재페이지 - 1) * 페이지크기
		pb.setStartRow((pb.getPageNum() - 1) * pb.getPageSize());  
		return boardDAO.list(pb);
	}

}
