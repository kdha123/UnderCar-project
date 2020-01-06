package com.undercar.sell.service;

import java.util.List;

import com.undercar.main.Service;
import com.undercar.sell.dao.SellDAO;

public class CarClassListService implements Service{

	private final SellDAO dao;
	
	public CarClassListService(SellDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Object> service(Object[] objs)throws Exception{
		
		return dao.carClassList();
		
	}
}
