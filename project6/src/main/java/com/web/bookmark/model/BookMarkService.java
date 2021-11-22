package com.web.bookmark.model;

import java.util.List;

public class BookMarkService {
	
	private BookMarkDAO dao;
	
	public BookMarkService() {
		this.dao = new BookMarkDAO(); // 실질적인 검사는 BookMarkDAO 클래스에서 데이터베이스에 연결하여 시행한다.
	}

	public boolean isValid(BookMarkDTO dto) { // 유효성 검사
		
		return false;
	}

	public boolean save(BookMarkDTO dto) { // 북마크 등록
		
		return dao.insert(dto);
	}
	
	public List<BookMarkDTO> getBookMarkList() { // 등록된 북마크 조회
		dao.select();
		dao.close();
		return null;
	}
}
