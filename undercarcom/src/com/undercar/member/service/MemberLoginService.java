package com.undercar.member.service;

import com.undercar.main.Service;
import com.undercar.member.dao.MemberDAO;
import com.undercar.member.dto.LoginDTO;

public class MemberLoginService implements Service {

	MemberDAO dao;
	public MemberLoginService(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MemberLoginService()");
		LoginDTO dto = (LoginDTO) objs[0];
		return dao.login(dto);
	}

}
