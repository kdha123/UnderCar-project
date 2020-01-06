package com.undercar.notice.service;


import com.undercar.main.Service;
import com.undercar.notice.dao.NoticeDAO;
import com.undercar.notice.dto.NoticeDTO;

public class NoticeViewService implements Service {
	
	private NoticeDAO dao;
	
	public NoticeViewService(NoticeDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public NoticeDTO service(Object[] objs) throws Exception {
		
		// 데이터 변환
		int no = (int) objs[0];
		
		System.out.println("NoticeViewService.service()");
		
		// TODO Auto-generated method stub
		return dao.view(no);
	}

}
