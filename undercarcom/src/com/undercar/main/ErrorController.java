package com.undercar.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		// TODO Auto-generated method stub
		
		String jsp="";
		
		switch (uri) {
		case "/error/nonAuth.do":
			jsp = "error/nonAuth";
			break;

		default:
			break;
		}
		return jsp;
	}

}
