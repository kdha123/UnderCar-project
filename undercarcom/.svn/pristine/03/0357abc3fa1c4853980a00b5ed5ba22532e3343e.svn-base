package com.undercar.faq.service;

import com.undercar.faq.dao.FaqDAO;
import com.undercar.faq.dto.FaqDTO;
import com.undercar.main.Service;

public class FaqWriteService implements Service {
  private FaqDAO dao;

  public FaqWriteService(FaqDAO dao) {
	this.dao=dao;
	// TODO Auto-generated constructor stub
}
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		FaqDTO dto = (FaqDTO) objs[0];
		System.out.println("Faq라이트 서비스");
		

	  dao.write(dto);
	  return null;
	}

}
