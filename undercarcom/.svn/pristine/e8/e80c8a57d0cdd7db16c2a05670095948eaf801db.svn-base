package com.undercar.sell.service;

import com.undercar.attachment.dto.AttachmentDTO;
import com.undercar.main.Service;
import com.undercar.sell.dao.SellDAO;
import com.undercar.sell.dto.SellDTO;

public class AttachmentWriteService implements Service{

	private SellDAO dao;
	
	public AttachmentWriteService(SellDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
		
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AttachmentWriteService.service()");
		AttachmentDTO adto = (AttachmentDTO)objs[0];
		
		return dao.attachmentWrite(adto);
	}
}
