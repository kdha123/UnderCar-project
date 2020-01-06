package com.undercar.message.service;

import com.undercar.main.Service;
import com.undercar.message.dao.MessageDAO;

public class MessageAllCheckUpdateService implements Service{
	
	private MessageDAO dao;
	
	public MessageAllCheckUpdateService(MessageDAO dao) {
		this.dao = dao;
	}

	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MessageAllCheckUpdateService.service()");
		
		return 	dao.allCheckUpdate();
	}

}
