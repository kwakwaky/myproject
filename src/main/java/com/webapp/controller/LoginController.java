package com.webapp.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.command.LoginCommand;
import com.webapp.exception.IdPasswordNotMatchException;
import com.webapp.model.Member;
import com.webapp.service.AuthService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	AuthService service;
	
	static Log log = LogFactory.getLog(LoginController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public String loginForm(@ModelAttribute("login") LoginCommand command) {
		log.info("loginForm()...");
		
		return "member/loginform";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(@ModelAttribute("login") LoginCommand command, Errors errors, HttpSession session) {
		log.info("login()...");
		
//		Member member = mapper.selectByEmail(command.getEmail());
//		log.info("login()..." + member.toString());
		log.info(command.getEmail() + " , " + command.getPassword());
		try {
			Member auth = service.authenticate(command.getEmail(), command.getPassword());
			log.info(command.getEmail() + " , " + command.getPassword());
			session.setAttribute("auth", auth); // 성공하면 세션에 auth를 저장
			log.info(auth.getName());
			
		} catch (IdPasswordNotMatchException ex) {
			log.info("login()... 요기서 났넹");
			errors.reject("isPasswordNotMatch");
			return "member/loginform";
		}
		
		
		return "redirect:/";
	}
	
	
	
}
