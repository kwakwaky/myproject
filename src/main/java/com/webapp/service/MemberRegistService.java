package com.webapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.webapp.mapper.MemberMapper;
import com.webapp.model.Member;

public class MemberRegistService {
	
	static Log log = LogFactory.getLog(MemberRegistService.class);
	
	MemberMapper memberMapper;
	
	public void setMemberMapper(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	public void register(Member member) {
		try {
			memberMapper.insertMember(member);
		} catch (Exception e) {
			log.info("회원가입 에러... , " + e);
		}
		
	}

}
