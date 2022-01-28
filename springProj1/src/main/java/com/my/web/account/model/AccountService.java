package com.my.web.account.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	AccountDAO dao;
	
	@Transactional(rollbackFor=Exception.class)
	public boolean join(JoinVO joinVO) throws Exception {
		// 패스워드 동일 검사
		if(!joinVO.getPassword().equals(joinVO.getPasschk())) {
			logger.error("패스워드 불일치!");
			throw new Exception("패스워드 불일치");
		}
		
		AccountDTO dto = new AccountDTO();
		dto.setUsername(joinVO.getUsername());
		dto.setPassword(joinVO.getPassword());
		
		// 중복 계정 확인
		if(dao.countingAccount(dto) != 0) {
			logger.error("중복 아이디 발견!");
			throw new Exception("중복 아이디 발견");
		}
		
		dto.setId(dao.getAutoSequence()); // 자동 증가 번호 획득 후 DTO 객체에 설정
		
		// 회원가입: 새로운 계정 등록 후 해당 계정에 대한 회원 정보 등록
		if(dao.insertAccount(dto) == 1) {
			AccountInfoDTO dto2 = new AccountInfoDTO();
			dto2.setId(dto.getId());
			dto2.setFirstName("");
			dto2.setLastName("");
			dto2.setBirthday(joinVO.getBirthday());
			dto2.setEmail1(joinVO.getEmail1());
			dto2.setEmail2(joinVO.getEmail2());
			
			if(dao.insertAccountInfo(dto2) == 1) {
				return true;
			} else {
				logger.error("회원 정보 추가 중 에러 발생!");
				throw new Exception("회원 정보 추가 중 에러 발생");
			}
		} else {
			logger.error("회원 등록 중 에러 발생!");
			throw new Exception("회원 등록 중 에러 발생");
		} 
	}

	public boolean login(AccountDTO dto) {
		AccountDTO data = dao.selectAccount(dto.getUsername());
		if(data != null) {
			if(data.getPassword().equals(dto.getPassword())) {				
				dto.setId(data.getId());
				dto.setPassword("");
				dto.setLoginDate(data.getLoginDate());
				dto.setJoinDate(data.getJoinDate());
				dto.setDormant(data.getDormant());
				dto.setExpire(data.getExpire());
				dto.setAdmin(dto.getAdmin());
				dto.setStaff(data.getStaff());
				return true;
			} else {
				logger.info("패스워드 불일치");
				return false;
			}
		} else {
			logger.info("해당 계정이 존재하지 않습니다.");
			return false;
		}
	}

	public boolean duplicate(AccountDTO dto) {
		if(dao.countingAccount(dto) == 0) {
			return false; // 중복 있음
		}
		return true; // 중복 없음
	}
	
	public boolean checkPwd(AccountDTO dto) {
		AccountDTO data = dao.selectAccount(dto.getUsername());
		
		String dbasePass = data.getPassword();
		String inputPass = dto.getPassword();
		
		if(dbasePass.equals(inputPass)) {
			return true;
		}
		return false;
	}

}
