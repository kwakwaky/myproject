package com.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.webapp.model.AuthInfo;
import com.webapp.model.Member;

@Controller
@RequestMapping("/unregist")
public class UnRegistController {
	
	static Log log = LogFactory.getLog(UnRegistController.class);
	Gson gson = new Gson();
	
	@Autowired
	MemberMapper mapper;

	@RequestMapping(method=RequestMethod.GET)
	public String unregist1() {
		log.info("UnRegistController - unregist1()...");
		return "member/unregistform";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void unregist2(HttpServletRequest request, HttpServletResponse response) {
		log.info("UnRegistController - unregist2()...");
		response.setContentType("application/json; charset=utf-8");
		
		int num = ((AuthInfo)request.getSession().getAttribute("auth")).getNum();
		String dbPassword = mapper.selectPasswordByNum(num);
		String password = request.getParameter("password");
		log.info(password + " / " + num);
		
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			
			Map<String, Object> map = new HashMap<String, Object>();
			if (!dbPassword.equals(password)) {
				map.put("a", "비밀번호가 틀렸습니다.");
				map.put("b", "fail");
				writer.println(gson.toJson(map));
			} else {
				map.put("a", "정말 탈퇴하시겠습니까?");
				map.put("b", "success");
				writer.println(gson.toJson(map));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(writer != null) {
				writer.close();
			}
		}
	} 
	
	
	@RequestMapping(value="/action", method=RequestMethod.GET)
	public String unregist3(HttpServletRequest request) {
		log.info("UnRegistController - unregist3()...");
		int num = ((AuthInfo)request.getSession().getAttribute("auth")).getNum();
		mapper.deleteByNum(num);
		
		return "redirect:/logout";
	}
	
}
