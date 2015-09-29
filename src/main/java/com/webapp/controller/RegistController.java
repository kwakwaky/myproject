package com.webapp.controller;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.command.RegistCommand;
import com.webapp.service.MemberRegistService;

@Controller
@RequestMapping("/regist")
public class RegistController {
	
	static Log log = LogFactory.getLog(RegistController.class);
	
	@Autowired
	MemberRegistService service;
	
	// gender의 라디오버튼을 위한 map을 return
	@ModelAttribute("genderlist")
	public Map<String, String> getGender(HttpSession session) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("male", "남자");
		map.put("female", "여자");
		map.put("guitar", "기타");
		return map;
	}
	

	@RequestMapping(method=RequestMethod.GET)
	public String registForm(@ModelAttribute("regist") RegistCommand command) {
		log.info("registForm()...");
		
		return "member/registform";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String regist(@ModelAttribute("regist") RegistCommand command) {
		log.info("regist()...");
		
		try {
			
			log.info("gender = " + command.getGender());
			log.info("choice = " + command.getChoice());
			service.register(command.getMember());
		} catch (Exception e) {
			log.error("regist() 요기서 에러남", e);
			e.getStackTrace();
//			errors.reject("duplicate"); // reject는 글로벌 에러
			return "member/registForm";
		}
		
		
		return "redirect:/";
	}
	
}
