package com.undercar.sell.service;

import com.undercar.category.dto.CategoryDTO;
import com.undercar.main.Service;
import com.undercar.sell.dao.SellDAO;

public class CategoryWriteService implements Service{

	private SellDAO dao;
	
	public CategoryWriteService(SellDAO dao) {
		this.dao = dao;
	}

	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("CategoryWriteService.service()");
		
		CategoryDTO codto = (CategoryDTO) objs[0];
		
		
		return dao.categoryWrite(codto);
	}
}
