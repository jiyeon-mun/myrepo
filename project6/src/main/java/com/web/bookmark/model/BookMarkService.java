package com.web.bookmark.model;

import java.util.List;

public class BookMarkService {
	
	private BookMarkDAO dao;
	
	public BookMarkService() {
		this.dao = new BookMarkDAO();
	}
	
	public boolean isValid(BookMarkDTO dto) { // 유효성검사
		return true;
	}
	
	public boolean add(BookMarkDTO dto) { // bookmark 등록
		dao.insert(dto);
		return true;
	}
	
	public List<BookMarkDTO> getList() { // 조회목록 출력
		dao.select();
		dao.close();
		return null;
	}
}
