package com.undercar.event.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.undercar.main.Controller;
import com.undercar.main.Execute;
import com.undercar.main.Service;
import com.undercar.event.dto.EventDTO;
import com.undercar.util.page.PageObject;
import com.webjjang.util.ImageResizing;
import com.undercar.util.io.FileUtil;

public class EventController implements Controller {
	
	private Service EventListService;
	private Service EventViewService;
	private Service EventWriteService;
//	private Service EventUpdateService;
//	private Service EventDeleteService;
	
	public EventController(Service EventListService, Service EventViewService, Service EventWriteService, Service EventUpdateService, Service EventDeleteService) {
		// TODO Auto-generated constructor stub
		this.EventListService = EventListService;
		this.EventViewService = EventViewService;
		this.EventWriteService = EventWriteService;
//		this.EventUpdateService = EventUpdateService;
//		this.EventDeleteService = EventDeleteService;
	}
	int size = 5*1024*1024;
	String path = "/upload/event_image/";
	String noStr = "";
	String perPageNumStr = "";	
	String deleteFileName1 = null;
	String deleteFileName2 = null;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		// TODO Auto-generated method stub
		
		String jsp = "";
		PageObject pageObject = PageObject.getInstance(request.getParameter("page"), 
				request.getParameter("perPageNum"));
		
		switch (uri) {
		case "/event/list.do":
			request.setAttribute("pageObject", pageObject);
			request.setAttribute("list", Execute.service(EventListService, pageObject));
			jsp = "event/list";
			break;
			
		case "/event/view.do":
			int no = Integer.parseInt(request.getParameter("no"));
			request.setAttribute("dto", Execute.service(EventViewService, no));
			jsp = "event/view";
			break;
			
		case "/event/writeForm.do":
			jsp = "event/writeForm";
			break;
			
		case "/event/write.do":
			Execute.service(EventWriteService, getDTO(request));
			jsp ="redirect:list.do";
			break;
			
		case "/event/updateForm.do":
//			request.setAttribute("dto", Execute.service(EventViewService, Integer.parseInt(request.getParameter("no"))));
			jsp = "event/development";
			break;
			
		case "/event/update.do":
//			EventDTO dto = getDTO(request);
//			Execute.service(EventUpdateService, dto);
//			
//			if (dto.getImage() != null)
//				FileUtil.deleteFile(FileUtil.realPath(request, deleteFileName1));
//			if (dto.getRepImage() != null)
//				FileUtil.deleteFile(FileUtil.realPath(request, deleteFileName2));

//			jsp = "event/view";
			jsp = "redirect:development.do";
			break;
			
		case "/event/delete.do":
//			Execute.service(EventDeleteService, Integer.parseInt(request.getParameter("no")));
//			FileUtil.deleteFile(FileUtil.realPath(request, request.getParameter("deleteFile1")));
//			FileUtil.deleteFile(FileUtil.realPath(request, request.getParameter("deleteFile2")));
			jsp = "redirect:development.do";
			break;
		case "/event/development.do":
			jsp = "event/development";
			break;

		default:
			break;
		}
		
		System.out.println("EventController.execute(): " + jsp);
		
		return jsp;
	}
	
	private EventDTO getDTO(String title, String image, String repImage) {
		EventDTO dto = new EventDTO();
		dto.setTitle(title);
		dto.setImage(image);
		dto.setRepImage(repImage);
		return dto;		
	}
	
	private EventDTO getDTO(int no, String title, String image, String repImage, String startDate, String endDate) {
		EventDTO dto = new EventDTO();
		dto.setNo(no);
		dto.setTitle(title);
		dto.setImage(image);
		dto.setRepImage(repImage);
		dto.setStartDate(startDate);
		dto.setEndDate(endDate);
		return dto;		
	} 
	
	private EventDTO getDTO(HttpServletRequest request) throws Exception {
		String uploadPath = FileUtil.realPath(request, path);
		System.out.println(uploadPath);

		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());

		String image = path + multi.getFilesystemName("image");
		String repImage = path + multi.getFilesystemName("repImage");
		System.out.println("EventController.execute().image:" + image);
		System.out.println("EventController.execute().repImage:" + repImage);
		
		if(repImage != null && !repImage.equals("") && !repImage.equals(path + "null"))
			ImageResizing.imageResizing(uploadPath, multi.getFilesystemName("repImage"), "rep_", 300, 500);
		
		perPageNumStr = multi.getParameter("perPageNum");

		noStr = multi.getParameter("no");

		if(noStr != null && !noStr.equals("")) {
			deleteFileName1 = multi.getParameter("deleteFile1");
			System.out.println("deleteFileName1: " + deleteFileName1);
			deleteFileName2 = multi.getParameter("deleteFile2");
			System.out.println("deleteFileName2: " + deleteFileName2);
			return getDTO(Integer.parseInt(noStr),
					multi.getParameter("title"),
					image, repImage,
					multi.getParameter("startDate"),
					multi.getParameter("endDate"));
		}
		return getDTO(multi.getParameter("title"), image, repImage);
	}

}
