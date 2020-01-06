package com.undercar.sell.service;

import com.undercar.caroption.dto.CarOptionDTO;
import com.undercar.main.Service;
import com.undercar.sell.dao.SellDAO;

public class SellOptionUpdateService implements Service{

	private SellDAO dao;
	
	public SellOptionUpdateService(SellDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SellOptionUpdateService.service()");
		
		CarOptionDTO dto = (CarOptionDTO)objs[0];
		
		return dao.updateCarOption(dto);
	}
	
}
