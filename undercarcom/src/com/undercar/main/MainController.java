package com.undercar.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.undercar.util.page.PageObject;

public class MainController implements Controller {
	
	private Service sellListService;
	private Service carBrandListService;
	private Service carClassListService;
	private Service kModelListService;
	private Service hModelListService;
	private Service sModelListService;
	private Service ssModelListService;
	private Service gmModelListService;

	public MainController(Service sellListService, Service carBrandListService, Service carClassListService, Service kModelListService, 
			Service hModelListService, Service sModelListService, Service ssModelListService, Service gmModelListService) {
		this.sellListService = sellListService;
		this.carBrandListService = carBrandListService;
		this.carClassListService = carClassListService;
		this.kModelListService = kModelListService;
		this.hModelListService = hModelListService;
		this.sModelListService = sModelListService;
		this.ssModelListService = ssModelListService;
		this.gmModelListService = gmModelListService;
		}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MainController.execute()");
//		String jsp = "";
//		PageObject pageObject = PageObject.getInstance(request.getParameter("page"), request.getParameter("strPerPageNum"));
//		// 검색
//		String key = request.getParameter("key");
//		String word = request.getParameter("word");
//		if(word != null) {
//			pageObject.setKey(key);
//			pageObject.setWord(word);
//		}// end of if
//		 
//		switch (uri) {
//		case "/main.do":
			System.out.println("MainController.execute(). - main");
//			request.setAttribute("pageObject", pageObject);
			PageObject pageObject = new PageObject(1,1);
			request.setAttribute("list", Execute.service(sellListService, pageObject));
			request.setAttribute("carBrandList", Execute.service(carBrandListService));
			request.setAttribute("carClassList", Execute.service(carClassListService));
			request.setAttribute("modelList", Execute.service(kModelListService));
			request.setAttribute("modelList", Execute.service(hModelListService));
			request.setAttribute("modelList", Execute.service(sModelListService));
			request.setAttribute("modelList", Execute.service(ssModelListService));
			request.setAttribute("modelList", Execute.service(gmModelListService));
//			request.setAttribute("categoryList", Execute.service(sellListService));
//			jsp = "main/main";
			
//			break;

//		default:
//			break;
//		}
		return "main/main";
	}

}
