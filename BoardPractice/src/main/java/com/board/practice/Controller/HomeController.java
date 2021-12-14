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

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		List<BoardDTO> postList = null;
		postList = boardService.postList();

		model.addAttribute("postList", postList);
		
		return "home";
	}
	
	// 그냥 진작에 컨트롤러 분리해놓자 깔끔허게
	// 첫 커밋도 변경사항있어야 올라가나 ? 그게 아니라 인덱스 추가 한번하고 해야함.
	
	@RequestMapping(value = "/writePost")
	public String writePost() {
		
		return "writePost";
	}
	
	@RequestMapping(value = "/submitWritePost")
	public String submitWritePost(BoardDTO boardDTO) throws Exception {
		
		boardService.writePost(boardDTO);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/readPost")
	public String readPost(Model model, int postNum) throws Exception {
		
		BoardDTO readPost = null;
		readPost= boardService.readPost(postNum);
		
		model.addAttribute("readPost", readPost);
		
		return "readPost";
	}
	
	@RequestMapping(value="/deletePost")
	public String deletePost(int postNum) throws Exception{
		
		boardService.deletePost(postNum);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/modifyPost")
	public String modifyPost(Model model, int postNum) throws Exception {
		BoardDTO readPost = null;
		readPost= boardService.readPost(postNum);
		
		model.addAttribute("readPost", readPost);
		
		return "modifyPost";
	}
	
	@RequestMapping(value="/submitModifyPost")
	public String submitModifyPost(BoardDTO boardDTO) throws Exception{
				
		boardService.modifyPost(boardDTO);
		
		return "redirect:/readPost?postNum=" + boardDTO.getPostNum();
	}
}
