package com.undercar.message.service;

import com.undercar.main.Service;
import com.undercar.message.dao.MessageDAO;

public class MessageUpdateStatusService implements Service{
	
	private MessageDAO dao;
	
	public MessageUpdateStatusService(MessageDAO dao) {
		this.dao = dao;
	}

	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MessageUpdateService.service()");
		
		// 글번호 받기
		int no = (int)objs[0];
		// 로그인한 사람이 받은 사람이면 check = 1, 보낸 사람이면 check = 2
		int check = (int)objs[1];
		
		if(check == 1)
			return dao.accUpdate(no);
		else
			return dao.senUpdate(no);
	}

}
