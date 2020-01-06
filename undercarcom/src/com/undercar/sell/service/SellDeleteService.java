package com.undercar.sell.service;

import com.undercar.main.Service;
import com.undercar.sell.dao.SellDAO;

public class SellDeleteService implements Service{

	private SellDAO dao;
	
	public SellDeleteService(SellDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		
		int no = (int)objs[0];
		
		return dao.sellDelete(no);
	}
	
}
