package com.undercar.sell.service;

import java.util.List;

import com.undercar.main.Service;
import com.undercar.sell.dao.SellDAO;
import com.undercar.util.page.PageObject;

public class SellSchListService implements Service{

	private final SellDAO dao;
	
	public SellSchListService(SellDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Object> service(Object[] objs)throws Exception{
		System.out.println("SellSchListService.service()");
		PageObject pageObject = (PageObject) objs[0];
		String[] con = (String[]) objs[1];
		
		pageObject.setTotalRow(dao.getTotalRow(pageObject));
		System.out.println("SellSchListService.service().pageObject:" + pageObject);
		
		return dao.schList(pageObject, con);
		
	}
}
