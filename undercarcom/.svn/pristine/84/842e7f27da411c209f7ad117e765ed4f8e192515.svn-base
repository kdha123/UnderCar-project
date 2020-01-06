package com.undercar.member.service;

import com.undercar.main.Service;
import com.undercar.member.dao.MemberDAO;
import com.undercar.member.dto.MemberDTO;

public class MemberUpdateService implements Service {

	private MemberDAO dao;
	public MemberUpdateService(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public Object service(Object[] objs) throws Exception {
		MemberDTO dto = (MemberDTO) objs[0];
		
		return dao.update(dto);
	}

}
