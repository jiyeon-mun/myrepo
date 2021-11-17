package com.web.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
