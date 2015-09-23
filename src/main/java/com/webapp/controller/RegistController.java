package com.webapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.command.RegistCommand;

@Controller
@RequestMapping("/regist")
public class RegistController {
	
	static Log log = LogFactory.getLog(RegistController.class);

	@RequestMapping(method=RequestMethod.GET)
	public String registForm(@ModelAttribute("regist") RegistCommand command) {
		log.info("registForm()...");
		
		return "member/registform";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String regist(@ModelAttribute("regist") RegistCommand command) {
		log.info("regist()...");
		
		
		
		return "redirect:/";
	}
	
}
