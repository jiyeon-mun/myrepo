package com.web.guestbook.model;

import java.sql.SQLException;
import java.util.List;

public class GuestBookService {
	public boolean add(GuestBookDTO dto) { // 방명록 추가 실행
		try {
			GuestBookDAO dao = new GuestBookDAO();
			if(dao.insert(dto)) {
	        	dao.commit();
	        	return true;
	        } else {
	        	dao.rollback();
	        	return false;
	        }
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<GuestBookDTO> getList() { // 방명록 조회결과 출력
		return null;
	}
}