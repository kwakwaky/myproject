package com.webapp.mapper;

import com.webapp.model.Member;

public interface MemberMapper {
	
	// email을 받아서 Member객체를 return
	Member selectByEmail(String email);
	
}
