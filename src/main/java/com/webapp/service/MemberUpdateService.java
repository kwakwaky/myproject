package com.webapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.webapp.command.RegistCommand;
import com.webapp.mapper.MemberMapper;
import com.webapp.model.Member;

public class MemberUpdateService {

	static Log log = LogFactory.getLog(MemberUpdateService.class);

	MemberMapper memberMapper;

	public void setMemberMapper(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}

	public void update(RegistCommand command, int num) {
		log.info("MemberUpdateService - update()");
		Member member = command.getMember();
		member.setNum(num);
		memberMapper.updateMember(member);
		
		
		// try {
		// memberMapper.insertMember(member);
		// } catch (Exception e) {
		// e.getStackTrace();
		//
		// log.info("회원가입 에러... , " + e);
		// }

	}
	
	
}