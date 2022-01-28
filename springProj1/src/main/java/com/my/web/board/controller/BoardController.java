package com.my.web.board.controller;

import java.util.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.web.account.model.AccountDTO;
import com.my.web.board.model.*;

@Controller
public class BoardController {

	@Autowired
    private BoardService service;
	
	@RequestMapping(value="/board", method=RequestMethod.GET)
    public String boardList(String writer, String title, Model model) {
    	System.out.println("boardList 메서드 실행합니다.");
    	
    	List<BoardDTO> datas = null;
    	
    	if(writer != null && title == null) {
    		// 작성자 조회 -> writer 는 null 이 아니고 title 은 null
    		System.out.println("[boardList] 작성자 조회 동작");
    		datas = service.getWriterBoards(writer);
    	} else if(writer == null && title != null) {
    		// 제목 조회 -> writer 는 null 이고 title 은 null 이 아님
    		System.out.println("[boardList] 제목 조회 동작");
    		datas = service.getTitleBoards(title);
    	} else {
    		// 전체 조회
    		System.out.println("[boardList] 전체 조회 동작");
    		datas = service.getAllBoards();
    	}

    	model.addAttribute("datas", datas);
    	
        return "board/list";
    }
    
	@RequestMapping(value="/board/add", method=RequestMethod.GET)
    public String boardAdd() {
		System.out.println("boardAdd 메서드 동작");
        return "board/add";
    }
    
	@RequestMapping(value="/board/add", method=RequestMethod.POST)
    public String boardAdd(BoardDTO boardDTO, HttpSession session, Model model) {

		AccountDTO account = (AccountDTO)session.getAttribute("account");
		
		if(account.getId() != boardDTO.getMemid()) {
			boardDTO.setMemid(account.getId());
			System.out.println("전달된 값과 세션에 저장된 값이 다름니다.");
		}

		// 저장이 되면 게시판 테이블의 ID 컬럼의 값을 반환한다.
		int id = service.insertBoard(boardDTO);
		
		if(id > 0) {
			// 저장 성공 후 해당 게시글의 id값을 받아 상세 페이지 이동
			return "redirect:/board/detail?id=" + id;
		}
		
		System.out.println("[boardAdd] 저장 작업중 문제 발생!!");
		return "board/add";
    }
    
	@RequestMapping(value="/board/modify", method=RequestMethod.GET)
    public String boardModify(int id, HttpSession session, Model model) {
		System.out.println("boardModify 메서드 동작");
		
    	AccountDTO account = (AccountDTO)session.getAttribute("account");
        BoardDTO data = service.getBoard(id);
        
		if(data.getMemid() != account.getId()) {
			return "redirect:/board";
		}
		
        model.addAttribute("data", data);
        return "board/modify";
    }
    
	@RequestMapping(value="/board/modify", method=RequestMethod.POST)
    public String boardModify(BoardDTO boardDTO, HttpSession session, Model model) {
		AccountDTO account = (AccountDTO)session.getAttribute("account");
		BoardDTO data = service.getBoard(boardDTO.getId());
		
		if(data.getMemid() != account.getId()) {
			return "redirect:/board";
		}
		
		boolean result = service.updateBoard(boardDTO);
		if(result) {
			return "redirect:/board/detail?id=" + boardDTO.getId();
		}
		
		System.out.println("수정 중 문제가 발생하였습니다.");
        return "board/modify";
    }
    
	@RequestMapping(value="board/delete", method=RequestMethod.GET)
    public String boardRemove(int id, HttpSession session) {
		AccountDTO account = (AccountDTO)session.getAttribute("account");
		BoardDTO data = service.getBoard(id);
		
		if(data.getMemid() != account.getId()) {
			return "redirect:/error/nodelete";
		}
		
		boolean result = service.deleteBoard(data.getId());
		if(result) {
			return "redirect:/board";
		}
        return "redirect:/board/detail?id="+ data.getId();
    }
    
	// 쿠키 이용하여 조회수 증가
//    @RequestMapping(value="/board/detail", method=RequestMethod.GET)
//    public String boardDetail(int id, Model model, HttpServletRequest request, HttpServletResponse response) {
//    	boolean doIncrement = true;
//    	Cookie[] cookies = request.getCookies(); // 쿠키 가져오기
//    	
//    	for(Cookie c: cookies) {
//    		if(c.getName().equals("board-"+id)) {
//    			// board-id 쿠키명이 있다면 doIncrement 값이 false
//    			doIncrement = false;
//    		}
//    	}
//    	
//    	if(doIncrement) {
//    		// 조회수 증가; 쿠키가 존재할 때 조회수가 증가되지 않도록
//    		// 새롭게 접근하는 게시글에는 board-id 쿠키명이 존재하지 않는다. -> 조회수 1 증가
//    		service.incViewCount(id);
//    	}
//    	
//        BoardDTO data = service.getBoard(id);
//        
//        // 조회 시 쿠키 생성
//        Cookie cookie = new Cookie("board-"+id, "true"); // (String)쿠키명, (String)쿠키값
//        response.addCookie(cookie); // 응답할 때 쿠키 추가
//        
//        model.addAttribute("data", data);
//        return "board/detail";
//    }
    
	// 세션 이용하여 조회수 증가
    @RequestMapping(value="/board/detail", method=RequestMethod.GET)
    public String boardDetail(int id, Model model, HttpSession session) {
    	System.out.println("board id "+id+" 게시글 상세보기");
    	boolean doIncrement = true;
    	
    	if(session.getAttribute("board-"+id) != null) {
    		// 세션이 존재하는 경우 false 로 조회수 증가하지 않음
    		doIncrement = false;
    	}
    	
    	if(doIncrement) {
    		// 처음 접근하는 경우 세션이 생성되기 때문에 조회수 1 증가
    		service.incViewCount(id);
    	}
    	
        BoardDTO data = service.getBoard(id);
        
        session.setAttribute("board-"+id, true); // 세션 생성; 키, 값
        
        
        model.addAttribute("data", data);
        return "board/detail";
    }
    
    @RequestMapping(value="/board/gcnt", method = RequestMethod.GET, produces="application/json; charset=utf-8")
    @ResponseBody
    public String boardGcnt(int id, HttpSession session) {
    	System.out.println("boardNum: "+id);
    	JSONObject json = new JSONObject();
    	
    	BoardDTO dto = new BoardDTO();
    	dto.setId(id);
    	
    	// 세션이 존재하지 않는, 게시글에 처음 접근하는 경우에만 추천수 증가하도록
    	if(session.getAttribute("board-good-"+id) == null) {
    		int gcnt = service.incGoodCount(id); // 추천을 증가시키면 증가가 된 후의 정수값이 반환
    		
    		json.put("state", "success");
    		json.put("cnt", gcnt);
    	} else {
    		json.put("state", "fail");
    		json.put("msg", "추천/비추천은 각각 한 번씩만 가능합니다.");
    	}
    	
    	session.setAttribute("board-good-"+id, true); // 세션 생성
    	
    	return json.toJSONString();
    }
    
    @RequestMapping(value="/board/bcnt", method = RequestMethod.GET, produces="application/json; charset=utf-8")
    @ResponseBody
    public String boardBcnt(int id, HttpSession session) {
    	System.out.println("boardNum: "+id);
    	JSONObject json = new JSONObject();
    	
    	// 세션이 존재하지 않는, 게시글에 처음 접근하는 경우에만 비추천수 증가
    	if(session.getAttribute("board-bad-"+id) == null) {
    		int bcnt = service.incBadCount(id); // 비추천을 증가시키면 증가가 된 후의 정수값이 반환
    		
    		json.put("state", "success");
    		json.put("cnt", bcnt);
    	} else {
    		json.put("state", "fail");
    		json.put("msg", "추천/비추천은 각각 한 번씩만 가능합니다.");
    	}
    	
    	session.setAttribute("board-bad-"+id, true); // 세션 생성
    	
    	return json.toJSONString();
    }

}