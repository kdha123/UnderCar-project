package com.undercar.notice.service;

import java.util.List;

import com.undercar.main.Service;
import com.undercar.notice.dao.NoticeDAO;
import com.undercar.notice.dto.NoticeDTO;
import com.undercar.util.page.PageObject;

public class NoticeListService implements Service {
	
	private NoticeDAO dao;
	
	public NoticeListService(NoticeDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public List<NoticeDTO> service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		
		// 데이터 변환
		PageObject pageObject  = (PageObject)objs[0];
		
		System.out.println("NoticeListService.service()");
		
		pageObject.setTotalRow(dao.getTotalRow(pageObject));
		System.out.println("NoticeListService.serivce().pageObject: " + pageObject);
		return dao.list(pageObject);
	}

}
