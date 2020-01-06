package com.undercar.qna.service;

import com.undercar.main.Service;
import com.undercar.qna.dao.QnaDAO;
import com.undercar.qna.dto.QnaDTO;

public class QnaWriteService implements Service {
  private QnaDAO dao;

  public QnaWriteService(QnaDAO dao) {
	this.dao=dao;
	// TODO Auto-generated constructor stub
}
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		QnaDTO dto = (QnaDTO) objs[0];
		System.out.println("qna라이트 서비스");
		

	  dao.write(dto);
	  return null;
	}

}
