package com.kh.team1.diary.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DiaryDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<DiaryDTO> selectAll() {
		return this.sqlSession.selectList("diaryMapper.all");
	}

	public List<DiaryFileDTO> selectAllFiles() {
		return this.sqlSession.selectList("diaryMapper.allFiles");
	}
	
	public List<DiaryDTO> selectAllMine(int mid) {
		return this.sqlSession.selectList("diaryMapper.allMine", mid);
	}

	public int generateSeq() {
		return this.sqlSession.selectOne("diaryMapper.generateSeq");
	}

	public int insertDiary(DiaryDTO dto1) {
		return this.sqlSession.insert("diaryMapper.insertDiary", dto1);
	}

	public int insertDiayFile(DiaryFileDTO dto2) {
		return this.sqlSession.insert("diaryMapper.insertDiaryFile", dto2);
	}

	public DiaryDTO selectDiary(int dno) {
		return this.sqlSession.selectOne("diaryMapper.detail", dno);
	}

	public DiaryFileDTO selectDiaryFile(int dno) {
		return this.sqlSession.selectOne("diaryMapper.detailFile", dno);
	}
	
	public List<CommentDTO> selectComments(int dno) {
		return this.sqlSession.selectList("diaryMapper.selectComments", dno);
	}

	public int updateGoodCount(int dno) {
		return sqlSession.update("diaryMapper.updateGoodCount", dno);
	}

	public int insetComment(CommentDTO data) {
		return sqlSession.insert("diaryMapper.insetComment", data);
	}
	
	public int deleteComment(CommentDTO data) {
		return sqlSession.delete("diaryMapper.deleteComment", data);
	}

	public int updateDiary(DiaryDTO dto1) {
		return this.sqlSession.update("diaryMapper.updateDiary", dto1);
	}

	public int updateDiaryFile(DiaryFileDTO dto2) {
		return this.sqlSession.update("diaryMapper.updateDiaryFile", dto2);
	}
	
	public int deleteDiary(int dno) {
		return this.sqlSession.delete("diaryMapper.delete", dno);
	}

}
