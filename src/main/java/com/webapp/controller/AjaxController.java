package com.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
	
	static Log log = LogFactory.getLog(AjaxController.class);
	
	Gson gson = new Gson();
	
	@RequestMapping(value="/member", method=RequestMethod.POST)
	public void test(HttpServletRequest request) {
		
		log.info("test()...");
	}
	
}
