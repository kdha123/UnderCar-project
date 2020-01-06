package com.undercar.member.service;

import com.undercar.main.Service;
import com.undercar.member.dao.MemberDAO;

public class MemberFindPwService implements Service {
	
	private MemberDAO dao;
	public MemberFindPwService(MemberDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		String id = (String) objs[0];
		String email = (String) objs[1];
		return dao.findPw(id, email);
	}

}
