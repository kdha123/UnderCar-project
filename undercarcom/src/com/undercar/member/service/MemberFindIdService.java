package com.undercar.member.service;

import com.undercar.main.Service;
import com.undercar.member.dao.MemberDAO;

public class MemberFindIdService implements Service {
	
	private MemberDAO dao;
	public MemberFindIdService(MemberDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		String email = (String) objs[0];
		return dao.findId(email);
	}

}
