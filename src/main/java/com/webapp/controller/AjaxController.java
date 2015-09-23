package com.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		
		String id = request.getParameter("id");
		
		if (id.equals("김구")) {
			
			writer.println(gson.toJson("사용가능한 아이디"));
		} else {
			writer.println(gson.toJson("중복된 아이디"));
		}
		
		
		log.info("test()..." + id);
	}
	
}
