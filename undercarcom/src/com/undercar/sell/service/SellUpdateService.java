package com.undercar.sell.service;

import com.undercar.main.Service;
import com.undercar.sell.dao.SellDAO;
import com.undercar.sell.dto.SellDTO;

public class SellUpdateService implements Service{

	private SellDAO dao;
	
	public SellUpdateService(SellDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("sellupdate.service()");
		
		SellDTO dto = (SellDTO)objs[0];
		
		return dao.update(dto);
	}
	
}
