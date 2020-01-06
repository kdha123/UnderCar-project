package com.undercar.member.service;

import com.undercar.main.Service;
import com.undercar.member.dao.MemberDAO;
import com.undercar.member.dto.MemberDTO;

public class MemberJoinService implements Service {

	private MemberDAO dao;
	public MemberJoinService(MemberDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	@Override
	public Object service(Object[] objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MemberJoinService()");
		MemberDTO dto = (MemberDTO) objs[0];
		
		return dao.join(dto);
	}

}
