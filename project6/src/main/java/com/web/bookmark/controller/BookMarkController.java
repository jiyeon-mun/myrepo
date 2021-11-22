package com.web.bookmark.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.bookmark.model.*;

@WebServlet("/bookmark")
public class BookMarkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 페이지 로드 + 북마크 목록
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// forward: 특정 서블릿에 대한 요청을 다른 서블릿이나 jsp로 넘겨준다.(파라미터를 넘길 수 있다.)
		String view = "/WEB-INF/jsp/bookmark/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	// 북마크 등록 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 사용자 요청 정보는 utf-8로 인코딩
		
		String name = request.getParameter("bookmark_name");
		String url = request.getParameter("bookmark_url");
		
		BookMarkDTO dto = new BookMarkDTO(name, url);
		BookMarkService service = new BookMarkService(); // 등록,조회,유효성검사
		
		if(service.isValid(dto)) {
			// 유효성 검사 통과한 경우
			if(service.save(dto)) {
				// 북마크 등록 성공
			} else {
				// 북마크 등록 실패
			}
		} else {
			// 유효성 검사 실패한 경우
		}
	}

}
