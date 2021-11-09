package com.web.account.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.account.model.*;

@WebServlet("/account/join") // annotation
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		response.setContentType("text/html; charset=utf-8"); // html 문서가 한글 인식하도록
		// html 문서로 출력; 파일입출력 형식
//		PrintWriter out = response.getWriter();
//		out.write("<h1>Hello Servlet<br>서블릿 동작 확인</h1>");
//		out.close();
		
		String path = "/WEB-INF/jsp/account/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8"); // 한글처리
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		AccountDTO dto = new AccountDTO();
        dto.setUsername(username);
        dto.setPassword(password);
        
        AccountService service = new AccountService(dto);
        
        // 유효성 검사
        String path = "";
        RequestDispatcher rd = null;
        if(!service.isValid()) {
        	path = "/WEB-INF/jsp/account/failed.jsp";
        	rd = request.getRequestDispatcher(path);
        } else {
        	try {
	            if(service.join()) {
	                // response.sendRedirect("./join_success.jsp");
	            	path = "/WEB-INF/jsp/account/success.jsp";
	            	rd = request.getRequestDispatcher(path);
	            } else {
	            	path = "/WEB-INF/jsp/account/failed.jsp";
	            	rd = request.getRequestDispatcher(path);
	            }
        	} catch(SQLException e) {
        		e.printStackTrace();
        	}
        }
        rd.forward(request, response);
	}

}
