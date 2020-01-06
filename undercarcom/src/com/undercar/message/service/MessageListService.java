package com.undercar.message.service;

import com.undercar.main.Service;
import com.undercar.member.dto.LoginDTO;
import com.undercar.message.dao.MessageDAO;
import com.undercar.util.page.PageObject;

public class MessageListService implements Service{
	
	private MessageDAO dao;
	
	public MessageListService(MessageDAO dao) {
		this.dao = dao;
	}

	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MessageListService.service()");
		
		// 데이터 변환
		LoginDTO loginDTO = (LoginDTO)objs[0];
		int check = (int)objs[1];
		PageObject pageObject  = (PageObject)objs[2];
		

		// 맨 처음 list에 들어가거나 받은 메시지함 클릭
		if(check == 0 || check == 1) {
			pageObject.setTotalRow(dao.getTotalRow(pageObject, loginDTO));
			System.out.println("MessageListService.serivce().totalRow.pageObject: " + pageObject);
			return dao.list(loginDTO, pageObject);
		} else if(check == 2) {
			// 보낸 메시지함 클릭
			pageObject.setTotalRow(dao.getTotalSendRow(pageObject, loginDTO));
			System.out.println("MessageListService.serivce().totalSendRow.pageObject: " + pageObject);
			return dao.sendList(loginDTO, pageObject);
		} else if(check == 3){
			// 안읽은 메시지함 클릭
			pageObject.setTotalRow(dao.getTotalNoRow(pageObject, loginDTO));
			System.out.println("MessageListService.serivce().totalNoRow.pageObject: " + pageObject);
			return dao.noAccList(loginDTO, pageObject);
		} else {
			pageObject.setTotalRow(dao.getTotalAllRow(pageObject, loginDTO));
			System.out.println("MessageListService.serivce().totalAllRow.pageObject: " + pageObject);
			return dao.allWriteList(loginDTO, pageObject);
		}
		
	}

}
