package com.kh.team1.account.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.team1.account.model.AccountDTO;
import com.kh.team1.account.model.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	AccountService service;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String getJoin() {
		System.out.println("getJoin()");
		return "join";
	}
	
	// 아이디 중복 체크(AJAX) + 아이디 유효성 체크
	@RequestMapping(value="/join/duplicate", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	@ResponseBody
	public String duplicateCheck(String username) {		
		boolean isDuplicate = service.duplicate(username); // 아이디 중복 검사
		boolean valid = false; // 아이디 유효성 검사
		
		// 4~12자의 영 소문, 혹은 영 소문+숫자 조합
		String un_check = "^(?!(?:[0-9]+)$)([a-z]|[0-9a-z]){4,12}$";
		Pattern pattern_symbol = Pattern.compile(un_check);
		Matcher matcher_symbol = pattern_symbol.matcher(username);
		
		JSONObject json = new JSONObject();

		if(isDuplicate) {
			json.put("state", "fail");
			json.put("msg", "중복 아이디가 있습니다.");
		} else {
			if(matcher_symbol.find()) {
				valid = true;
				json.put("state", "success");
				json.put("msg", "사용 가능한 아이디 입니다.");
			} else {
				json.put("state", "fail");
				json.put("msg", "4~12자의 영 소문, 혹은 영 소문+숫자 조합.");
			}
		}
		
		return json.toJSONString();
	}
	
	// 패스워드 유효성 체크(AJAX)
	@RequestMapping(value="/join/passValid", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	@ResponseBody
	public String pwValid(String username, String password) {
		boolean valid = false;
		
		//4~15자 하나 이상의 대문자, 하나의 소문자 및 하나의 숫자
		String pw_chk = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{4,15}$";
		
		Pattern pattern_symbol = Pattern.compile(pw_chk); // 정규 표현식 컴파일
		Matcher matcher_symbol = pattern_symbol.matcher(password); // 문자 매칭
		
		JSONObject json = new JSONObject();
		
		if(matcher_symbol.find()) {
			valid = true;
			json.put("state", "success");
			json.put("msg", "유효 비밀번호 입니다.");
		} else {
			json.put("state", "fail");
			json.put("msg", "4~15자 영문 대 소문자,숫자 사용하세요.");
		}
		
		return json.toJSONString();
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String postJoin(String username, String password, String passcheck) {
		System.out.println("postJoin()");
		System.out.println(username+" | "+password+" | "+passcheck);
		
		boolean result = service.join(username, password);
		if(result) {
			return "redirect:/login";
		}
		return "join";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String postLogin() {
		System.out.println("getLogin()");
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String postLogin(String username, String password
			, @RequestParam(name="next", defaultValue="/") String next
			, HttpSession session, Model model) {
		System.out.println("postLogin();");
		System.out.println(username+" | "+password);
		
		boolean result = service.login(username, password, session);
		if(result) {
			System.out.println("로그인 성공!");
			return "redirect:"+next;
		}
		
		System.out.println("로그인 실패!");
		model.addAttribute("error", "잘못된 로그인 정보입니다.");
		return "login";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String getLogout(HttpSession session) {
		System.out.println("로그아웃 요청 GET");
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/memInfo", method=RequestMethod.GET)
	public String getMemInfo(HttpSession session) {
		System.out.println("getMemInfo()");
		return "memInfo";
	}
	
	// 패스워드 변경 진행 
	@RequestMapping(value="/changepw", method=RequestMethod.POST, produces="application/json; charset=utf-8")
	@ResponseBody
	public String changepw(String password, String modify, HttpSession session) {
		// 로그인한 계정 정보에 대해서
		AccountDTO dto = (AccountDTO)session.getAttribute("account");
		dto.setPassword(password);
		
		//4~15자 하나 이상의 대문자, 하나의 소문자 및 하나의 숫자
		String chg_check = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{4,15}$";
		Pattern pattern_symbol = Pattern.compile(chg_check);
		Matcher matcher_symbol = pattern_symbol.matcher(modify);
		boolean valid = false;
		
		JSONObject json = new JSONObject();
		boolean match = matcher_symbol.find();
		System.out.println(password + " | " + modify + " | " + match);
		
		if(match) {
			// 변경 패스워드 유효성 검사 성공
			valid = true;
			boolean result = service.passwordChange(dto, modify); // 패스워드 변경 진행
			if(result) {
				// 패스워드 변경 성공
				json.put("state", "success");
				json.put("message", "변경이 완료되었습니다.");
			} else {
				// 패스워드 변경 실패
				json.put("state", "fail");
				json.put("message", "패스워드 변경에 문제가 발생하였습니다.");
			}
		} else {
			// 변경 패스워드 유효성 검사 실패
			json.put("state", "fail");
			json.put("message", "패스워드 변경에 문제가 발생하였습니다.");
		}
		
		return json.toJSONString();
	}
	
	// 회원 탈퇴 진행
	@RequestMapping(value="/expire", method=RequestMethod.POST, produces="application/json; charset=utf-8")
	@ResponseBody
	public String expire(String password, HttpSession session) {
		AccountDTO dto = null;
		if(session.getAttribute("account") != null) {
			dto = (AccountDTO)session.getAttribute("account");
			dto.setPassword(password);
			System.out.println("번호 : " + dto.getMid());
			System.out.println("아이디 : " + dto.getUsername());
			System.out.println("패스워드 : " + dto.getPassword());
		}
		
		
		JSONObject json = new JSONObject();
		boolean result = service.expire(dto);
		
		if(!result) {
			System.out.println("탈퇴 실패");
			json.put("state", "fail");
			json.put("message", "탈퇴 과정에서 문제가 발생하였습니다.");
		} else {
			System.out.println("탈퇴 성공");
			json.put("state", "success");
			json.put("message", "탈퇴가 완료되었습니다.");
			session.invalidate();
		}
		return json.toJSONString();
	}
}
