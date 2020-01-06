package com.undercar.sell.service;

import java.util.List;

import com.undercar.main.Service;
import com.undercar.sell.dao.SellDAO;

public class SsModelListService implements Service{

	private final SellDAO dao;
	
	public SsModelListService(SellDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Object> service(Object[] objs)throws Exception{
		
		return dao.ssModelList();
		
	}
}
