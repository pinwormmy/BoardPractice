package com.board.practice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.practice.DAO.BoardDAO;
import com.board.practice.DTO.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO boardDAO;	
	
	@Override
	public List<BoardDTO> postList() throws Exception {
		
		return boardDAO.postList();
	}

	@Override
	public void writePost(BoardDTO boardDTO) throws Exception {
		
		boardDAO.writePost(boardDTO);		
	}

	@Override
	public BoardDTO readPost(int postNum) throws Exception {
		
		return boardDAO.readPost(postNum);
	}

}