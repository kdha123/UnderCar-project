package com.undercar.qna.service;

import com.undercar.main.Service;
import com.undercar.qna.dao.QnaDAO;

public class QnaDeleteService implements Service {
  private QnaDAO dao;

  public QnaDeleteService(QnaDAO dao) {
	this.dao=dao;
	// TODO Auto-generated constructor stub
}
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		
		int no = (int) objs[0];
		System.out.println("qna델리트 서비스");
		

	  
	  return dao.delete(no);
	}

}
