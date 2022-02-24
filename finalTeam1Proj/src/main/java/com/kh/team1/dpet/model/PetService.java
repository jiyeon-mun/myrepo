package com.kh.team1.dpet.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

	@Autowired
	PetDAO dao;

	public boolean addPet(PetDTO dto1, PetFileDTO dto2) {
		boolean res = false;
		
		int pno = dao.generateSeq();
		dto1.setPno(pno);
		
		int result1 = dao.insertPet(dto1);
		if(result1 == 1) {
			dto2.setPno(dto1.getPno());
			int result2 = dao.insertPetFile(dto2);
			if(result2 == 1) {
				res = true;
			} else {
				System.out.println("dao.insertPetFile() 과정 에러");
			}
		} else {
			System.out.println("dao.insertPetFile() 과정 에러");
		}
		
		return res;
	}

	public List<PetDTO> getMyPets(int mid) {
		PetDTO data = new PetDTO();
		data.setMid(mid);
		
		List<PetDTO> pets = dao.selectMyPets(data.getMid());
		return pets;
	}

	public boolean removePet(int pno) {
		int result = dao.deletePet(pno);
		if(result == 1) {
			return true;
		}
		return false;
	}
}
