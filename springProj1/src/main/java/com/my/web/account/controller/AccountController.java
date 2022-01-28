package com.my.web.account.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.web.account.model.*;

@Controller
@RequestMapping(value="/account")
public class AccountController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	AccountService service;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		logger.info("Forward To account/join.jsp");
		return "account/join";
	}
	
	@RequestMapping(value="/join/duplexUsername", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	@ResponseBody
	public String duplexUsername(String username) {
		JSONObject json = new JSONObject();
		
		AccountDTO dto = new AccountDTO();
		dto.setUsername(username);
		
		boolean isDuplicate = service.duplicate(dto); // 계정명 중복 검사
		boolean isValid = false; // 계정명 유효성 검사
		
		// 4~12자의 영 소문, 혹은 영 소문+숫자 조합
		String chkUsername = "^(?!(?:[0-9]+)$)([a-z]|[0-9a-z]){4,12}$";
		Pattern pattern_symbol = Pattern.compile(chkUsername);
		Matcher matcher_symbol = pattern_symbol.matcher(username);
		
		if(isDuplicate) {
			json.put("state", "fail");
			json.put("msg", "중복 아이디가 있습니다.");
		} else {
			if(matcher_symbol.find()) {
				isValid = true;
				json.put("state", "success");
				json.put("msg", "사용 가능한 아이디 입니다.");
			} else {
				json.put("state", "fail");
				json.put("msg", "4~12자의 영문 소문자, 숫자를 사용하세요.");
			}
		}
		
		return json.toJSONString();
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(JoinVO joinVO) {
		logger.info("Receive Data: "+joinVO);
		
		try {
			boolean result = service.join(joinVO);
			if(result) {
				return "redirect:/account/login";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "account/join";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		logger.info("Forward To account/login.jsp");
		return "account/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String username, String password, HttpSession session,
			@RequestParam(name="next", defaultValue="/") String next) {
		logger.info("Receive Data: "+ username+", "+password);
		
		AccountDTO dto = new AccountDTO();
		dto.setUsername(username);
		dto.setPassword(password);
		
		boolean result = service.login(dto);
		if(result) {
			session.setAttribute("logined", true);
			session.setAttribute("account", dto);
			return "redirect:"+next;
		}
		return "account/login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
