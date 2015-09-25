package com.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.webapp.mapper.MemberMapper;
import com.webapp.model.Member;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
	
	static Log log = LogFactory.getLog(AjaxController.class);
	
	Gson gson = new Gson();
	Member member;
	PrintWriter writer;
	
	@Autowired
	MemberMapper mapper;
	
	// registForm의 입력값을 검증해주는 메서드들
	
	// email 검증
	@RequestMapping(value="/email", method=RequestMethod.POST)
	public void emailValidate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json; charset=utf-8");
		writer = response.getWriter();
		log.info("test()...");
		
		// $.ajax에서 email을 받아옴
		String email = request.getParameter("email");
		// 받아온 email로 쿼리문 날림
		member = mapper.selectByEmail(email);
		
		if (member == null) {
			writer.println(gson.toJson("사용가능한 아이디"));
		} else {
			writer.println(gson.toJson("중복된 아이디"));
		}
		
		log.info("test()..." + email);
		writer.close();
	}
	
	// password 검증
	@RequestMapping(value="/password", method=RequestMethod.POST)
	public void passwordValidate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json; charset=utf-8");
		writer = response.getWriter();
		
		String password = request.getParameter("password");
		String passwordcheck = request.getParameter("passwordcheck");
		
		if (!password.equals(passwordcheck)) {
			writer.println(gson.toJson("비밀번호가 서로 맞지 않습니다."));
		} else {
			writer.println(gson.toJson("사용가능한 비밀번호"));
		}
		
		log.info("passwordValidate()..." + password + "," + passwordcheck);
		writer.close();
	}
	
	// name 검증
	@RequestMapping(value="/name", method=RequestMethod.POST)
	public void nameValidate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json; charset=utf-8");
		writer = response.getWriter();
		
		String name = request.getParameter("name");
		
		if (name.length() > 13) {
			writer.println(gson.toJson("이름은 13자 이하만 가능합니다."));
		} else {
			writer.println(gson.toJson("사용가능한 이름"));
		}
		
		log.info("nameValidate()...");
		writer.close();
	}
	
	// phone 검증
	@RequestMapping(value="/phone", method=RequestMethod.POST)
	public void phoneValidate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json; charset=utf-8");
		writer = response.getWriter();
		
//		String phone = request.getParameter("phone");
		
		
		
		log.info("phoneValidate()...");
		writer.close();
	}
}
