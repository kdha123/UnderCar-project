package com.undercar.faq.service;

import com.undercar.faq.dao.FaqDAO;
import com.undercar.main.Service;

public class FaqViewService implements Service {
  private FaqDAO dao;

  public FaqViewService(FaqDAO dao) {
	this.dao=dao;
	// TODO Auto-generated constructor stub
}
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Faq뷰 서비스");
		
		int no = (int) objs[0];
      		
		
		return dao.view(no);
	}

}
