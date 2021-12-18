package com.board.practice.Controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.practice.DTO.BoardDTO;
import com.board.practice.Service.BoardService;


@Controller
public class HomeController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws Exception {
		
		List<BoardDTO> postList = null;
		postList = boardService.postList();

		model.addAttribute("postList", postList);
		
		int pageRecentNum = 1;
		int pageListLimit = 10;
		int pageStartNum = ((int)Math.ceil((double)pageRecentNum / pageListLimit) - 1)  * pageListLimit + 1;
		int pageLastNum = pageStartNum + (pageListLimit - 1);
		
		
		int postListLimit = 25;
		int postLastNum = pageRecentNum * postListLimit;
		int postStartNum = postLastNum - (postListLimit - 1);
		
		int postTotalNum = postList.size();
		
		int pageTotalEndNum = (int)Math.ceil((double)postTotalNum / postListLimit);
		if(pageLastNum > pageTotalEndNum)
			pageLastNum = pageTotalEndNum;
		
		
		model.addAttribute("postStartNum", postStartNum);
		model.addAttribute("postLastNum", postLastNum);
		model.addAttribute("pageRecentNum", pageRecentNum);
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("pageLastNum", pageLastNum);
		model.addAttribute("pageTotalEndNum", pageTotalEndNum);
		
		return "home";
	}
	
}
