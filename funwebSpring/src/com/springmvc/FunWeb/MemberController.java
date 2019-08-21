package com.springmvc.FunWeb;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.domain.MemberBean;


@Controller
public class MemberController {

	
	@Inject
	com.springmvc.service.MemberService memberService;
//		MemberService memberService = new MemberServiceImpl();  => MemberServiceImpl 객체는 .xml 에서 생성해서 주입받을거임
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//	회원가입 가상주소 매핑 1. /member/insert - GET방식
	//	http://localhost:8080/myweb2/member/insert
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert(Locale locale, Model model) {  // insert() 메서드
		
		//	jsp페이지 이동
		//	/WEB-INF/views/member/insertForm.jsp
		return "/member/insertForm";
	}


	
	//	회원가입 가상주소 매핑 2. /member/insert - POST방식
	@RequestMapping(value = "/member/insert", method = RequestMethod.POST)
	public String insertPost(MemberBean mb) {
		
		// DB - insert
		memberService.insert(mb);

		// jsp 페이지 이동
		return "redirect:/member/login";  // 리다이렉트 방식
		
	}
	
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
//		http://localhost:8080/myweb2/member/login
		
//		/WEB-INF/views/member/loginForm.jsp
		return "/member/loginForm";
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String loginPost(MemberBean mb, HttpSession session) {
//		MemberService memberService=new MemberServiceImpl()
		//디비 memberService.login(mb)메서드호출
		MemberBean mb2=memberService.login(mb);
		//mb2 있으면  세션값 생성 
		if(mb2!=null) {
			session.setAttribute("id", mb.getId());
		}else {
			System.out.println("로그인 정보 틀림");
		}
//		가상주소 이동
//		/member/main
		return "redirect:/member/main";
	}
	
	// *** 화면을 띄우려면 GET 방식도 같이 만들어야 한다 ***
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete() {
		return "/member/deleteForm";
	}
	
	@RequestMapping(value = "/member/delete", method = RequestMethod.POST)
	public String deletePost(MemberBean mb, HttpSession session) {
		// http://localhost:8080/myweb2/member/delete
		MemberBean mb2 = memberService.login(mb);
		
		if(mb2 != null) {
			// 삭제 작업
			memberService.delete(mb);
			// 세션 초기화
			session.invalidate();
		} else {
			System.out.println("로그인 정보 틀림");
		}
		
		// 가상주소 이동
		return "redirect:/member/main";
		
	}
	
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list(Model model) {
		// http://localhost:8080/myweb2/member/list
		
		List<MemberBean> memberList = memberService.list();
		
		// model 회원정보 리스트(memberList) 저장해서 list.jsp 이동
		model.addAttribute("memberList", memberList);   // ("이름", 모든리스트형(?))
		
		// /WEB-INF/views/member/list.jsp
		return "/member/list";
	}
	
	
	
	

}

