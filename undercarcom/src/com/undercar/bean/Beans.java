package com.undercar.bean;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.undercar.event.controller.EventController;
import com.undercar.event.dao.EventDAO;
import com.undercar.event.service.EventDeleteService;
import com.undercar.event.service.EventListService;
import com.undercar.event.service.EventUpdateService;
import com.undercar.event.service.EventViewService;
import com.undercar.event.service.EventWriteService;
import com.undercar.faq.controller.FaqController;
import com.undercar.faq.dao.FaqDAO;
import com.undercar.faq.service.FaqDeleteService;
import com.undercar.faq.service.FaqListService;
import com.undercar.faq.service.FaqUpdateService;
import com.undercar.faq.service.FaqViewService;
import com.undercar.faq.service.FaqWriteService;
import com.undercar.main.AjaxController;
import com.undercar.main.Controller;
import com.undercar.main.ErrorController;
import com.undercar.main.MainController;
import com.undercar.main.Service;
import com.undercar.notice.controller.NoticeController;
import com.undercar.notice.dao.NoticeDAO;
import com.undercar.notice.service.NoticeDeleteService;
import com.undercar.notice.service.NoticeListService;
import com.undercar.notice.service.NoticeUpdateService;
import com.undercar.notice.service.NoticeViewService;
import com.undercar.notice.service.NoticeWriteService;
import com.undercar.qna.controller.QnaController;
import com.undercar.qna.dao.QnaDAO;
import com.undercar.qna.service.QnaAdminListService;
import com.undercar.qna.service.QnaAnswerService;
import com.undercar.qna.service.QnaDeleteService;
import com.undercar.qna.service.QnaListService;
import com.undercar.qna.service.QnaUpdateService;
import com.undercar.qna.service.QnaViewService;
import com.undercar.qna.service.QnaWriteService;
import com.undercar.sell.controller.SellController;
import com.undercar.sell.dao.SellDAO;
import com.undercar.sell.service.AttachmentDeleteService;
import com.undercar.sell.service.AttachmentWriteService;
import com.undercar.sell.service.BrandSearchService;
import com.undercar.sell.service.CarBrandListService;
import com.undercar.sell.service.CarClassListService;
import com.undercar.sell.service.CarGradeListService;
import com.undercar.sell.service.CarSpecListService;
import com.undercar.sell.service.CarYearListService;
import com.undercar.sell.service.CaroptionDeleteService;
import com.undercar.sell.service.CaroptionWriteService;
import com.undercar.sell.service.CategoryDeleteService;
import com.undercar.sell.service.CategoryWriteService;
import com.undercar.sell.service.GmModelListService;
import com.undercar.sell.service.HModelListService;
import com.undercar.sell.service.KModelListService;
import com.undercar.sell.service.SModelListService;
import com.undercar.sell.service.SellCategoryUpdateService;
import com.undercar.sell.service.SellCompleteService;
import com.undercar.sell.service.SellDeleteService;
import com.undercar.sell.service.SellFileUpdateService;
import com.undercar.sell.service.SellListService;
import com.undercar.sell.service.SellOptionUpdateService;
import com.undercar.sell.service.SellSchListService;
import com.undercar.sell.service.SellUpdateService;
import com.undercar.sell.service.SellViewService;
import com.undercar.sell.service.SellWriteService;
import com.undercar.sell.service.SsModelListService;
import com.undercar.member.controller.MemberController;
import com.undercar.member.dao.MemberDAO;
import com.undercar.member.service.MemberDeleteService;
import com.undercar.member.service.MemberFindIdService;
import com.undercar.member.service.MemberFindPwService;
import com.undercar.member.service.MemberIdCheckService;
import com.undercar.member.service.MemberInfoService;
import com.undercar.member.service.MemberJoinService;
import com.undercar.member.service.MemberListService;
import com.undercar.member.service.MemberLoginService;
import com.undercar.member.service.MemberPwCheckService;
import com.undercar.member.service.MemberPwUpdateService;
import com.undercar.member.service.MemberUpdateService;
import com.undercar.message.controller.MessageController;
import com.undercar.message.dao.MessageDAO;
import com.undercar.message.service.MessageAllCheckUpdateService;
import com.undercar.message.service.MessageAllUpdateService;
import com.undercar.message.service.MessageDeleteService;
import com.undercar.message.service.MessageListService;
import com.undercar.message.service.MessageUpdateStatusService;
import com.undercar.message.service.MessageViewService;
import com.undercar.message.service.MessageWriteService;

/**
 * Servlet implementation class Beans
 */
@WebServlet(urlPatterns = "/init", loadOnStartup = 1)
public class Beans extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Map<String, Controller> controllers = new HashMap<>();
	private static Map<String, Service> services  = new HashMap<>();
	private static Map<String, Object> daos = new HashMap<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Beans() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

		System.out.println("Beans.init() -- {}");
		System.out.println("객체 초기화 중--------------------");
		
		//--------------member----------------
		daos.put("memberDAO", new MemberDAO());
		services.put("memberLoginService", new MemberLoginService((MemberDAO) daos.get("memberDAO")));
		services.put("memberJoinService", new MemberJoinService((MemberDAO) daos.get("memberDAO")));
		services.put("memberIdCheckService", new MemberIdCheckService((MemberDAO) daos.get("memberDAO")));
		services.put("memberPwCheckService", new MemberPwCheckService((MemberDAO) daos.get("memberDAO")));
		services.put("memberInfoService", new MemberInfoService((MemberDAO) daos.get("memberDAO")));
		services.put("memberListService", new MemberListService((MemberDAO) daos.get("memberDAO")));
		services.put("memberUpdateService", new MemberUpdateService((MemberDAO) daos.get("memberDAO")));
		services.put("memberPwUpdateService", new MemberPwUpdateService((MemberDAO) daos.get("memberDAO")));
		services.put("memberDeleteService", new MemberDeleteService((MemberDAO) daos.get("memberDAO")));
		services.put("memberFindIdService", new MemberFindIdService((MemberDAO) daos.get("memberDAO")));
		services.put("memberFindPwService", new MemberFindPwService((MemberDAO) daos.get("memberDAO")));
		controllers.put("memberController", new MemberController(services.get("memberLoginService"),
				services.get("memberJoinService"),
				services.get("memberInfoService"),
				services.get("memberListService"),
				services.get("memberUpdateService"),
				services.get("memberPwUpdateService"),
				services.get("memberDeleteService"),
				services.get("memberFindIdService"),
				services.get("memberFindPwService")));

		//--------------message----------------
		//*************dao********************
		daos.put("messageDAO", new MessageDAO());
		//*************servie********************
		services.put("messageListService", new MessageListService((MessageDAO) daos.get("messageDAO")));
		services.put("messageViewService", new MessageViewService((MessageDAO) daos.get("messageDAO")));
		services.put("messageWriteService", new MessageWriteService((MessageDAO) daos.get("messageDAO")));
		services.put("messageUpdateStatusService", new MessageUpdateStatusService((MessageDAO) daos.get("messageDAO")));
		services.put("messageAllUpdateService", new MessageAllUpdateService((MessageDAO) daos.get("messageDAO")));
		services.put("messageAllCheckUpdateService", new MessageAllCheckUpdateService((MessageDAO) daos.get("messageDAO")));
		services.put("messageDeleteService", new MessageDeleteService((MessageDAO) daos.get("messageDAO")));
		services.put("memberListService", new MemberListService((MemberDAO) daos.get("memberDAO")));
		//*************controller********************
		controllers.put("messageController", 
				new MessageController(services.get("messageListService"),
						services.get("messageViewService"),
						services.get("messageWriteService"),
						services.get("messageUpdateStatusService"),
						services.get("messageAllUpdateService"),
						services.get("messageAllCheckUpdateService"),
						services.get("messageDeleteService"),
						services.get("memberListService")));
		
		//--------------notice----------------
		daos.put("noticeDAO", new NoticeDAO());
				
		services.put("noticeListService", new NoticeListService((NoticeDAO) daos.get("noticeDAO")));
		services.put("noticeViewService", new NoticeViewService((NoticeDAO) daos.get("noticeDAO")));
		services.put("noticeWriteService", new NoticeWriteService((NoticeDAO) daos.get("noticeDAO")));
		services.put("noticeUpdateService", new NoticeUpdateService((NoticeDAO) daos.get("noticeDAO")));
		services.put("noticeDeleteService", new NoticeDeleteService((NoticeDAO) daos.get("noticeDAO")));
				
		controllers.put("noticeController",
				new NoticeController(
						services.get("noticeListService"),
						services.get("noticeViewService"),
						services.get("noticeWriteService"),
						services.get("noticeUpdateService"),
						services.get("noticeDeleteService")));
		
		//--------------event----------------
		daos.put("eventDAO", new EventDAO());
				
		services.put("eventListService", new EventListService((EventDAO) daos.get("eventDAO")));
		services.put("eventViewService", new EventViewService((EventDAO) daos.get("eventDAO")));
		services.put("eventWriteService", new EventWriteService((EventDAO) daos.get("eventDAO")));
		services.put("eventUpdateService", new EventUpdateService((EventDAO) daos.get("eventDAO")));
		services.put("eventDeleteService", new EventDeleteService((EventDAO) daos.get("eventDAO")));
						
		controllers.put("eventController",
				new EventController(
						services.get("eventListService"),
						services.get("eventViewService"),
						services.get("eventWriteService"),
						services.get("eventUpdateService"),
						services.get("eventDeleteService")));
		
		
		//---------------------------------------------------------------------------------------------------
		// *** qna ***
		daos.put("qnaDAO", new QnaDAO());
		
		services.put("qnaListService", new QnaListService((QnaDAO) daos.get("qnaDAO")));
		services.put("qnaViewService", new QnaViewService((QnaDAO) daos.get("qnaDAO")));
		services.put("qnaWriteService", new QnaWriteService((QnaDAO) daos.get("qnaDAO")));
		services.put("qnaUpdateService", new QnaUpdateService((QnaDAO) daos.get("qnaDAO")));
		services.put("qnaDeleteService", new QnaDeleteService((QnaDAO) daos.get("qnaDAO")));
		services.put("qnaAnswerService", new QnaAnswerService((QnaDAO) daos.get("qnaDAO")));
		services.put("qnaAdminListService", new QnaAdminListService((QnaDAO) daos.get("qnaDAO")));
		
		controllers.put("qnaController",
				new QnaController(
						services.get("qnaListService"),
						services.get("qnaViewService"),
						services.get("qnaWriteService"),
						services.get("qnaUpdateService"),
						services.get("qnaDeleteService"),
				        services.get("qnaAnswerService"),
				        services.get("qnaAdminListService")
				        
						)); 
		//---------------------------------------------------------------------------------------------------
		// *** faq ***
		daos.put("faqDAO", new FaqDAO());
		
		services.put("faqListService", new FaqListService((FaqDAO) daos.get("faqDAO")));
		services.put("faqViewService", new FaqViewService((FaqDAO) daos.get("faqDAO")));
		services.put("faqWriteService", new FaqWriteService((FaqDAO) daos.get("faqDAO")));
		services.put("faqUpdateService", new FaqUpdateService((FaqDAO) daos.get("faqDAO")));
		services.put("faqDeleteService", new FaqDeleteService((FaqDAO) daos.get("faqDAO")));
		
		controllers.put("faqController",
				new FaqController(
						services.get("faqListService"),
						services.get("faqViewService"),
						services.get("faqWriteService"),
						services.get("faqUpdateService"),
						services.get("faqDeleteService")));
		
		//----------------------------------------------------------------------------------------------------------------
		// *** Sell ***
		
		daos.put("sellDAO", new SellDAO());
		
		services.put("sellListService", 
				new SellListService((SellDAO) daos.get("sellDAO")));
		services.put("carBrandListService",
				new CarBrandListService((SellDAO) daos.get("sellDAO")));
		services.put("sellWriteService", 
				new SellWriteService((SellDAO) daos.get("sellDAO")));
		services.put("carClassListService",
				new CarClassListService((SellDAO) daos.get("sellDAO")));
		services.put("kModelListService",
				new KModelListService((SellDAO) daos.get("sellDAO")));
		services.put("hModelListService",
				new HModelListService((SellDAO) daos.get("sellDAO")));
		services.put("sModelListService",
				new SModelListService((SellDAO) daos.get("sellDAO")));
		services.put("ssModelListService",
				new SsModelListService((SellDAO) daos.get("sellDAO")));
		services.put("gmModelListService",
				new GmModelListService((SellDAO) daos.get("sellDAO")));
		services.put("sellWriteService",
				new SellWriteService((SellDAO) daos.get("sellDAO")));
		services.put("attachmentWriteService",
				new AttachmentWriteService((SellDAO) daos.get("sellDAO")));
		services.put("caroptionWriteService",
				new CaroptionWriteService((SellDAO) daos.get("sellDAO")));
		services.put("sellViewService",
				new SellViewService((SellDAO) daos.get("sellDAO")));
		services.put("categoryWriteService",
				new CategoryWriteService((SellDAO) daos.get("sellDAO")));
		services.put("sellDeleteService",
				new SellDeleteService((SellDAO) daos.get("sellDAO")));
		services.put("sellSchListService",
				new SellSchListService((SellDAO) daos.get("sellDAO")));
		services.put("attachmentDeleteService",
				new AttachmentDeleteService((SellDAO) daos.get("sellDAO")));
		services.put("categoryDeleteService",
				new CategoryDeleteService((SellDAO) daos.get("sellDAO")));
		services.put("caroptionDeleteService",
				new CaroptionDeleteService((SellDAO) daos.get("sellDAO")));
		
		services.put("sellUpdateService",
				new SellUpdateService((SellDAO) daos.get("sellDAO")));
		services.put("sellOptionUpdateService",
				new SellOptionUpdateService((SellDAO) daos.get("sellDAO")));
		services.put("sellCategoryUpdateService",
				new SellCategoryUpdateService((SellDAO) daos.get("sellDAO")));
		services.put("sellFileUpdateService",
				new SellFileUpdateService((SellDAO) daos.get("sellDAO")));
		
		services.put("sellcompleteService",
				new SellCompleteService((SellDAO) daos.get("sellDAO")));

		controllers.put("sellController", 
				new SellController(
						services.get("sellListService"),
						services.get("carBrandListService"),
						services.get("carClassListService"),
						services.get("kModelListService"),
						services.get("hModelListService"),
						services.get("sModelListService"),
						services.get("ssModelListService"),
						services.get("gmModelListService"),
						services.get("sellWriteService"),
						services.get("attachmentWriteService"),
						services.get("caroptionWriteService"),
						services.get("sellViewService"),
						services.get("categoryWriteService"),
						services.get("sellDeleteService"),
						services.get("sellSchListService"),
						services.get("attachmentDeleteService"),
						services.get("categoryDeleteService"),
						services.get("caroptionDeleteService"), 
						services.get("sellUpdateService"),
						services.get("sellOptionUpdateService"),
						services.get("sellCategoryUpdateService"),
						services.get("sellFileUpdateService"),
						services.get("sellcompleteService"))); 
		//아이디 중복체크 dao -> memeberDAO(이미등록되어 있음.)
		// 아이디 중복체크 service
		// Controller 생성 저장 ->기본생성자 -> DI 적용은 setter를 이용해서 한다 .
//		AjaxController ajaxController = new AjaxController();
//		controllers.put("ajaxController", ajaxController);
//		ajaxController.setMemberIdCheckService(services.get("memberIdCheckService"));
//		ajaxController.setMemberPwCheckService(services.get("memberPwCheckService"));
//		ajaxController.setCarYearlistService(services.get("carYearListService"));
//		ajaxController.setCarGradeListService(services.get("carGradeListService"));
//		ajaxController.setCarSpecListService(services.get("carSpecListService"));
		
//		daos.put("sellDAO", new SellDAO());
		services.put("carYearListService",
				new CarYearListService((SellDAO) daos.get("sellDAO")));
		services.put("carGradeListService",
				new CarGradeListService((SellDAO) daos.get("sellDAO")));
		services.put("carSpecListService",
				new CarSpecListService((SellDAO) daos.get("sellDAO")));
		services.put("brandSearchService",
				new BrandSearchService((SellDAO) daos.get("sellDAO")));
		controllers.put("ajaxController", new AjaxController(
				services.get("carYearListService"),
				services.get("carGradeListService"),
				services.get("carSpecListService"),
				services.get("memberIdCheckService"),
				services.get("memberPwCheckService"),
				services.get("kModelListService"),
				services.get("hModelListService"),
				services.get("sModelListService"),
				services.get("ssModelListService"),
				services.get("gmModelListService"),
				services.get("brandSearchService")));
		
		//----------------------------------------------------------------------------------------------------------------
		// *** main ***
		controllers.put("mainController", 
				new MainController(services.get("sellListService"),
						services.get("carBrandListService"),
						services.get("carClassListService"),
						services.get("kModelListService"),
						services.get("hModelListService"),
						services.get("sModelListService"),
						services.get("ssModelListService"),
						services.get("gmModelListService")));
		
		//--------------------------------------------------
		//*********오류 페이지******
		controllers.put("errorController", new ErrorController());
		
		
		System.out.println("객체 초기화 완료-------------------");
	}// end of init()
	
	public static Controller getController(String name) {
		return controllers.get(name);
	}
}
