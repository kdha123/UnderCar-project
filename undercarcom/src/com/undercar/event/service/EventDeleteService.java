package com.undercar.event.service;


import com.undercar.main.Service;
import com.undercar.event.dao.EventDAO;

public class EventDeleteService implements Service {
	
	private EventDAO dao;
	
	public EventDeleteService(EventDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		
		// 데이터 변환
		int no = (int) objs[0];
		
		System.out.println("EventDeleteService.service()");
		
		// TODO Auto-generated method stub
		return dao.delete(no);
	}

}
