package com.kh.team1.account.model;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	@Autowired
	AccountDAO dao;

	public boolean login(String username, String password, HttpSession session) {
		AccountDTO data = new AccountDTO();
		data.setUsername(username); data.setPassword(password);
		
		AccountDTO account = dao.selectUser(data);
		if(account != null) {
			session.setAttribute("account", account);
			session.setAttribute("logined", true);
			return true;
		}
		return false;
	}

	// 아이디 중복 검사
	public boolean duplicate(String username) {
		int data = dao.selectUsername(username);
		if(data == 0) {
			return false;	// 중복 없음
		}
		return true;	// 중복 있음
	}

	public boolean join(String username, String password) {
		AccountDTO data = new AccountDTO();
		data.setUsername(username); data.setPassword(password);
		
		int result = dao.insertAccount(data);
		if(result == 1) {
			return true;
		}
		return false;
	}

	// 계정 비밀번호 변경
	public boolean passwordChange(AccountDTO dto, String modify) {
		// id 로 로그인한 계정 존재 여부 확인하고, 존재하는 계정에 대해서 비밀번호 변경한다.
		System.out.println("Service.passwordChange.dto : " + dto.getMid());
		boolean result = false;
		boolean isConfirm = this.confirm(dto.getMid(), dto.getPassword());
		System.out.println("passwordChangeService : " + dto.getMid() + dto.getPassword());
		System.out.println(modify);
		if(isConfirm) {
			// 기존 패스워드란에 등록된 계정의 패스워드를 맞게 입력한 경우
			// 패스워드 변경 진행
			dto.setPassword(modify);
			result = dao.updatePassword(dto);
			if(result) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	// 계정 비밀번호 변경을 위한 id 확인
	private boolean confirm(int id, String password) {
		System.out.println("AccountService.confirm()");
		
		AccountDTO data = dao.selectId(id);
		System.out.println("AccountService.confirm() : " + data.getPassword());
		
		// 계정에 등록된 패스워드가 사용자 입력 패스워드와 같은지 비교
		// 패스워드 변경을 위한 기존 패스워드 입력의 경우
		if(data.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	// 계정 삭제
	public boolean expire(AccountDTO dto) {
		boolean result = dao.deleteAccount(dto);
		return result;
	}

}
