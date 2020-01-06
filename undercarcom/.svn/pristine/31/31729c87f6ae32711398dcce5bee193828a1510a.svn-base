package com.undercar.message.service;

import com.undercar.main.Service;
import com.undercar.message.dao.MessageDAO;

public class MessageViewService implements Service{
	
	private MessageDAO dao;
	
	public MessageViewService(MessageDAO dao) {
		this.dao = dao;
	}

	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MessageViewService.service()");
		int no = (int)objs[0];
		int check = (int)objs[1];
		
		if(check == 1)
			dao.accDateUpate(no);
		
		return dao.view(no);
	}

}
