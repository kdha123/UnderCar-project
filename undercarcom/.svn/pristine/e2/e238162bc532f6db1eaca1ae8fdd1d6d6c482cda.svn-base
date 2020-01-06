package com.undercar.notice.service;


import com.undercar.main.Service;
import com.undercar.notice.dao.NoticeDAO;

public class NoticeDeleteService implements Service {
	
	private NoticeDAO dao;
	
	public NoticeDeleteService(NoticeDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		
		// 데이터 변환
		int no = (int) objs[0];
		
		System.out.println("NoticeDeleteService.service()");
		
		// TODO Auto-generated method stub
		return dao.delete(no);
	}

}
