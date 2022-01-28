package com.my.web.account.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

	@Autowired
	SqlSession session;
	
	public int insertAccount(AccountDTO dto) {
		return this.session.insert("AccountMapper.insertAccount", dto);
	}
	
	public int insertAccountInfo(AccountInfoDTO dto2) {
		return this.session.insert("AccountMapper.insertAccountInfo", dto2);
	}
	
	public int countingAccount(AccountDTO dto) {
		return this.session.selectOne("AccountMapper.countingAccount", dto);
	}
	
	public int getAutoSequence() {
		return this.session.selectOne("AccountMapper.autoSequence");
	}
	
	public AccountDTO selectAccount(String username) {
		return this.session.selectOne("AccountMapper.selectAccount", username);
	}

	public int updateLoginDate(AccountDTO dto) {
		return this.session.update("AccountMapper.updateLoginDate", dto);
		
	}

}
