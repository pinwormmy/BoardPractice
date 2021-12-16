package com.board.practice.DAO;

import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;

import com.board.practice.DTO.BoardDTO;

public interface BoardDAO {
	
	List<BoardDTO> postList() throws Exception;
	
	void writePost(BoardDTO boardDTO) throws Exception;
	
	BoardDTO readPost(int postNum) throws Exception;
	
	void deletePost(int postNum) throws Exception;
	
	void modifyPost(BoardDTO boardDTO) throws Exception;
	
	List<BoardDTO> searchPostList(String searchOption, String searchKeyword) throws Exception;

}
