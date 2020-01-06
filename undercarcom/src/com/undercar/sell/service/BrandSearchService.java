package com.undercar.sell.service;

import com.undercar.main.Service;
import com.undercar.sell.dao.SellDAO;

public class BrandSearchService implements Service {

	SellDAO dao;
	
	public BrandSearchService(SellDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao=dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		
		String brand = (String) objs[0];
		
		System.out.println("brandSearchList:" + brand);
		
		return dao.brandSearchList(brand);
	}

}
