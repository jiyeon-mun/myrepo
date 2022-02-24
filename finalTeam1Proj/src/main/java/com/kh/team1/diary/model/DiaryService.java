package com.kh.team1.diary.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryService {
	
	@Autowired
	DiaryDAO dao;
	
	public List<DiaryDTO> getAll() {
		List<DiaryDTO> datas = dao.selectAll();
		return datas;
	}
	
	public List<DiaryFileDTO> getAllFiles() {
		List<DiaryFileDTO> files = dao.selectAllFiles();
		return files;
	}
	
	public List<DiaryDTO> getAllMine(int mid) {
		DiaryDTO data = new DiaryDTO();
		data.setMid(mid);
		
		List<DiaryDTO> datas = dao.selectAllMine(data.getMid());
		return datas;
	}

	public boolean addDiary(DiaryDTO dto1, DiaryFileDTO dto2) {
		boolean res = false;
		
		int dno = dao.generateSeq(); // 데이터를 저장하기 위해 DIARY 테이블의 다음 시퀀스 값 알아내기.
		dto1.setDno(dno);
		
		int result1 = dao.insertDiary(dto1);
		if(result1 == 1) {
			dto2.setDno(dto1.getDno());
			int result2 = dao.insertDiayFile(dto2);
			if(result2 == 1) {
				res = true;
			} else {
				System.out.println("dao.insertDiaryFile() 과정 에러");
			}
		} else {
			System.out.println("dao.insertDiary() 과정 에러");
		}
		return res;
	}

	public DiaryDTO getDiary(int dno) {
		return dao.selectDiary(dno);
	}

	public DiaryFileDTO getDiaryFile(int dno) {
		return dao.selectDiaryFile(dno);
	}
	
	public List<CommentDTO> getComments(int dno) {
		List<CommentDTO> datas = dao.selectComments(dno);
		return datas;
	}

	public int incGoodCount(int dno) {	
		int result = dao.updateGoodCount(dno); // 추천 수 증가 후
		if(result == 1) {
			return dao.selectDiary(dno).getGcnt(); // 해당 일기 조회하여 gcnt 값 반환
		}
		return -1;
	}

	public boolean addComment(int dno, int mid, String content) {
		CommentDTO data = new CommentDTO();
		data.setDno(dno); data.setMid(mid); data.setContent(content);
		
		int result = dao.insetComment(data);
		if(result == 1) {
			return true;
		}
		return false;
	}
	
	public boolean removeComment(int dno, int dcid) {
		CommentDTO data = new CommentDTO();
		data.setDno(dno); data.setDcid(dcid);
		
		int result = dao.deleteComment(data);
		if(result == 1) {
			return true;
		}
		return false;
	}

	public boolean updateDiary(DiaryDTO dto1, DiaryFileDTO dto2) {
		boolean res = false;
		
		int result1 = dao.updateDiary(dto1);
		if(result1 == 1) {
			dto2.setDno(dto1.getDno());
			int result2 = dao.updateDiaryFile(dto2);
			if(result2 == 1) {
				res = true;
			} else {
				System.out.println("dao.updateDiaryFile() 과정 에러");
			}
		} else {
			System.out.println("dao.updateDiary() 과정 에러");
		}
		
		return res;
	}

	public boolean removeDiary(int dno) {
		int result = dao.deleteDiary(dno);
		if(result == 1) {
			return true;
		}
		return false;
	}

}
