package com.kh.team1;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"file:src/main/webapp/WEB-INF/spring/**/*.xml"
})
@WebAppConfiguration
public class DatabaseConnectTest {

	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void test() {
		String result = sqlSession.selectOne("testMapper.test");
		assertEquals("success", result);
	}

}
