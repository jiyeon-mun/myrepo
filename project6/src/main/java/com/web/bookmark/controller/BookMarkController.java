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
		
		String alias = request.getParameter("alias"); // 별칭
		String url = request.getParameter("url"); // url 주소
		
		BookMarkDTO dto = new BookMarkDTO(alias, url);
		
		BookMarkService service = new BookMarkService(); // 등록,조회,유효성검사
		if(service.isValid(dto)) {
			// 유효성검사 통과
			if(service.add(dto)) { // 등록 완료: 입력한 내용 조회목록에 추가되면서 현재페이지 재로드(초기화)
				response.sendRedirect("/bookmark");
			} else { // 등록 실패: 입력된 내용을 초기값으로 가지는 현재페이지 재로드
				
				/* action으로 넘어온 값(alias,url)을 변경시킨 후(init) JSP페이지로 넘겨주기 위해서는
				 setAttribute()를 써서 넘겨주고 JSP페이지에서는 getAttribute()를 써서 받는다. */
				request.setAttribute("init", dto); // 속성 init의 속성값은 dto객체 
				String view = "/WEB-INF/jsp/bookmark/index.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request, response);
				
			}
		} else {
			// 유효성검사 실패
		}
	}

}
