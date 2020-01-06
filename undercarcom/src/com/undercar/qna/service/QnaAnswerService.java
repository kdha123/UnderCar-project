package com.undercar.qna.service;



import com.undercar.main.Service;
import com.undercar.qna.dao.QnaDAO;
import com.undercar.qna.dto.QnaDTO;

public class QnaAnswerService implements Service{
	  private QnaDAO dao;

	  public QnaAnswerService(QnaDAO dao) {
		// TODO Auto-generated constructor stub
	
		this.dao=dao;

	  }
		public Object service(Object[] objs) throws Exception{
			System.out.println("QnaAnswerService.service()");
			
			QnaDTO dto = (QnaDTO) objs[0];
			
			try {
				dao.increaseOrdNo(dto);
				dao.answer(dto);
			} catch (Exception e) {
				throw new Exception("질문답변 글쓰기 중 오류가 발생되었습니다."+e);
			}
			return null;
		}
		
	}
