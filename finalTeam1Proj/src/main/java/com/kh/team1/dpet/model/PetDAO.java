package com.kh.team1.dpet.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PetDAO {

	@Autowired
	SqlSession sqlSession;

	public int generateSeq() {
		return this.sqlSession.selectOne("petMapper.generateSeq");
	}

	public int insertPet(PetDTO dto1) {
		return this.sqlSession.insert("petMapper.insertPet", dto1);
	}

	public int insertPetFile(PetFileDTO dto2) {
		return this.sqlSession.insert("petMapper.insertPetFile", dto2);
	}

	public List<PetDTO> selectMyPets(int mid) {
		return this.sqlSession.selectList("petMapper.allMyPets", mid);
	}
	
	public int deletePet(int pno) {
		return this.sqlSession.delete("petMapper.delete", pno);
	}
}
