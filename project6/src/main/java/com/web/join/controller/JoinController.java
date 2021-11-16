package com.web.join.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.join.model.*;

@WebServlet("/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// forward: 이 위치로 페이지 로드
		String view = "/WEB-INF/jsp/join/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password_check = request.getParameter("password_check");
		
		JoinDTO dto = new JoinDTO(
				request.getParameter("username"),
				request.getParameter("password"),
				request.getParameter("email"));
		
		JoinService service = new JoinService(dto);
		
		request.setAttribute("initData", dto); // 로그인 실패 시 패스워드 제외한 나머지 입력란에 기존 입력 내용 초기화한 상태로 페이지 로드할 수 있도록
		String view = "/WEB-INF/jsp/join/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		
		// 유효성 검사
		if(service.isValid() == 0) { // 유효성 검사에 이상이 없는 경우
			
			// 패스워드 일치 검사
			if(service.equalPassword(password_check)) { // 동일한 패스워드 입력한 경우
				
				// 아이디 중복 검사
				if(service.isDuplicated()) { // 중복된 아이디가 있는 경우
					rd.forward(request, response);
				} else { // 중복된 아이디가 없는 경우
					service.createJoin();
					response.sendRedirect("./login");
				}
				
			} else { // 동일한 패스워드가 아닌 경우
				rd.forward(request, response);
			}
			
		} else { // 유효성 검사에 이상이 있는 경우
			rd.forward(request, response);
		}
		
	}

}
