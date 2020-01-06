package com.undercar.member.service;

import com.undercar.main.Service;
import com.undercar.member.dao.MemberDAO;

public class MemberInfoService implements Service {

	private MemberDAO dao;
	public MemberInfoService(MemberDAO dao) {
		this.dao = dao;
	}
	@Override
	public Object service(Object[] objs) throws Exception {
		String id = (String) objs[0];
		return dao.view(id);
	}

}
