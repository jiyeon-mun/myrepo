package com.web.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.guestbook.model.*;

@WebServlet("/guest") // TOMCAT이 해당 페이지 맵핑 후 실행
public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GuestBookService service = new GuestBookService();

	// /guest 페이지 로드 + 방명록 조회 목록(table)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		// 조회된 방명록 결과들이 view에 저장될 수 있도록 설정
		//jsp의 getAttribute("datas")에서 사용될 수 있도록
		request.setAttribute("datas", service.getList());
		
		String view = "/WEB-INF/jsp/guestbook/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	// 입력 데이터 저장 후 제출
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 사용자가 요청한 내용 utf-8 로 인식
		// response.setContentType("text/html; charset=utf-8"); // 서버 응답 시 utf-8; jsp 상단 1번 줄 내용과 동일함
		
		// 사용자 입력 내용, IP 주소 저장
		String context = request.getParameter("context"); // getParameter(): String 리턴; HTML의 데이터 추출
		String ipaddr = request.getRemoteAddr();
		
		GuestBookDTO dto = new GuestBookDTO(ipaddr, context);

		if(service.add(dto)) {
			// 성공: textarea에 입력 내용이 방명록 조회 목록으로 들어가면서 /guest 페이지 로드(doGet 이용)
			response.sendRedirect("/guest"); // 저장하면서 보낸 데이터가 사라짐; 결과 반환
		} else {
			// 실패: 현재 페이지에 입력한 내용을 초기값으로 설정하도록
			request.setAttribute("init", dto); // 속성명 init의 속성값은 2개의 매개변수를 갖는 GuestBookDTO 클래스의 dto객체
			request.setAttribute("datas", service.getList());
			String view = "/WEB-INF/jsp/guestbook/index.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response); // 사용자 입력 데이터를 양식에 넣어줘서 돌려준다.
		}
	}

}
