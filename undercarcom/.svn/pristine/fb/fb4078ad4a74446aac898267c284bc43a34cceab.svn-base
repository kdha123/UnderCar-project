package com.undercar.qna.service;

import com.undercar.main.Service;
import com.undercar.qna.dao.QnaDAO;
import com.undercar.util.page.PageObject;

public class QnaAdminListService implements Service {
  private QnaDAO dao;
public QnaAdminListService(QnaDAO dao) {
	this.dao=dao;
	// TODO Auto-generated constructor stub
}
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		PageObject pageObject = (PageObject) objs[0];
		System.out.println("qna리스트 서비스");
		
		pageObject.setTotalRow(dao.getTotalRow(pageObject));
		
		System.out.println("qna리스트 서비스페이지 오브젝트"+pageObject);
		return dao.adminlist(pageObject);
	}

}
