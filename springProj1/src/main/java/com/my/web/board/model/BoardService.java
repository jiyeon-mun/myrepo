package com.my.web.board.model;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.web.member.model.MemberDAO;

@Service
public class BoardService {
	
	@Autowired
    private BoardDAO dao;
	
	@Autowired
	private MemberDAO mdao;

    public List<BoardDTO> getAllBoards() {
        return dao.selectAll();
    }
    
    public List<BoardDTO> getWriterBoards(String writer) {
    	// writer(username) 를 입력받으면 해당 writer(username) 의 id 값을 가져오도록
        int id = 0;
        id = mdao.selectMemberId(writer);
        // 해당 id 의 게시글 목록 반환
        return dao.selectWriter(id);
    }
    
    public List<BoardDTO> getTitleBoards(String title) {
        return dao.selectTitle(title);
    }
    
    public BoardDTO getBoard(int id) {
        return dao.selectId(id);
    }
    
    public boolean updateBoard(BoardDTO dto) {
        return dao.update(dto);
    }
    
    public boolean deleteBoard(int id) {
        return dao.delete(id);
    }
    
    public int insertBoard(BoardDTO dto) {
    	// 저장된 데이터(게시글)의 ID 값을 알아오는 작업이 필요
    	int id = dao.generateSeq();
    	dto.setId(id);
    	
    	// 가져온 id 값에 대해 insert 작업 실행 후 해당 id 값 반환
        boolean result = dao.insert(dto);
        if(result) {
        	return id;
        }
    	return 0;
    }

	public void incViewCount(int id) {
		int result = dao.updateViewCount(id);
	}
	
	public int incGoodCount(int id) {
		int result = dao.updateGoodCount(id);
		
		if(result == 1) {
			return dao.selectId(id).getGcnt();
		}
		return -1;
	}
	
	public int incBadCount(int id) {
		int result = dao.updateBadCount(id);
		
		if(result == 1) {
			return dao.selectId(id).getBcnt();
		}
		return -1;
	}

}