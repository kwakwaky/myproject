package com.webapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.webapp.exception.IdPasswordNotMatchException;
import com.webapp.mapper.MemberMapper;
import com.webapp.model.AuthInfo;
import com.webapp.model.Member;

public class AuthService {
	
	static Log log = LogFactory.getLog(AuthService.class);
	
	MemberMapper mapper;

	public void setMapper(MemberMapper mapper) {
		this.mapper = mapper;
	}
	
	// 로그인 처리해주는 메서드
	public AuthInfo authenticate(String email, String password) {
		log.info("authenticate()...");
		AuthInfo authInfo = new AuthInfo();
		Member m = new Member();
		try {
			m = mapper.selectByEmail(email);	
			if (!m.getPassword().equals(password)) {
				throw new IdPasswordNotMatchException();
			}
			authInfo.setNum(m.getNum());
			authInfo.setEmail(m.getEmail());
			authInfo.setName(m.getName());
			
			
		} catch (NullPointerException e) {
			log.info("NullPointerException");
			throw new IdPasswordNotMatchException(e);
		}
		return authInfo;
	}
	
	

}
