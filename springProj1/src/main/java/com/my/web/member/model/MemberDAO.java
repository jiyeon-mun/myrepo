package com.my.web.member.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession session;
	
	public int selectMemberId(String username) {
		return session.selectOne("memberMapper.selectMemberId", username);
	}
}
