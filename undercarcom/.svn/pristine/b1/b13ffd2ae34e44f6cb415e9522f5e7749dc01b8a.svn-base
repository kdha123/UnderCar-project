package com.undercar.message.service;

import com.undercar.main.Service;
import com.undercar.message.dao.MessageDAO;

public class MessageAllUpdateService implements Service{
	
	private MessageDAO dao;
	
	public MessageAllUpdateService(MessageDAO dao) {
		this.dao = dao;
	}

	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MessageAllUpdateService.service()");
		// 제목 받기
		String title = (String)objs[0];
		
		return dao.allUpdate(title);
	}

}
