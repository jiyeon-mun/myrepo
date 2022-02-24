package com.kh.team1.board.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<BoardDTO> selectAll(BoardSearchDTO sdto) {
		return sqlSession.selectList("boardMapper.all", sdto);
	}

	public List<BoardCategoryDTO> selectCategory() {
		return sqlSession.selectList("boardMapper.catAll");
	}
	public BoardDTO selectBoard(int bno) {
		return sqlSession.selectOne("boardMapper.detail", bno);
	}

	public int insertBoard(BoardDTO dto1) {
		return sqlSession.insert("boardMapper.add", dto1);
	}

	public int insertBoard(B_FilesDTO dto2) {
		return sqlSession.insert("boardMapper.fileAdd", dto2);
		
	}
	
	public int updateBoard(BoardDTO dto1) {
		return sqlSession.update("boardMapper.update", dto1);
	}
	
	public int updateBoard(B_FilesDTO dto2) {
		return sqlSession.update("boardMapper.updateBfile", dto2);
	}

	public int deleteBoard(int bno) {
		return sqlSession.delete("boardMapper.delete", bno);
	}

	public int updateViewCount(int bno) {
		return sqlSession.update("boardMapper.updateViewCount", bno);
	}
	
	public int seqBoard() {
		return sqlSession.selectOne("boardMapper.select");
	}

	public B_FilesDTO selectBoardFile(int bno) {
		return sqlSession.selectOne("boardMapper.BoardFile", bno);
	}
	
	public int updateGoodCount(int bno) {
		return sqlSession.update("boardMapper.updateGoodCount", bno);		
	}

	public int updateBadCount(int bno) {
		return sqlSession.update("boardMapper.updateBadCount", bno);
		
	}
	
}