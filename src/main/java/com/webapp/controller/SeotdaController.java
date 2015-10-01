package com.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
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
		
		Map<Integer, String> map = new HashMap<>();
		// 1월
		map.put(1, "1p_1");
		map.put(2, "1p_2");
		map.put(3, "1g");
		map.put(4, "1r");
		// 2월
		map.put(5, "2p_1");
		map.put(6, "2p_2");
		map.put(7, "2s");
		map.put(8, "2r");
		// 3월
		map.put(9,  "3p_1");
		map.put(10, "3p_2");
		map.put(11, "3g");
		map.put(12, "3r");
		// 4월
		map.put(13, "4p_1");
		map.put(14, "4p_2");
		map.put(15, "4s");
		map.put(16, "4c");
		// 5월
		map.put(17, "5p_1");
		map.put(18, "5p_2");
		map.put(19, "5c");
		map.put(20, "5y");
		// 6월
		map.put(21, "6p_1");
		map.put(22, "6p_2");
		map.put(23, "6y");
		map.put(24, "6b");
		// 7월
		map.put(25, "7p_1");
		map.put(26, "7p_2");
		map.put(27, "7c");
		map.put(28, "7y");
		// 8월
		map.put(29, "8p_1");
		map.put(30, "8p_2");
		map.put(31, "8g");
		map.put(32, "8s");
		// 9월
		map.put(33, "9p_1");
		map.put(34, "9p_2");
		map.put(35, "9b");
		map.put(36, "9pp");
		// 10월
		map.put(37, "10p_1");
		map.put(38, "10p_2");
		map.put(39, "10b");
		map.put(40, "10y");
		// 11월
		map.put(41, "11p_1");
		map.put(42, "11p_2");
		map.put(43, "11g");
		map.put(44, "11pp");
		// 12월
		map.put(45, "12y");
		map.put(46, "12pp");
		map.put(47, "12g");
		map.put(48, "12d");
		
		Random ran = new Random();
		int num = ran.nextInt(47) + 1;
		
		map.get(num);
		
		writer.println(gson.toJson(map.get(num)));
		writer.close();
	}

	@RequestMapping(value="/result", method=RequestMethod.POST)
	public void getResult(HttpServletResponse response, HttpServletRequest request) throws IOException {
		log.info("getResult()...");
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		String card1 = request.getParameter("card1");
		String card2 = request.getParameter("card2");
		log.info(card1 + " / " + card2);
		
		StringBuffer str = new StringBuffer(card1 + card2);
		log.info(str);
		
		
		
//		String regex = "";
//		Pattern pattern = Pattern.compile(regex);
//		Matcher m = pattern.matcher("zzz");
//		
//		log.info(m.find());
		
//		writer.println(gson.toJson(m.find()));
		writer.close();
	}
}
