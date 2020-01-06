package com.undercar.main;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.undercar.bean.Beans;

import static com.undercar.util.io.ViewResolver.forward;

/**
 * Servlet implementation class FrontController
 */
//@WebServlet("/FrontController") --> web.xml에서 설정
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Controller mainController = Beans.getController("mainController");
	private Controller noticeController = Beans.getController("noticeController");
	private Controller eventController = Beans.getController("eventController");
	private Controller memberController = Beans.getController("memberController");
	private Controller sellController = Beans.getController("sellController");
	private Controller qnaController = Beans.getController("qnaController");
	private Controller faqController = Beans.getController("faqController");
	private Controller messageController = Beans.getController("messageController");
	private Controller ajaxController = Beans.getController("ajaxController");
	private Controller errorController = Beans.getController("errorController");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	String jsp;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("FrontController.service()");

		try {
			String uri = request.getServletPath();
			System.out.println("FrontController.service().uri : " + uri);

			if (uri.indexOf("/notice") == 0) {
				System.out.println("Notice 처리");
				jsp = noticeController.execute(request, response, uri);
			} else if (uri.indexOf("/event") == 0) {
				System.out.println("Event 처리");
				jsp = eventController.execute(request, response, uri);
			}else if(uri.indexOf("/member") == 0) {
				System.out.println("Member 처리");
				jsp = memberController.execute(request, response, uri);
			}else if(uri.indexOf("/sell") == 0) {
				System.out.println("Sell 처리");
				jsp = sellController.execute(request, response, uri);
			}else if(uri.indexOf("/qna") == 0) {
				System.out.println("qna 처리");
				jsp = qnaController.execute(request, response, uri);
			}else if(uri.indexOf("/faq") == 0) {
				System.out.println("faq 처리");
				jsp = faqController.execute(request, response, uri);
			}else if(uri.indexOf("/message") == 0) {
				System.out.println("message 처리");
				jsp = messageController.execute(request, response, uri);
			}else if(uri.indexOf("/main") == 0) {
				System.out.println("main 처리");
				jsp = mainController.execute(request, response, uri);
			}else if(uri.indexOf("/error") == 0) {
				System.out.println("오류 페이지 처리");
				jsp = errorController.execute(request, response, uri);
			}else if(uri.indexOf("/ajax")== 0) {
				//ajax인 경우 주로 jsp를 만들지 않고 데이터를 그대로 보낸다.
				System.out.println("Ajax처리");
				ajaxController.execute(request, response, uri);
				return;

			}else {
				System.out.println("404에러 없는 페이지 요청");
			}

			forward(request, response, jsp);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
	}// end of FrontController.service()

}// end of FrontConroller Servlet
