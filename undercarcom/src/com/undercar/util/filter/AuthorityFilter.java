package com.undercar.util.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.undercar.member.dto.LoginDTO;

/**
 * Servlet Filter implementation class AuthorityFilter
 */
@WebFilter("/AuthorityFilter")
public class AuthorityFilter implements Filter {
	
	// 로그인 처리가 되어야 하는 URL을 저장하는 변수
	private List<String> loginList = new ArrayList<String>();
	// URL에 따른 권한을 저장하는 변수 
	private Map<String, Integer> authMap = new HashMap<String, Integer>();

	/**
	 * Default constructor.
	 */
	public AuthorityFilter() {
		// TODO Auto-generated constructor stub
    	// 로그인 해야할 URL 등록
		loginList.add("/member/logout.do");
		loginList.add("/member/pwdForm.do");
		loginList.add("/member/delete.do");
		loginList.add("/member/information.do");
		loginList.add("/member/updateForm.do");
		loginList.add("/member/update.do");
		loginList.add("/member/memberList.do");

		loginList.add("/notice/writeForm.do");
		loginList.add("/notice/write.do");
		loginList.add("/notice/updateForm.do");
		loginList.add("/notice/update.do");
		loginList.add("/notice/delete.do");

		loginList.add("/event/writeForm.do");
		loginList.add("/event/write.do");
		loginList.add("/event/updateForm.do");
		loginList.add("/event/update.do");
		loginList.add("/event/delete.do");
		
		loginList.add("/sell/writeForm.do");
		loginList.add("/sell/write.do");
		loginList.add("/sell/updateForm.do");
		loginList.add("/sell/update.do");
		loginList.add("/sell/delete.do");
		
		loginList.add("/qna/list.do");
		loginList.add("/qna/view.do");
		loginList.add("/qna/writeForm.do");
		loginList.add("/qna/wirte.do");
		loginList.add("/qna/updateForm.do");
		loginList.add("/qna/update.do");
		loginList.add("/qna/delete.do");
		
		loginList.add("/faq/writeForm.do");
		loginList.add("/faq/wirte.do");
//		loginList.add("/faq/view.do");
		loginList.add("/faq/updateForm.do");
		loginList.add("/faq/update.do");
		loginList.add("/faq/delete.do");

		loginList.add("/message/list.do");
		loginList.add("/message/view.do");
		loginList.add("/message/writeForm.do");
		loginList.add("/message/write.do");
		loginList.add("/message/delete.do");
		
    	// 권한 map에 권한이 필요한 URL 등록 - 일반회원(1)은 등록하지 않는다.(로그인이 되어 있는지로 확인가능)
		authMap.put("/member/memberList.do", 9);
		
		authMap.put("/notice/writeForm.do", 9);
		authMap.put("/notice/write.do", 9);
		authMap.put("/notice/updateForm.do", 9);
		authMap.put("/notice/update.do", 9);
		authMap.put("/notice/delete.do", 9);
		
		authMap.put("/event/writeForm.do", 9);
		authMap.put("/event/write.do", 9);
		authMap.put("/event/updateForm.do", 9);
		authMap.put("/event/update.do", 9);
		authMap.put("/event/delete.do", 9);
		
		authMap.put("/qna/writeForm.do", 1);
		authMap.put("/qna/wirte.do", 1);
		authMap.put("/qna/updateForm.do", 1);
		authMap.put("/qna/update.do", 1);
		authMap.put("/qna/delete.do", 1);
		
		authMap.put("/faq/writeForm.do", 9);
		authMap.put("/faq/wirte.do", 9);
		authMap.put("/faq/updateForm.do", 9);
		authMap.put("/faq/update.do", 9);
		authMap.put("/faq/delete.do", 9);
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("AuthorityFilter.doFilter");

		// 객체 캐스팅 : ServletRequest -> HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		// req에서 session 꺼내기
		HttpSession session = req.getSession();

		// req에서 session 꺼내와서 Login 정보 가져오기
		LoginDTO login = (LoginDTO) session.getAttribute("login");

		// URI 가져오기
		String uri = req.getServletPath();
		System.out.println("AuthorityFilter.doFilter.uri:" + uri);

		// 로그인이 안되 있고 로그인이 필요한 경우 바로 로그인 페이지로 이동시킨다.
		if (login == null && loginRequire(uri)) {
			// 로그인이 성공적으로 되었을 때 요청한 uri를 세션에 저장해 놓았다가
			// 바로 이동하도록 하기 위해 uri를 저장해 놓는다.
			session.setAttribute("nextURI", uri);
			session.setAttribute("msg", "<span style='color:red'>로그인이 필요한 페이지입니다.</span>");
			res.sendRedirect("/member/loginForm.do");
			return; // 아래 부분은 처리가 안된다.
		}

		// 지정한 권한 이상이여야만 처리되도록 하는 부분으로 권한 미만인 경우 권한 부족 페이지로 이동시킨다.
		if (login != null && !checkAuth(login.getGrade(), uri)) {
			res.sendRedirect("/views/error/nonAuth.do");
			return; // 아래 부분은 처리가 안된다.
		}

		// pass the request along the filter chain
		// 여기가 요청한 처리로 이동하게 하는 부분
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	// 로그인이 필요한지 알아 내는 메서드
	private boolean loginRequire(String uri) {
		for (String str : loginList) {
			if (uri.equals(str))
				return true;
		}

		return false;
	}// end of loginRequire()

	// 권한이 있는지 알아 내는 메서드
	private boolean checkAuth(int userGrade, String uri) {
		Integer pageGrade = authMap.get(uri);
		if (pageGrade == null || userGrade >= pageGrade)
			return true;
		return false;
	}// end of checkAuth()

}
