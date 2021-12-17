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
		
		int pageList;
		int pageLimit;
		int pageNum;
		int pageStartNum;
		int pageEndNum;
		
		int postListLimit = 25;
		int postTotalNum = postList.size();
		int lastPageNum = (int)Math.ceil((double)postTotalNum / postListLimit);
		
		model.addAttribute("lastPageNum", lastPageNum);
		
		
		return "home";
	}
	
}
