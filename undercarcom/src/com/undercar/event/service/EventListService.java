package com.undercar.event.service;

import java.util.List;

import com.undercar.main.Service;
import com.undercar.event.dao.EventDAO;
import com.undercar.event.dto.EventDTO;
import com.undercar.util.page.PageObject;

public class EventListService implements Service {
	
	private EventDAO dao;
	
	public EventListService(EventDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public List<EventDTO> service(Object[] objs) throws Exception {
		
		// 데이터 변환
		PageObject pageObject  = (PageObject)objs[0];
		
		System.out.println("EventListService.service()");
		
		// TODO Auto-generated method stub
		System.out.println("EventListService.serivce().pageObject: " + pageObject);
		return dao.list(pageObject);
	}

}
