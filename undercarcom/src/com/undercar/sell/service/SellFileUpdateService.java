package com.undercar.sell.service;

import com.undercar.attachment.dto.AttachmentDTO;
import com.undercar.main.Service;
import com.undercar.sell.dao.SellDAO;

public class SellFileUpdateService implements Service{

	private SellDAO dao;
	
	public SellFileUpdateService(SellDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SellFileUpdateService.service()");
		
		AttachmentDTO dto = (AttachmentDTO)objs[0];
		
		return dao.updateAttachment(dto);
	}
	
}
