package com.webapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	static Log log = LogFactory.getLog(LoginController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public String loginForm() {
		
		log.info("loginForm()...");
		
		return "member/loginForm";
	}
	
}
