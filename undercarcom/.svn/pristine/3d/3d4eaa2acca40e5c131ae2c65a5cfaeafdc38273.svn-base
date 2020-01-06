package com.undercar.faq.service;

import com.undercar.faq.dao.FaqDAO;
import com.undercar.faq.dto.FaqDTO;
import com.undercar.main.Service;

public class FaqUpdateService implements Service {
  private FaqDAO dao;

  public FaqUpdateService(FaqDAO dao) {
	this.dao=dao;
	// TODO Auto-generated constructor stub
}
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		FaqDTO dto = (FaqDTO) objs[0];
		System.out.println("Faq업데이트 서비스");
		

	  return dao.update(dto);
	  
	}

}
