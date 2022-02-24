package com.kh.team1.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.team1.account.model.AccountDTO;
import com.kh.team1.board.model.BoardCategoryDTO;
import com.kh.team1.board.model.BoardDTO;
import com.kh.team1.board.model.BoardSearchDTO;
import com.kh.team1.board.model.BoardService;
import com.kh.team1.board.model.B_FilesDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	   public String getBoardList(Model model, HttpSession session, HttpServletRequest request) {
	      System.out.println("getBoardList()");
	      String keynum = request.getParameter("keynum");
	      String keyword = request.getParameter("keyword");
	      String options = request.getParameter("options");
	      
	      BoardSearchDTO sdto = new BoardSearchDTO();
	      
	      sdto.setKeynum(keynum);
	      sdto.setKeyword(keyword);
	      sdto.setOptions(options);
	      
	      System.out.println("keynum : " + keynum + "keyword : " + keyword + "options : " + options);
	      
	      AccountDTO account = (AccountDTO) session.getAttribute("account");
			if(account.getMid() <= 0) {
				System.out.println("유효하지 않은 세션입니다.");
				return "redirect:/login";
			}
	      
	      List<BoardDTO> datas = boardService.getAll(sdto);
	      List<BoardCategoryDTO> category = boardService.getCategorys();
	      
	      System.out.println(datas);
	      
	      model.addAttribute("datas", datas);
	      model.addAttribute("category", category);
	      
	      return "boardList";
	   }
	   
	   @RequestMapping(value="/board/add", method=RequestMethod.GET)
	   public String getBoardAdd(HttpSession session) {
	      System.out.println("getBoardAdd()");
	      
	      AccountDTO account = (AccountDTO) session.getAttribute("account");
	      if(account.getMid() <= 0) {
	    	  System.out.println("유효하지 않은 세션입니다.");
	    	  return "redirect:/login";
	      }
	      return "boardAdd";
	   }
	   
	   @RequestMapping(value="/board/add", method=RequestMethod.POST)
		public String postBoardAdd(HttpServletRequest request
				, HttpSession session, Model model) throws IOException {
			System.out.println("postBoardAdd()");
			
			AccountDTO account = (AccountDTO) session.getAttribute("account");
			if(account.getMid() <= 0) {
				System.out.println("유효하지 않은 세션입니다.");
				return "redirect:/login";
			}
			
			MultipartRequest multi = new MultipartRequest(
					request,
					request.getServletContext().getRealPath("/upload/bfiles"),
					1024 * 1024 * 10,
					"utf-8",
					new DefaultFileRenamePolicy());
			
			int catid = Integer.parseInt(multi.getParameter("catid"));
			int mid = Integer.parseInt(multi.getParameter("mid"));
			String title = multi.getParameter("title");
			String content = multi.getParameter("content");
			
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setMid(mid);
			if(account.getMid() != boardDTO.getMid()) {
				System.out.println("account.getMid(): "+ account.getMid());
				System.out.println("boardDTO.getMid(): "+ boardDTO.getMid());
				System.out.println("전달된 값과 세션에 저장된 값이 다릅니다.");
				boardDTO.setMid(account.getMid());
				model.addAttribute("error", "전달된 값과 세션에 저장된 값이 다릅니다.");
				return "redirect:/error";
			}
			
			String fileName = multi.getFilesystemName("uploadfile");
			String fileUrl = request.getContextPath() + "/upload/bfiles/" + fileName;
			long fileSize = multi.getFile("uploadfile").length();
			
			BoardDTO dto1 = new BoardDTO();
			
			dto1.setCatid(catid);	dto1.setMid(mid);
			dto1.setTitle(title);	dto1.setContent(content);
			
			B_FilesDTO dto2 = new B_FilesDTO();
			dto2.setFileName(fileName);	dto2.setFileUrl(fileUrl);
			dto2.setFileSize(fileSize);
	
			System.out.println(content);
			System.out.println(dto1.getContent());
			
			boolean result = boardService.addBoard(dto1, dto2);
			if(result) {
				return "redirect:/board/list";
			}
			return "boardAdd";
			
	   }
	   
	   @RequestMapping(value="/board/update", method=RequestMethod.GET)
	   public String getBoardUpdate(int bno, HttpSession session, Model model) {
	      System.out.println("getBoardUpdate()");
	      
	      AccountDTO account = (AccountDTO) session.getAttribute("account");
	      if(account.getMid() <= 0) {
				System.out.println("유효하지 않은 세션입니다.");
				return "redirect:/login";
	      }
	      
	      BoardDTO data = boardService.getBoard(bno);
	      
	      if(data.getMid() != account.getMid()) {
	         model.addAttribute("error", "해당 글을 수정할 권한이 없습니다.");
	         return "redirect:/error";
	      }
	      
	     B_FilesDTO upload = boardService.getBoardFile(bno);
	      
	      model.addAttribute("data", data);
	      model.addAttribute("upload", upload);
	      return "boardUpdate";
	   }
	   
	   @RequestMapping(value="/board/update", method=RequestMethod.POST)
	   public String postBoardUpdate(HttpServletRequest request
				, HttpSession session, Model model) throws IOException {
	      System.out.println("postBoardUpdate()");
	      
	      AccountDTO account = (AccountDTO) session.getAttribute("account");
	      if(account.getMid() <= 0) {
				System.out.println("유효하지 않은 세션입니다.");
				return "redirect:/login";
	      }
			
			MultipartRequest multi = new MultipartRequest(
					request,
					request.getServletContext().getRealPath("/upload/bfiles"),
					1024 * 1024 * 10,
					"utf-8",
					new DefaultFileRenamePolicy());
			
			int bno = Integer.parseInt(multi.getParameter("bno"));
			int catid = Integer.parseInt(multi.getParameter("catid"));
			int mid = Integer.parseInt(multi.getParameter("mid"));
			String title = multi.getParameter("title");
			String content = multi.getParameter("content");
			
			//System.out.println("bno : " + bno + "catid :  " + catid + "mid : " + mid);
			
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setMid(mid);
			if(account.getMid() != boardDTO.getMid()) {
				System.out.println("account.getMid(): "+ account.getMid());
				System.out.println("boardDTO.getMid(): "+ boardDTO.getMid());
				System.out.println("전달된 값과 세션에 저장된 값이 다릅니다.");
				boardDTO.setMid(account.getMid());
				model.addAttribute("error", "전달된 값과 세션에 저장된 값이 다릅니다.");
				return "redirect:/error";
			}
			
			String fileName = multi.getFilesystemName("uploadfile");
			String fileUrl = request.getContextPath() + "/upload/bfiles/" + fileName;
			long fileSize = multi.getFile("uploadfile").length();
			
			BoardDTO dto1 = new BoardDTO();
			
			dto1.setBno(bno);
			dto1.setCatid(catid);	dto1.setMid(mid);
			dto1.setTitle(title);	dto1.setContent(content);
			
			B_FilesDTO dto2 = new B_FilesDTO();
			dto2.setFileName(fileName);	dto2.setFileUrl(fileUrl);
			dto2.setFileSize(fileSize);
	
			System.out.println(content);
			System.out.println(dto1.getContent());
	      
	      boolean result = boardService.updateBoard(dto1, dto2);
	      
	      if(result) {
	         return "redirect:/board/detail?bno=" + bno;
	      }
	      return "boardUpdate";
	   }
	   
	   @RequestMapping(value="/board/delete", method=RequestMethod.POST)
	   public String postBoardDelete(int bno, HttpSession session, Model model) {
	      System.out.println("postBoardDelete()");
	      System.out.println(bno);
	      
	      AccountDTO account = (AccountDTO) session.getAttribute("account");
	      if(account.getMid() <= 0) {
	    	  System.out.println("유효하지 않은 세션입니다.");
	    	  return "redirect:/login";
	      }
	      
	      BoardDTO data = boardService.getBoard(bno);
	      
	      if(data.getMid() != account.getMid()) {
	         model.addAttribute("error", "해당 글을 삭제할 권한이 없습니다.");
	         return "redirect:/error";
	      }
	      
	      boolean result = boardService.removeBoard(bno);
	      
	      if(result) {
	         return "redirect:/board/list";
	      }
	      return "redirect:/board/detail?bno=" + bno;
	   }
	   
	   @RequestMapping(value="/board/detail", method=RequestMethod.GET)
	   public String getBoardDetail(int bno, Model model, HttpSession session) {
	      System.out.println("getBoardDetail()");
	      
	      boolean doIncrement = true;
	      
	      if(session.getAttribute("board-" + bno) != null) {
	    	  System.out.println(bno);
	    	  doIncrement = false;
	      }
	     
	      if(doIncrement) {
	    	  boardService.incViewCount(bno);	
	    	  System.out.println(bno);
	      }
	      
	      BoardDTO data = boardService.getBoard(bno);
	      B_FilesDTO upload = boardService.getBoardFile(data.getBno());
	      
	      session.setAttribute("board-" + bno, true);
	      
	      model.addAttribute("data", data);
	      model.addAttribute("upload", upload);
	      
	      return "boardDetail";
	   }
	   
	   @RequestMapping(value="/board/good", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	   @ResponseBody
	   public String getBoardGoodCount(int bno, HttpSession session) {
		   JSONObject json = new JSONObject();
			
			if(session.getAttribute("board-good-"+bno) == null) {
				int gcnt = boardService.incGoodCount(bno);
				json.put("state", "success");
				json.put("gcnt", gcnt);
			} else {
				json.put("state", "fail");
				json.put("msg", "이미 추천 하였습니다.");
			}
			
			session.setAttribute("board-good-"+bno, true);
			
			return json.toJSONString();
		}
	   
	   @RequestMapping(value="/board/bad", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	   @ResponseBody
	   public String getBoardBadCount(int bno, HttpSession session) {
		   JSONObject json = new JSONObject();
			
			if(session.getAttribute("board-bad-"+bno) == null) {
				int bcnt = boardService.incBadCount(bno);
				json.put("state", "success");
				json.put("bcnt", bcnt);
			} else {
				json.put("state", "fail");
				json.put("msg", "이미 비추천 하였습니다.");
			}
			
			session.setAttribute("board-bad-"+bno, true);
			
			return json.toJSONString();
		}
	   
}