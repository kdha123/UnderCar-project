package com.undercar.sell.service;

import java.util.List;

import com.undercar.main.Service;
import com.undercar.sell.dao.SellDAO;

public class CarSpecListService implements Service{

	private final SellDAO dao;
	
	public CarSpecListService(SellDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Object> service(Object[] objs)throws Exception{
		System.out.println("CarSpecListService.service()");
		String carGrade = (String)objs[0];
		System.out.println("CarSpecListService.service().model : "+carGrade);
		
		
		return dao.carSpecList(carGrade);
		
	}
}
