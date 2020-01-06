package com.undercar.sell.service;

import java.util.List;

import com.undercar.main.Service;
import com.undercar.sell.dao.SellDAO;

public class CarYearListService implements Service{

	private final SellDAO dao;
	
	public CarYearListService(SellDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Object> service(Object[] objs)throws Exception{
		System.out.println("CarYearListService.service()");
		String model = (String)objs[0];
		System.out.println("CarYearListService.service().model : "+model);
		
		
		return dao.carYearList(model);
		
	}
}
