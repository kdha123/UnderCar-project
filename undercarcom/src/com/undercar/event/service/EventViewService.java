package com.undercar.event.service;


import com.undercar.main.Service;
import com.undercar.event.dao.EventDAO;
import com.undercar.event.dto.EventDTO;

public class EventViewService implements Service {
	
	private EventDAO dao;
	
	public EventViewService(EventDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public EventDTO service(Object[] objs) throws Exception {
		
		// 데이터 변환
		int no = (int) objs[0];
		
		System.out.println("EventViewService.service()");
		
		// TODO Auto-generated method stub
		return dao.view(no);
	}

}
