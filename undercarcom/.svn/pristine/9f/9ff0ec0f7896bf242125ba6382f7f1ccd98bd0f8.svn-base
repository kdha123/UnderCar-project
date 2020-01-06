package com.undercar.sell.service;

import com.undercar.category.dto.CategoryDTO;
import com.undercar.main.Service;
import com.undercar.sell.dao.SellDAO;

public class SellCategoryUpdateService implements Service{

	private SellDAO dao;
	
	public SellCategoryUpdateService(SellDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("sellupdate.service()");
		
		CategoryDTO dto = (CategoryDTO)objs[0];
		
		return dao.updateCategory(dto);
	}
	
}
