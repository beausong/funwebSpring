package com.springmvc.FunWeb;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.domain.BoardBean;
import com.springmvc.domain.PageBean;
import com.springmvc.service.BoardService;


@Controller 
public class BoardController {
	
	@Inject
	BoardService boardService;
	Model model;
	
	// < 글 쓰기 페이지 - GET >
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)  // 1.
	public String write() {  // 2.
		
		// 1. 글쓰기 가상주소
		// http://localhost:8080/myweb2/board/write
		
		// 2. 패키지 com.itwillbs.controller - BoardController 자바 파일
		// 주소매핑 /board/write, GET, 메서드이름 write()
		
		// 3. jsp 페이지 이동
		// /WEB-INF/views/board/writeForm.jsp
		return "/board/writeForm";
		
	}
	
	// < 글 등록 DB - POST >
	@RequestMapping(value = "/board/write", method = RequestMethod.POST) // 1.
	public String writePost(BoardBean bb) {  // 2.
		
		// 1. 글쓰기 가상주소
		// http://localhost:8080/myweb2/board/write
				
		// 2. 패키지 com.itwillbs.service 만들고 추가
		// 	  => BoardService 인터페이스 상속받은 BoardServiceImpl 클래스
		//       리턴값 없음 write(bb)
		
		// 3. 패키지 com.itwillbs.dao 만들고 추가
		// 	  => BoardDAO 인터페이스 상속받은 BoardDAOImpl 클래스
		// (1) 리턴값 없음 : write(bb)
		// (2) 리턴값 int : Integer maxNum()
		
		// 4. src/main/resources - mappers 폴더 boardMapper.xml 파일 생성
		// (1) write
		// (2) maxNum
		
		// 5. 디비 boardService.write(bb) 메서드 호출
		boardService.write(bb);

		// 6. jsp 페이지 이동
		return "redirect:/board/list";  // 리다이렉트 방식
		
	}
	
	// < 글 목록 페이지 - GET >
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)  // 1.
	public String list( HttpServletRequest request) {  // 2.
		
		// 1. 글목록 가상주소
		// http://localhost:8080/myweb2/board/list
		
		// 2. 패키지 com.itwillbs.controller - BoardController 자바 파일
		// 주소매핑 /board/list, GET, 메서드이름 list()
		
		// 3. 패키지 com.itwillbs.domain - PageBean 자바 파일 생성
		PageBean pb = new PageBean();
		pb.setPageSize(10);
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pb.setPageNum(1);
		} else {
			pb.setPageNum(Integer.parseInt(pageNum));
		}
		
		// 4. 메서드 호출
		// (1) Integer getBoardCount() : select count(*) from board
		// (2) List<BoardBean> list(pb) : select * from board order by num desc limit ?,?  
		// 	   cf. (?,?) = (int startRow, int pageSize)
		int count = boardService.getBoardCount();
		pb.setCount(count);
		
		List<BoardBean> list = boardService.list(pb);
		
		// model에 데이터 저장해서 데이터 넘겨줌
		model.addAttribute("pb", pb);
		model.addAttribute("list", list);
		
		// jsp 페이지 이동 - /WEB-INF/views/board/list.jsp
		return "/board/list";
		
	}

}












