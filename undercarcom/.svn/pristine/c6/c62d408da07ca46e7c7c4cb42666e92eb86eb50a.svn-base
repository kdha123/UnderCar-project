package com.undercar.sell.service;

import java.util.List;

import com.undercar.main.Service;
import com.undercar.sell.dao.SellDAO;

public class CarGradeListService implements Service{

	private final SellDAO dao;
	
	public CarGradeListService(SellDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Object> service(Object[] objs)throws Exception{
		System.out.println("CarGradeListService.service()");
		String year = (String)objs[0];
		System.out.println("CarGradeListService.service().model : "+year);
		
		
		return dao.carGradeList(year);
		
	}
}
