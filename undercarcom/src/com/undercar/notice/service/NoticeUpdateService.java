package com.undercar.notice.service;


import com.undercar.main.Service;
import com.undercar.notice.dao.NoticeDAO;
import com.undercar.notice.dto.NoticeDTO;

public class NoticeUpdateService implements Service {
	
	private NoticeDAO dao;
	
	public NoticeUpdateService(NoticeDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		
		// 데이터 변환
		NoticeDTO dto = (NoticeDTO) objs[0];
		
		System.out.println("NoticeUpdateService.service()");
		
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

}
