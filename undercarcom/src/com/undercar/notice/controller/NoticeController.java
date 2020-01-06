package com.undercar.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.undercar.main.Controller;
import com.undercar.main.Execute;
import com.undercar.main.Service;
import com.undercar.notice.dto.NoticeDTO;
import com.undercar.util.page.PageObject;
import com.undercar.util.io.FileUtil;

public class NoticeController implements Controller {
	
	private Service NoticeListService;
	private Service NoticeViewService;
	private Service NoticeWriteService;
//	private Service NoticeUpdateService;
//	private Service NoticeDeleteService;
	
	public NoticeController(Service NoticeListService, Service NoticeViewService, Service NoticeWriteService, Service NoticeUpdateService, Service NoticeDeleteService) {
		// TODO Auto-generated constructor stub
		this.NoticeListService = NoticeListService;
		this.NoticeViewService = NoticeViewService;
		this.NoticeWriteService = NoticeWriteService;
//		this.NoticeUpdateService = NoticeUpdateService;
//		this.NoticeDeleteService = NoticeDeleteService;
	}
	int size = 5*1024*1024;
	String path = "/upload/notice/";
	String noStr = "";
	String perPageNumStr = "";
	String fileSystemName = "";
	String deleteFileName = null;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		// TODO Auto-generated method stub
		
		String jsp = "";
		PageObject pageObject = PageObject.getInstance(request.getParameter("page"), request.getParameter("perPageNum"));
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		if (word != null) {
			pageObject.setKey(key);
			pageObject.setWord(word);
		}
		
//		HttpSession session = request.getSession(true);
//		LoginDTO ldto = (LoginDTO) session.getAttribute("login");
//		String id = ldto.getId();
		
		switch (uri) {
		case "/notice/list.do":
			request.setAttribute("pageObject", pageObject);
			request.setAttribute("list", Execute.service(NoticeListService, pageObject));
			jsp = "notice/list";
			break;
			
		case "/notice/view.do":
			int no = Integer.parseInt(request.getParameter("no"));
			request.setAttribute("dto", Execute.service(NoticeViewService, no));
			jsp = "notice/view";
			break;
			
		case "/notice/writeForm.do":
			jsp = "notice/writeForm";
			break;
			
		case "/notice/write.do":
			System.out.println(request.getParameter("perPageNum"));
			Execute.service(NoticeWriteService, getDTO(request));
			
			jsp ="redirect:list.do?page=1&perPageNum="+perPageNumStr;
			break;
			
		case "/notice/updateForm.do":
			request.setAttribute("dto", Execute.service(NoticeViewService, Integer.parseInt(request.getParameter("no"))));
			jsp = "notice/updateForm";
			break;
			
		case "/notice/update.do":
//			NoticeDTO dto = getDTO(request);
//			Execute.service(NoticeUpdateService, dto);
			
//			// 전달된 첨부파일이 있는 경우는 이미지 교체를 해야하므로 원래 있었던 파일을 지운다.
//			if(!dto.getFileName().equals(deleteFileName))
//				FileUtil.deleteFile(FileUtil.realPath(request, deleteFileName));
			jsp = "redirect:development.do";
			
			
			
			
//			jsp ="redirect:view.do?no=" + dto.getNo()
//					+ "&page=" + pageObject.getPage()
//					+ "&perPageNum=" + pageObject.getPerPageNum()
//					+ ((pageObject.getWord() != null && !pageObject.getWord().equals(""))
//					  ?"&key="+pageObject.getKey() + "&word=" + pageObject.getWord():"");
			break;
			
		case "/notice/delete.do":
//			Execute.service(NoticeDeleteService, Integer.parseInt(request.getParameter("no")));
//			FileUtil.deleteFile(FileUtil.realPath(request, request.getParameter("deleteFile")));
//			jsp = "redirect:list.do?page=1&perPageNum="
//					+request.getParameter("perPageNum");
			jsp = "redirect:development.do";
			break;
		case "/notice/development.do":
			jsp = "notice/development";
			break;

		default:
			break;
		}
		
		System.out.println("NoticeController.execute(): " + jsp);
		
		return jsp;
	}
	
	private NoticeDTO getDTO(String title, String content, String fileName) {
		NoticeDTO dto = new NoticeDTO();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setFileName(fileName);
		return dto;		
	}
	
	//updadate용 method
	private NoticeDTO getDTO(int no, String title, String content, String startDate, String endDate, String fileName) {
		if(fileName.equals(path+"s_null")) fileName=deleteFileName;
		NoticeDTO dto = new NoticeDTO();
		dto.setNo(no);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setStartDate(startDate);
		dto.setEndDate(endDate);
		dto.setFileName(fileName);
		return dto;		
	} 
	
	
	private NoticeDTO getDTO(HttpServletRequest request) throws Exception {
		String uploadPath = FileUtil.realPath(request, path);
		System.out.println("uploadPath: " + uploadPath);

		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		//db에 저장할 정보 : 위치+서버의파일명
				String fileName = path + "s_" + multi.getFilesystemName("fileName");
				System.out.println("UserCafeController.execute().fileName:"+fileName);
		
		perPageNumStr = multi.getParameter("perPageNum");

		noStr = multi.getParameter("no");

		if(noStr != null && !noStr.equals("")) {
			deleteFileName = multi.getParameter("deleteFile");
			System.out.println(deleteFileName);
			return getDTO(Integer.parseInt(noStr),
					multi.getParameter("title"),
					multi.getParameter("content"), multi.getParameter("startDate"), multi.getParameter("endDate"), fileName);
		}
		return getDTO(multi.getParameter("title"), multi.getParameter("content"), fileName);
	}

}
