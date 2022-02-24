package com.kh.team1.board.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardService {
	
	@Autowired
	BoardDAO dao;
	
	public List<BoardDTO> getAll(BoardSearchDTO sdto) {
		List<BoardDTO> datas = dao.selectAll(sdto);
		return datas;
	}

	public BoardDTO getBoard(int bno) {
		BoardDTO data = dao.selectBoard(bno);
		return data;
	}

	public boolean addBoard(BoardDTO dto1,B_FilesDTO dto2) {
		dto1.setBno(dao.seqBoard());
		boolean res = false;
		
		int res1 = dao.insertBoard(dto1);
		
		if(res1 == 1)	{
			dto2.setBno(dto1.getBno());
			int res2 = dao.insertBoard(dto2);
			if(res2 == 1) {
				res = true;
			} else
				System.out.println("upload 오류");
		} else {
			System.out.println("add 오류");
		}
		return res;
	}

	public boolean updateBoard(BoardDTO dto1,B_FilesDTO dto2) {
		
		boolean res = false;
		int res1 = dao.updateBoard(dto1);
		System.out.println(res1);
		if(res1 == 1)	{
			System.out.println(res1);
			dto2.setBno(dto1.getBno());
			int res2 = dao.updateBoard(dto2);
			System.out.println(res2);
			if(res2 == 1) {
				System.out.println(res2);
				res = true;
			} else
				System.out.println("upload 오류");
		} else {
			System.out.println("add 오류");
		}
		return res;
	}

	public boolean removeBoard(int bno) {
		int result = dao.deleteBoard(bno);
		if(result == 1) {
			return true;
		}
		return false;
	}

	public boolean incViewCount(int bno) {
		int result = dao.updateViewCount(bno);
		if(result == 1) {
			return true;
		}
		return false;
	}

	public List<BoardCategoryDTO> getCategorys() {
		List<BoardCategoryDTO> datas = dao.selectCategory();
		return datas;
	}

	public B_FilesDTO getBoardFile(int bno) {
		return dao.selectBoardFile(bno);
	}
	
	public int incGoodCount(int bno) {
		int result = dao.updateGoodCount(bno);
		if(result == 1) {
			return dao.selectBoard(bno).getGcnt();
		}
		return -1;
	}

	public int incBadCount(int bno) {
		int result = dao.updateBadCount(bno);
		if(result == 1) {
			return dao.selectBoard(bno).getBcnt();
		}
		return -1;
	}

}