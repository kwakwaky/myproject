package com.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

@Controller
@RequestMapping("/seotda")
public class SeotdaController {
	
	static Log log = LogFactory.getLog(SeotdaController.class);
	
	Gson gson = new Gson();
	
	@RequestMapping(method=RequestMethod.GET)
	public String hello() {
		log.info("hello()...");
		
		return "seotda/seotda";
	}
	
	@RequestMapping(value="/counting", method=RequestMethod.GET)
	public void counting(HttpServletResponse response) throws IOException {
		log.info("counting()...");
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		writer.println(gson.toJson(""));
		
	}

}
