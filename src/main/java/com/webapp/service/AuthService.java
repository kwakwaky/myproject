package com.webapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.webapp.exception.IdPasswordNotMatchException;
import com.webapp.mapper.MemberMapper;
import com.webapp.model.Member;

public class AuthService {
	
	static Log log = LogFactory.getLog(AuthService.class);
	
	MemberMapper mapper;

	public void setMapper(MemberMapper mapper) {
		this.mapper = mapper;
	}
	
	// 로그인 처리해주는 메서드
	public Member authenticate(String email, String password) {
		Member info = new Member();
		try {
			Member m = mapper.selectByEmail(email);	
			log.info(m.toString());
			if (!m.getPassword().equals(password)) {
				throw new IdPasswordNotMatchException();
			}
			info.setEmail(m.getEmail());
			info.setName(m.getName());
			
			
		} catch (NullPointerException e) {
			log.info("NullPointerException");
			throw new IdPasswordNotMatchException(e);
		}
		return info;
	}
	
	

}
