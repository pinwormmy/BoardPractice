package com.board.practice.DAO;

import java.util.List;

import com.board.practice.DTO.BoardDTO;

public interface BoardDAO {
	
	List<BoardDTO> postList() throws Exception;
	
	void writePost(BoardDTO boardDTO) throws Exception;
	
	BoardDTO readPost(int postNum) throws Exception;

}
