package com.undercar.member.service;

import java.util.List;

import com.undercar.main.Service;
import com.undercar.member.dao.MemberDAO;
import com.undercar.member.dto.MemberDTO;
import com.undercar.util.page.PageObject;

public class MemberListService implements Service {
	private MemberDAO dao;
	public MemberListService(MemberDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao=dao;
	}
	@Override
	public List<MemberDTO> service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		PageObject pageObject = (PageObject) objs[0];
		
		pageObject.setTotalRow(dao.getTotalRow(pageObject));
		System.out.println("MemberListService()");
		return dao.list(pageObject);
	}

}
