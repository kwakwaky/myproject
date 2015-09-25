package com.webapp.mapper;

import com.webapp.model.Member;

public interface MemberMapper {
	
	// 멤버 로그인 할때 씀
	Member selectByEmail(String email);
	
	// 멤버 가입 할때 씀
	int insertMember(Member member);
	
}
