package com.webapp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.command.RegistCommand;
import com.webapp.mapper.MemberMapper;
import com.webapp.model.AuthInfo;
import com.webapp.model.Member;
import com.webapp.service.MemberUpdateService;

@Controller
public class InfoUpdateController {

	static Log log = LogFactory.getLog(InfoUpdateController.class);
	
	Member member;
	AuthInfo authInfo;
	
	@Autowired
	MemberMapper mapper;
	
	@Autowired
	MemberUpdateService service;
	
	// gender의 라디오버튼을 위한 map을 return
	@ModelAttribute("genderlist")
	public Map<String, String> getGender(HttpSession session) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("male", "남자");
		map.put("female", "여자");
		map.put("guitar", "기타");
		return map;
	}
	
	@RequestMapping(value="/infoupdate", method=RequestMethod.GET)
	public String info(@ModelAttribute("update") RegistCommand command, Model model, HttpSession session) {
		log.info("info()..." + ((AuthInfo)session.getAttribute("auth")).getEmail());
		
		authInfo = (AuthInfo) session.getAttribute("auth");
		member = mapper.selectByEmail(authInfo.getEmail());
		model.addAttribute(member);
		
		return "member/infoupdateform";
	}
	
//	@RequestMapping(value="/update", method=RequestMethod.GET)
//	public String updateForm(@ModelAttribute("update") RegistCommand command, Model model) {
//		log.info("updateForm()..." + member.getEmail());
//		model.addAttribute(member);
//		
//		return "member/updateform";
//	}
	
	@RequestMapping(value="/infoupdate", method=RequestMethod.POST)
	public String update(@ModelAttribute("update") RegistCommand command, HttpSession session) {
		log.info("updateForm()..." + member.getEmail());
		int num = ((AuthInfo)session.getAttribute("auth")).getNum();
		log.info("num = " + num);
		service.update(command, num);
		
		
		return "redirect:/";
	}
	
}
