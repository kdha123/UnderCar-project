package com.undercar.faq.service;

import com.undercar.faq.dao.FaqDAO;
import com.undercar.main.Service;

public class FaqDeleteService implements Service {
  private FaqDAO dao;

  public FaqDeleteService(FaqDAO dao) {
	this.dao=dao;
	// TODO Auto-generated constructor stub
}
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		
		int no = (int) objs[0];
		System.out.println("Faq델리트 서비스");
		

	  
	  return dao.delete(no);
	}

}
