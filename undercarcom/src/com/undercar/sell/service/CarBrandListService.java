package com.undercar.sell.service;

import java.util.List;

import com.undercar.main.Service;
import com.undercar.sell.dao.SellDAO;
import com.undercar.util.page.PageObject;

public class CarBrandListService implements Service{

	private final SellDAO dao;
	
	public CarBrandListService(SellDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Object> service(Object[] objs)throws Exception{
		
		return dao.carBrandList();
		
	}
}
