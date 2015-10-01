package com.webapp.mapper;

import com.webapp.model.Member;

public interface MemberMapper {
	
	// 멤버 로그인 할때 씀
	Member selectByEmail(String email);
	
	
	
	// 멤버 가입 할때 씀
	int insertMember(Member member);
	
	// 회원 수정
	int updateMember(Member member);
	
	// 회원 탈퇴
	int deleteByNum(int num);
	String selectPasswordByNum(int num);
}
