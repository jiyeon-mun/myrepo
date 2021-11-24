package com.web.upload.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload")
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/jsp/upload/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {							
		try {
			// 업로드할 파일 설정
			MultipartRequest multi = new MultipartRequest(request,
					request.getServletContext().getRealPath("/upload"), // 업르도할 파일 저장 위치
					1024*10, // 업로드할 파일의 크기 설정; 바이트 단위; 10MByte
					"utf-8",
					new DefaultFileRenamePolicy()); // 중복되는 파일명인 경우 새로운 이름 생성 객체
			String title = multi.getParameter("title");
			String fileName = multi.getFilesystemName("uploadFile");
			
			// getRealPath("/"); 는 webapp 폴더까지를 의미
			System.out.println("RealPath: "+request.getServletContext().getRealPath("/upload")); // 실제 동작 위치
			System.out.println("일반 텍스트 데이터: "+title);
			System.out.println("업로드 된 파일명: "+fileName);
		} catch (IOException e) {
			String view = "/WEB-INF/jsp/upload/index.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			request.setAttribute("error", "제한 용량 초과(10K)");
			rd.forward(request, response);
		}
	}

}
