package com.kh.team1.diary.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.team1.account.model.AccountDTO;
import com.kh.team1.diary.model.*;
import com.kh.team1.dpet.model.*;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class DiaryController {
	
	@Autowired
	DiaryService diaryService;
	
	@Autowired
	PetService petService;

	@RequestMapping(value="/diary/list", method=RequestMethod.GET)
	public String getDiaryList(HttpSession session, Model model) {
		System.out.println("getDiaryList()");
		
		AccountDTO account = (AccountDTO) session.getAttribute("account");
//		if(session.getAttribute("account") == null) {
//			System.out.println("로그인 정보가 없습니다.");
//			return "redirect:/login";
//		}
		if(account.getMid() <= 0) {
			System.out.println("유효하지 않은 세션입니다.");
			return "redirect:/login";
		}
		System.out.println(account.getMid()+" | "+account.getUsername());
		
		List<DiaryDTO> datas = diaryService.getAllMine(account.getMid());
		List<PetDTO> pets = petService.getMyPets(account.getMid());
		
		model.addAttribute("datas",datas);
		model.addAttribute("pets",pets);
		return "diaryList";
	}
	
	@RequestMapping(value="/diary/add", method=RequestMethod.GET)
	public String getDiaryAdd(HttpSession session) {
		System.out.println("getDiaryAdd()");
		
		AccountDTO account = (AccountDTO) session.getAttribute("account");
		if(account.getMid() <= 0) {
			System.out.println("유효하지 않은 세션입니다.");
			return "redirect:/login";
		}
		return "diaryAdd";
	}
	
	@RequestMapping(value="/diary/add", method=RequestMethod.POST)
	public String postDiaryAdd(HttpServletRequest request
			, HttpSession session, Model model) throws IOException {
		System.out.println("postDiaryAdd()");
		
		AccountDTO account = (AccountDTO) session.getAttribute("account");
		if(account.getMid() <= 0) {
			System.out.println("유효하지 않은 세션입니다.");
			return "redirect:/login";
		}
		
		MultipartRequest multi = new MultipartRequest(
				request, 
				request.getServletContext().getRealPath("/upload/dfiles"), 
				1024*1024*10,
				"utf-8",
				new DefaultFileRenamePolicy());
		
		String title = multi.getParameter("title");
		int mid = Integer.parseInt(multi.getParameter("mid"));
		String content = multi.getParameter("content");
		
		DiaryDTO diaryDTO = new DiaryDTO();
		diaryDTO.setMid(mid);
		if(account.getMid() != diaryDTO.getMid()) {
			System.out.println("account.getMid(): "+account.getMid());
			System.out.println("diaryDTO.getMid(): "+diaryDTO.getMid());
			System.out.println("전달된 값과 세션에 저장된 값이 다릅니다.");
			diaryDTO.setMid(account.getMid());
			model.addAttribute("error", "전달된 값과 세션에 저장된 값이 다릅니다.");
			return "redirect:/error";
		}
		
		String filename = multi.getFilesystemName("uploadfile");
		String fileurl = request.getContextPath()+"/upload/dfiles/"+filename;
		long filesize = multi.getFile("uploadfile").length();
		
		DiaryDTO dto1 = new DiaryDTO();
		dto1.setTitle(title); dto1.setMid(mid); dto1.setContent(content);
		
		DiaryFileDTO dto2 = new DiaryFileDTO();
		dto2.setFilename(filename); dto2.setFileurl(fileurl); dto2.setFilesize(filesize);
		
		boolean result = diaryService.addDiary(dto1, dto2);
		if(result) {
			return "redirect:/diary/list";
		}
		return "diaryAdd";
	}
	
	@RequestMapping(value="/diary/update", method=RequestMethod.GET)
	public String getDiaryUpdate(int dno, HttpSession session, Model model) {
		System.out.println("getDiaryUpdate()");
		
		AccountDTO account = (AccountDTO) session.getAttribute("account");
		if(account.getMid() <= 0) {
			System.out.println("유효하지 않은 세션입니다.");
			return "redirect:/login";
		}
		
		DiaryDTO data = diaryService.getDiary(dno);		
		if(data.getMid() != account.getMid()) {
			System.out.println("해당 글을 수정할 권한이 없습니다.");
			model.addAttribute("error", "해당 글을 수정할 권한이 없습니다.");
			return "redirect:/error";
		}
		
		DiaryFileDTO upload = diaryService.getDiaryFile(dno);
		
		model.addAttribute("data", data);
		model.addAttribute("upload", upload);
		return "diaryUpdate";
	}
	
	@RequestMapping(value="/diary/update", method=RequestMethod.POST)
	public String postDiaryUpdate(HttpServletRequest request
			, HttpSession session, Model model) throws IOException {
		System.out.println("postDiaryUpdate()");
		
		AccountDTO account = (AccountDTO) session.getAttribute("account");
		if(account.getMid() <= 0) {
			System.out.println("유효하지 않은 세션입니다.");
			return "redirect:/login";
		}
		
		MultipartRequest multi = new MultipartRequest(
				request, 
				request.getServletContext().getRealPath("/upload/dfiles"), 
				1024*1024*10,
				"utf-8",
				new DefaultFileRenamePolicy());
		
		int dno = Integer.parseInt(multi.getParameter("dno"));
		String title = multi.getParameter("title");
		int mid = Integer.parseInt(multi.getParameter("mid"));
		String content = multi.getParameter("content");
		
		DiaryDTO diaryDTO = new DiaryDTO();
		diaryDTO.setMid(mid);
		if(account.getMid() != diaryDTO.getMid()) {
			System.out.println("account.getMid(): "+account.getMid());
			System.out.println("diaryDTO.getMid(): "+diaryDTO.getMid());
			System.out.println("전달된 값과 세션에 저장된 값이 다릅니다.");
			diaryDTO.setMid(account.getMid());
			model.addAttribute("error", "전달된 값과 세션에 저장된 값이 다릅니다.");
			return "redirect:/error";
		}
		
		String filename = multi.getFilesystemName("uploadfile");
		String fileurl = request.getContextPath()+"/upload/dfiles/"+filename;
		long filesize = multi.getFile("uploadfile").length();
		
		DiaryDTO dto1 = new DiaryDTO();
		dto1.setDno(dno); dto1.setTitle(title); dto1.setMid(mid); dto1.setContent(content);
		
		DiaryFileDTO dto2 = new DiaryFileDTO();
		dto2.setFilename(filename); dto2.setFileurl(fileurl); dto2.setFilesize(filesize);
		
		boolean result = diaryService.updateDiary(dto1, dto2);
		if(result) {
			return "redirect:/diary/detail?dno="+dno;
		}
		return "boardUpdate";
	}
	
	@RequestMapping(value="/diary/delete", method=RequestMethod.POST)
	public String postDiaryDelete(int dno, HttpSession session, Model model) {
		System.out.println("일기 삭제 요청 POST");
		
		AccountDTO account = (AccountDTO) session.getAttribute("account");
		if(account.getMid() <= 0) {
			System.out.println("유효하지 않은 세션입니다.");
			return "redirect:/login";
		}
		
		DiaryDTO data = diaryService.getDiary(dno);
		if(account.getMid() != data.getMid()) {
			System.out.println("해당 글을 삭제할 권한이 없습니다.");
			model.addAttribute("error", "해당 글을 삭제할 권한이 없습니다.");
			return "redirect:/error";
		}
		
		boolean result = diaryService.removeDiary(dno);
		if(result) {
			System.out.println(dno+"번 글 삭제 성공!!");
			return "redirect:/diary/list";
		}
		System.out.println(dno+"번 글 삭제 실패ㅜㅠ");
		return "redirect:/diary/detail?dno="+dno;
	}
	
	@RequestMapping(value="/diary/detail", method=RequestMethod.GET)
	public String getDiaryDetail(int dno, Model model) {
		System.out.println("getDiaryDetail()");
		
		DiaryDTO data = diaryService.getDiary(dno);
		DiaryFileDTO upload = diaryService.getDiaryFile(data.getDno());
		List<CommentDTO> comments = diaryService.getComments(dno);
		
		model.addAttribute("data", data);
		model.addAttribute("upload", upload);
		model.addAttribute("comments", comments);
		return "diaryDetail";
	}
	
	@RequestMapping(value="/diary/gcnt", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	@ResponseBody
	public String postDiaryGcnt(int dno, HttpSession session) {
		JSONObject json = new JSONObject();
		
		if(session.getAttribute("diary-good-"+dno) == null) {
			int gcnt = diaryService.incGoodCount(dno);
			json.put("state", "success");
			json.put("gcnt", gcnt);
		} else {
			json.put("state", "fail");
			json.put("msg", "추천은 한 번만 가능합니다.");
		}
		
		session.setAttribute("diary-good-"+dno, true);
		
		return json.toJSONString();
	}
	
	@RequestMapping(value="/diary/comment/add", method=RequestMethod.POST)
	public String postCommentAdd(int dno, int mid, String content
			, HttpSession session, Model model) {
		System.out.println("특정 일기의 댓글 등록  POST");
		
		AccountDTO account = (AccountDTO) session.getAttribute("account");
		if(account.getMid() <= 0) {
			System.out.println("유효하지 않은 세션입니다.");
			return "redirect:/login";
		}
		if(mid != account.getMid()) {
			System.out.println("사용자 정보가 일치하지 않습니다.");
			model.addAttribute("error", "사용자 정보가 일치하지 않습니다.");
			return "redirect:/error";
		}
		
		boolean result = diaryService.addComment(dno, mid, content);
		return "redirect:/diary/detail?dno="+dno;
	}
	
	@RequestMapping(value="/diary/comment/delete", method=RequestMethod.POST)
	public String postCommentDelete(int dno, int dcid, int mid
			, HttpSession session, Model model) {
		System.out.println("특정 일기의 댓글 삭제  POST");
		
		AccountDTO account= (AccountDTO) session.getAttribute("account");
		if(account.getMid() <= 0) {
			System.out.println("유효하지 않은 세션입니다.");
			return "redirect:/login";
		}
		if(mid != account.getMid()) {
			System.out.println("사용자 정보가 일치하지 않습니다.");
			model.addAttribute("error", "사용자 정보가 일치하지 않습니다.");
			return "redirect:/error";
		}
		
		boolean result = diaryService.removeComment(dno, dcid);
		return "redirect:/diary/detail?dno="+dno;
	}
	
	@RequestMapping(value="/pet/add", method=RequestMethod.GET)
	public String getPetAdd(HttpSession session, Model model) {
		System.out.println("펫 등록 요청 GET");
		
		AccountDTO account = (AccountDTO) session.getAttribute("account");
		if(account.getMid() <= 0) {
			System.out.println("유효하지 않은 세션입니다.");
			return "redirect:/login";
		}
		
		return "petAdd";
	}
	
	@RequestMapping(value="/pet/add", method=RequestMethod.POST)
	public String postPetAdd(HttpSession session, Model model
			, HttpServletRequest request) throws IOException {
		System.out.println("펫 등록 요청 POST");
		
		AccountDTO account = (AccountDTO) session.getAttribute("account");
		if(account.getMid() <= 0) {
			System.out.println("유효하지 않은 세션입니다.");
			return "redirect:/login";
		}
		
		MultipartRequest multi = new MultipartRequest(
				request, 
				request.getServletContext().getRealPath("/upload/pfiles"),
				1024*1024*10,
				"utf-8",
				new DefaultFileRenamePolicy()); 
		
		int mid = Integer.parseInt(multi.getParameter("mid"));
		String petname = multi.getParameter("petname");
		int sid = Integer.parseInt(multi.getParameter("sid"));
		char sex = multi.getParameter("sex").charAt(0);
		int age = Integer.parseInt(multi.getParameter("age"));
		Date birthday = Date.valueOf(multi.getParameter("birthday"));
		
		PetDTO petDTO = new PetDTO();
		petDTO.setMid(mid);
		if(account.getMid() != petDTO.getMid()) {
			System.out.println("account.getMid(): "+account.getMid());
			System.out.println("petDTO.getMid(): "+petDTO.getMid());
			petDTO.setMid(account.getMid());
			System.out.println("전달된 값과 세션에 저장된 값이 다릅니다.");
			model.addAttribute("error", "전달된 값과 세션에 저장된 값이 다릅니다.");
			return "redirect:/error";
		}
		
		String filename = multi.getFilesystemName("uploadfile");
		String fileurl = request.getContextPath() + "/upload/pfiles/" + filename;
		long filesize = multi.getFile("uploadfile").length();
		
		PetDTO dto1 = new PetDTO();
		dto1.setMid(mid); dto1.setPetname(petname); dto1.setSid(sid);
		dto1.setSex(sex); dto1.setBirthday(birthday); dto1.setAge(age);
		
		PetFileDTO dto2 = new PetFileDTO();
		dto2.setFilename(filename); dto2.setFileurl(fileurl); dto2.setFilesize(filesize);
		
		boolean result = petService.addPet(dto1, dto2);
		if(result) {
			return "redirect:/diary/list";
		}
		return "petAdd";
		
	}
	
	@RequestMapping(value="/pet/delete", method=RequestMethod.POST)
	public String postPetDelete(int pno, HttpSession session, Model model) {
		System.out.println("펫 정보 삭제 요청 POST");
		
		AccountDTO account = (AccountDTO) session.getAttribute("account");
		if(account.getMid() <= 0) {
			System.out.println("유효하지 않은 세션입니다.");
			return "redirect:/login";
		}
		
		boolean result = petService.removePet(pno);
		if(result) {
			System.out.println(pno+"번 펫 정보 삭제 성공!!");
		}
		System.out.println(pno+"번 펫 정보 삭제 실패!!");
		return "redirect:/diary/list";
	}
	
}
