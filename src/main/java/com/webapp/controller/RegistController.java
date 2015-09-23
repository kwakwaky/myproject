package com.webapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/regist")
public class RegistController {
	
	static Log log = LogFactory.getLog(RegistController.class);

	@RequestMapping(method=RequestMethod.GET)
	public String registForm() {
		
		log.info("registForm()...");
		
		return "member/registform";
	}
	
}
