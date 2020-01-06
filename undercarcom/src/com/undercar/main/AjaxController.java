package com.undercar.main;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.undercar.util.io.ViewResolver;

public class AjaxController implements Controller {
	
	private Service memberIdCheckService;
	private Service memberPwCheckService;
	private Service carYearListService;
	private Service carGradeListService;
	private Service carSpecListService;
	private Service kModelListService;
	private Service hModelListService;
	private Service sModelListService;
	private Service ssModelListService;
	private Service gmModelListService;
	private Service brandSearchService;
	
//	public void setMemberIdCheckService(Service memberIdCheckService) {
//		this.memberIdCheckService = memberIdCheckService;
//	}
//	public void setMemberPwCheckService(Service memberPwCheckService) {
//		this.memberPwCheckService = memberPwCheckService;
//	}

	public AjaxController(Service carYearListService, Service carGradeListService, Service carSpecListService,
			Service memberIdCheckService, Service memberPwCheckService,Service kModelListService,
			Service hModelListService,Service sModelListService,Service ssModelListService,
			Service gmModelListService, Service brandSearchService) {
		this.carYearListService = carYearListService;
		this.carGradeListService = carGradeListService;
		this.carSpecListService = carSpecListService;
		this.memberIdCheckService = memberIdCheckService;
		this.memberPwCheckService = memberPwCheckService;
		this.kModelListService = kModelListService;
		this.hModelListService = hModelListService;
		this.sModelListService = sModelListService;
		this.ssModelListService = ssModelListService;
		this.gmModelListService = gmModelListService;
		this.brandSearchService = brandSearchService;
		}
	
	public AjaxController() {}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AjaxController.execute()");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		switch (uri) {
		//회원가입
		case "/ajax/idCheck.do":
			System.out.println("AjaxController.execute(). - idCheck");
			String id = (String)memberIdCheckService.service(new Object[] {request.getParameter("id")});
			if(id == null)
				out.print("<span style='color:blue'>사용 가능한 아이디 입니다.</span>");
			else
				out.print("<span style='color:red'>중복된 아이디 입니다.</span>");
			break;
		case "/ajax/pwCheck.do":
			System.out.println("AjaxController.execute(). - pwCheck");
			String inputPw = request.getParameter("pw");
			System.out.println(inputPw);
			String ids = request.getParameter("id");
			System.out.println(ids);
			String pw = (String)memberPwCheckService.service(new Object[] {ids});
			if(pw.equals(inputPw))
				out.print("<span style='color:blue'>일치하는 비밀번호 입니다.</span>");
			else
				out.print("<span style='color:red'>틀린 비밀번호 입니다.</span>");
			break;
			
		case "/ajax/modelGet.do":
			System.out.println("AjaxController.execute(). - modelGet");
			String brand = request.getParameter("brand");
			System.out.println("model : "+brand);
			
			if(brand.equals("현대")) request.setAttribute("model", Execute.service(hModelListService));
			if(brand.equals("기아")) request.setAttribute("model", Execute.service(kModelListService));
			if(brand.equals("르노삼성")) request.setAttribute("model", Execute.service(sModelListService));
			if(brand.equals("한국GM")) request.setAttribute("model", Execute.service(gmModelListService));
			if(brand.equals("쌍용")) request.setAttribute("model", Execute.service(ssModelListService));
			
			ViewResolver.forward(request, response, "sell/model");
			
			break;
		case "/ajax/yearGet.do":
			System.out.println("AjaxController.execute(). - yearGet");
			String model = request.getParameter("model");
			System.out.println("model : "+model);
			request.setAttribute("carmodel", Execute.service(carYearListService, model));
			System.out.println("request : "+request.getAttribute("carmodel"));
			
			ViewResolver.forward(request, response, "sell/year");
			
			break;
			
		case "/ajax/carGradeGet.do":
			System.out.println("AjaxController.execute(). - carGradeGet");
			String year = request.getParameter("year");
			System.out.println("year : "+year);
			request.setAttribute("cargrade", Execute.service(carGradeListService, year));
			System.out.println("request : "+request.getAttribute("cargrade"));
			
			ViewResolver.forward(request, response, "sell/cargrade");
			
			break;
			
		case "/ajax/specGet.do":
			System.out.println("AjaxController.execute(). - specGet");
			String carGrade = request.getParameter("carGrade");
			System.out.println("carGrade : "+carGrade);
			request.setAttribute("spec", Execute.service(carSpecListService, carGrade));
			System.out.println("request : "+request.getAttribute("spec"));
			
			ViewResolver.forward(request, response, "sell/spec");
			
			break;

		case "/ajax/photoGet.do":
			System.out.println("AjaxController.execute(). - specGet");
			brand = request.getParameter("brand");
			if(brand.equals("현대")) brand = "h";
			model = request.getParameter("model");
			year = request.getParameter("year");
			String grade = request.getParameter("carGrade");
			String spec = request.getParameter("spec");
			if(spec.equals("익스트림")) spec = "ex";
			
			String imagePath = "/upload/carimage/"+brand+"/"+model+"/"+year+"/"+grade+"_"+spec+".jpg";
			System.out.println("imagePath : "+imagePath);
			
			request.setAttribute("image", imagePath);
			
			ViewResolver.forward(request, response, "sell/carimage");
			
			break;
			
		case "/ajax/brandSearchList.do":
			
			brand = request.getParameter("brand");
			
			request.setAttribute("brandSearchList", Execute.service(brandSearchService, brand));
			
			System.out.println("ajaxControll.brandSearchList");
			
			ViewResolver.forward(request, response, "sell/brandSearchList");

			break;
			
		default:
			break;
		}
		return null;
	}

}
