package com.web.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.login.model.LoginDTO;
import com.web.login.model.LoginService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/WEB-INF/jsp/login/index.jsp";
		RequestDispatcher rp = request.getRequestDispatcher(view);
		rp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginDTO dto = new LoginDTO(username, password);
		LoginService service = new LoginService(dto);
		
		String view = "/WEB-INF/jsp/login/index.jsp";
		RequestDispatcher rp = request.getRequestDispatcher(view);
		
		if(service.isExisted()) {
			// 아이디가 있는 경우
			if(service.confirmPassword()) {
				// 패스워드가 일치하는 경우
				
				// 방법1. 쿠키 이용하여 로그인 정보 가져오기
				Cookie cookie = new Cookie("login_name", dto.getUsername());
				cookie.setMaxAge(60*30); // 쿠기정보를 일정 유효시간동안만 저장. 즉, 만료시간 설정; 30분 (초단위)
				response.addCookie(cookie); // 응답 시 설정한 쿠키를 같이 보내준다.
				
				// 방법2. 세션 이용하여 로그인 정보 가져오기
				// true: 이미 세션정보가 있으면 있는 정보로 반환하고 없으면 새로 생성한다.(기본)
				// false: 이미 세션정보가 있으면 있는 정보로 반호나하고 없으면 null로 반환.
				HttpSession session = request.getSession();
				session.setAttribute("login_name", dto.getUsername()); // 문자열을 session객체로 저장
				
				response.sendRedirect("/");
			} else {
				// 패스워드 틀림
				request.setAttribute("login_error", "패스워드를 잘못 입력했습니다.");
				System.out.println("패스워드를 잘못 입력했습니다.");
				rp.forward(request, response);
			}
		} else {
			// 아이디 틀림
			request.setAttribute("login_error", "해당 아이디가 없습니다.");
			System.out.println("해당 아이디가 없습니다.");
			rp.forward(request, response);
		}
		
	}

}
