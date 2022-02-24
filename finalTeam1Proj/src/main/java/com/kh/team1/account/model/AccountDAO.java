package com.kh.team1.account.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

	@Autowired
	SqlSession sqlSession;
	
	public AccountDTO selectUser(AccountDTO data) {
		return this.sqlSession.selectOne("accountMapper.login", data);
	}

	// 아이디 중복 검사
	public int selectUsername(String username) {
		int data = this.sqlSession.selectOne("accountMapper.countingUser", username);
		return data;
	}

	public int insertAccount(AccountDTO data) {
		return this.sqlSession.insert("accountMapper.insert", data);
	}

	// id 값을 이용하여 계정 정보 존재 확인
	public AccountDTO selectId(int id) {
		AccountDTO data = this.sqlSession.selectOne("accountMapper.selectId", id);
		return data;
	}

	// 로그인 계정 패스워드 변경
	public boolean updatePassword(AccountDTO dto) {
		int result = this.sqlSession.update("accountMapper.updatePassword", dto);
		return result == 1 ? true : false;
	}
	
	// 아이디삭제
	public boolean deleteAccount(AccountDTO dto) {
		int result = this.sqlSession.delete("accountMapper.deleteAccount", dto);
		return result == 1 ? true : false;
	}
	
}