package com.my.web.board.model;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
    private SqlSession session;
    
    public List<BoardDTO> selectAll() {
        return this.session.selectList("boardMapper.selectAll");
    }
    
    public List<BoardDTO> selectWriter(int writer) {
    	return this.session.selectList("boardMapper.selectWriter", writer);
    }
    
    public List<BoardDTO> selectTitle(String title) {
    	return this.session.selectList("boardMapper.selectTitle", title);
    }
    
    public BoardDTO selectId(int id) {
    	return this.session.selectOne("boardMapper.selectId", id);
    }
    
    public boolean update(BoardDTO dto) {
        int result = 0;
        result = this.session.update("boardMapper.updateBoard", dto);
        if(result == 1) {
        	return true;
        }
        return false;
    }
    
    public boolean delete(int id) {
    	int result = 0;
        result = this.session.delete("boardMapper.deleteBoard", id);
        if(result == 1) {
        	return true;
        }
        return false;
    }
    
    public boolean insert(BoardDTO dto) { // 게시글 등록
    	int result = 0;
        result = this.session.insert("boardMapper.insertBoard", dto);
        if(result == 1) {
        	return true;
        }
        return false;
    }
    
    public boolean insert(UploadFileDTO dto) { // 게시글 첨부파일 등록
		int result = 0;
		result = this.session.insert("boardMapper.insertUpload", dto);
		if(result == 1) {
			return true;
		}
    	return false;
	}

    public int generateSeq() {
    	return this.session.selectOne("boardMapper.generateSeq");
    }

	public int updateViewCount(int id) {
		return this.session.update("boardMapper.updateViewCount", id);
	}
	
	public int updateGoodCount(int id) {
		return this.session.update("boardMapper.updateGoodCount", id);
	}
	
	public int updateBadCount(int id) {
		return this.session.update("boardMapper.updateBadCount", id);
	}

	public UploadFileDTO selectUploadFile(int id) {
		return this.session.selectOne("boardMapper.selectBoardFile", id);
	}
    
}