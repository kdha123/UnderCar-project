package com.undercar.event.service;


import com.undercar.main.Service;
import com.undercar.event.dao.EventDAO;
import com.undercar.event.dto.EventDTO;

public class EventUpdateService implements Service {
	
	private EventDAO dao;
	
	public EventUpdateService(EventDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		
		// 데이터 변환
		EventDTO dto = (EventDTO) objs[0];
		
		System.out.println("EventUpdateService.service()");
		
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

}
