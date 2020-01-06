package com.undercar.qna.service;

import com.undercar.main.Service;
import com.undercar.qna.dao.QnaDAO;

public class QnaViewService implements Service {
  private QnaDAO dao;

  public QnaViewService(QnaDAO dao) {
	this.dao=dao;
	// TODO Auto-generated constructor stub
}
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("qna뷰 서비스");
		
		int no = (int) objs[0];
      		
		
		return dao.view(no);
	}

}
