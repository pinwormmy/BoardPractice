package com.board.practice.Service;

import java.util.List;

import com.board.practice.DTO.BoardDTO;

public interface BoardService {
	
	List<BoardDTO> postList() throws Exception;

	void writePost(BoardDTO boardDTO) throws Exception;
	
	BoardDTO readPost(int postNum) throws Exception;
	
	void deletePost(int postNum) throws Exception;
	
	void modifyPost(BoardDTO boardDTO) throws Exception;
}
