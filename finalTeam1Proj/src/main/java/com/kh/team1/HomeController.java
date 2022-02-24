package com.kh.team1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.team1.diary.model.*;

@Controller
public class HomeController {
	
	@Autowired
	DiaryService diaryService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println("main page: 일기 전체 목록 요청 get");
		
		List<DiaryDTO> datas = diaryService.getAll();
		List<DiaryFileDTO> files = diaryService.getAllFiles();
		System.out.println(datas);
		System.out.println(files);
		
		model.addAttribute("datas", datas);
		model.addAttribute("files", files);
		return "home";
	}
	
}
