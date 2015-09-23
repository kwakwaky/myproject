package com.webapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.command.LoginCommand;
import com.webapp.mapper.MemberMapper;
import com.webapp.model.Member;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	MemberMapper mapper;
	
	static Log log = LogFactory.getLog(LoginController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public String loginForm(@ModelAttribute("login") LoginCommand command) {
		log.info("loginForm()...");
		
		return "member/loginform";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(@ModelAttribute("login") LoginCommand command) {
		log.info("login()...");
		
		Member member = mapper.selectByEmail(command.getEmail());
		log.info("login()..." + member.toString());
		
		
		return "redirect:/";
	}
	
	
	
}
