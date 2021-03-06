package com.undercar.member.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.undercar.main.Controller;
import com.undercar.main.Execute;
import com.undercar.main.Service;
import com.undercar.member.dto.LoginDTO;
import com.undercar.member.dto.MemberDTO;
import com.undercar.util.mail.SendEmail;
import com.undercar.util.page.PageObject;

public class MemberController implements Controller {
	
	private Service loginService;
	private Service joinService;
	private Service infoService;
	private Service listService;
	private Service updateService;
	private Service pwUpdateService;
	private Service deleteService;
	private Service findIdService;
	private Service findPwService;
	
	
	public MemberController(Service loginService,Service joinService, Service infoService, Service listService, Service updateService, Service pwUpdateService, Service deleteService,
			Service findIdService, Service findPwService) {
		this.loginService = loginService;
		this.joinService = joinService;
		this.infoService = infoService;
		this.listService = listService;
		this.updateService = updateService;
		this.pwUpdateService = pwUpdateService;
		this.deleteService = deleteService;
		this.findIdService = findIdService;
		this.findPwService = findPwService;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		System.out.println("memberController");
		String jsp = "";
		HttpSession session = request.getSession(true);
		LoginDTO updateDTO = (LoginDTO) session.getAttribute("login");
		PageObject pageObject = PageObject.getInstance(request.getParameter("page"), request.getParameter("perPageNum"));
		
		// 검색에 대한 데이터 셋팅.
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		if(word != null) {
			pageObject.setKey(key);
			pageObject.setWord(word);
		}

		switch (uri) {
		case "/member/loginForm.do":
			// session의 msg를 request에 담고 session의 msg는 지운다.
				request.setAttribute("msg", session.getAttribute("msg"));
				session.removeAttribute("msg");
				jsp = "member/loginForm";
			break;
			
		case "/member/login.do":
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			LoginDTO dto = new LoginDTO();
			dto.setId(id);
			dto.setPw(pw);
			
			session.setAttribute("login", Execute.service(loginService, dto));
			System.out.println(session.getAttribute("login"));
			if(session.getAttribute("login") == null) {
				jsp="redirect:loginForm.do?fail=1";
			}else {
				// 정상적으로 로그인이 된 경우
				// 자동으로 리스트로 이동시켜야 한다.
				String nextURI = (String) session.getAttribute("nextURI");
				if(nextURI != null) {
					jsp = "redirect:"+nextURI;
					session.removeAttribute("nextURI");
				}else {
					jsp ="redirect:/main.do";
				}
			}
			
			
			break;
		case "/member/logout.do":
				session.invalidate();
			jsp = "redirect:/main.do";// 나중에 메인으로 가도록 만들어야함
			break;
		case "/member/joinForm.do":
			jsp = "member/joinForm";
			break;
		case "/member/join.do":
			System.out.println("MemberController.join.do");
			
			Integer bno, btel;
			id = request.getParameter("id");
			String btel1 = request.getParameter("btel");
			// 여러 데이터를 한번에 받을 때
			String[] tels = request.getParameterValues("tel");
			String tel = String.join("-", tels);
			String bno1 = request.getParameter("bno");
			
			if(bno1 == null && btel1 == null || bno1.equals("") && btel1.equals("")) {
				bno1="0";
				btel1="0";
			}
			bno = Integer.parseInt(bno1);
			btel = Integer.parseInt(btel1);
			
			Execute.service(joinService, getDTO(id, request.getParameter("pw"), request.getParameter("name"),
					request.getParameter("birth"), request.getParameter("gender"),
					tel, request.getParameter("email"), Integer.parseInt(request.getParameter("grade")),
					bno, request.getParameter("baddr"), request.getParameter("bname"), btel, request.getParameter("content")));
			jsp = "redirect:welcome.do?id="+id;
		
			break;
		case "/member/welcome.do":
			jsp = "member/welcome";
			break;
		case "/member/select.do":
			jsp = "member/select";
			break;
		case "/member/agree.do":
			jsp = "member/agree";
			break;
		case "/member/info.do":
			String sessionId = updateDTO.getId();
			request.setAttribute("dto", Execute.service(infoService, sessionId));
			
			jsp = "member/info";
			break;
		case "/member/list.do":
			request.setAttribute("pageObject", pageObject);
			request.setAttribute("list", Execute.service(listService, pageObject));
			
			jsp = "member/list";
			break;
		case "/member/updateForm.do":
			sessionId = updateDTO.getId();
			request.setAttribute("dto", Execute.service(infoService, sessionId));
			
			jsp = "member/updateForm";
			break;
		case "/member/update.do":
			id = request.getParameter("id");
			int grade = updateDTO.getGrade();
			btel1 = request.getParameter("btel");
			// 여러 데이터를 한번에 받을 때
			tels = request.getParameterValues("tel");
			tel = String.join("-", tels);
			bno1 = request.getParameter("bno");
			
			if(bno1 == null && btel1 == null || bno1.equals("") && btel1.equals("")) {
				bno1="0";
				btel1="0";
			}
			bno = Integer.parseInt(bno1);
			btel = Integer.parseInt(btel1);
			Execute.service(updateService, getDTO(id, request.getParameter("pw"), tel, request.getParameter("email"), bno, request.getParameter("baddr"), request.getParameter("bname"),
					btel, request.getParameter("content")));
			
			jsp = "redirect:info.do?grade="+grade;
			break;

		case "/member/pwUpdate.do":
			pw = request.getParameter("pw");
			sessionId = updateDTO.getId();
			grade = updateDTO.getGrade();
			String pwd = request.getParameter("pwd");
			Execute.service(pwUpdateService, sessionId, pw, pwd);
			
			jsp = "redirect:info.do?grade="+grade;
			break;
		case "/member/pwUpdateForm.do":
			jsp = "member/pwUpdateForm";
			break;
		case "/member/delete.do":
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			Execute.service(deleteService, id, pw);
			session.invalidate();
			jsp = "redirect:/main.do";//나중에 메인으로 가게 만들어야함
			break;
		case "/member/findIdForm.do":
			jsp = "member/findIdForm";
			break;
		case "/member/findPwForm.do":
			jsp = "member/findPwForm";
			break;
		case "/member/findId.do":
			
			String findId = (String) Execute.service(findIdService, request.getParameter("email"));
			
			if(findId == null){
				jsp = "redirect:findIdForm.do?check=1";
			}else {
				SendEmail.gmailSend("언더카 아이디 찾기 확인용 이메일 입니다.", "고객님의 아이디는 " + findId + " 입니다.", request.getParameter("email"));
				jsp = "redirect:loginForm.do?check=2";
			}
			break;
		case "/member/findPw.do":
			
			String findPw = (String) Execute.service(findPwService, request.getParameter("id"), request.getParameter("email"));
			System.out.println(findPw);
			if(findPw == null){
				jsp = "redirect:findPwForm.do?check=1";
			}else {
				SendEmail.gmailSend("언더카 비밀번호 찾기 확인용 이메일 입니다.", "고객님의 비밀번호는 " + findPw + " 입니다.", request.getParameter("email"));
				jsp = "redirect:loginForm.do?check=2";
			}
			break;
			
		default:
			break;
		}
		return jsp;
	}
	// 멤버 등록을 위한 getDTO()
	private MemberDTO getDTO(String id, String pw,String name, String birth, String gender, String tel,
			String email, int grade, int bno, String baddr, String bname, int btel, String content) {
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.setBirth(birth);
		dto.setGender(gender);
		dto.setTel(tel);
		dto.setEmail(email);
		dto.setGrade(grade);;
		dto.setBno(bno);
		dto.setBaddr(baddr);
		dto.setBname(bname);
		dto.setBtel(btel);
		dto.setContent(content);
		
		return dto;
	}
	// 멤버 수정을 위한 getDTO()
	private MemberDTO getDTO(String id, String pw, String tel, String email, int bno, String baddr, String bname, int btel, String content) {
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPw(pw);
		dto.setTel(tel);
		dto.setEmail(email);
		dto.setBno(bno);
		dto.setBaddr(baddr);
		dto.setBname(bname);
		dto.setBtel(btel);
		dto.setContent(content);
		return dto;
	}

}
