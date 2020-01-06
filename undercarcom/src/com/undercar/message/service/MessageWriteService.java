package com.undercar.message.service;

import com.undercar.main.Service;
import com.undercar.message.dao.MessageDAO;
import com.undercar.message.dto.MessageDTO;

public class MessageWriteService implements Service{
	
	private MessageDAO dao;
	
	public MessageWriteService(MessageDAO dao) {
		this.dao = dao;
	}
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MessageWriteService.service()");
		MessageDTO dto = (MessageDTO)objs[0];
		int check = (int)objs[1];
		
		if(check == 1) {
			return dao.allWrite(dto);
		}
		else
			return dao.write(dto);
	}

}
