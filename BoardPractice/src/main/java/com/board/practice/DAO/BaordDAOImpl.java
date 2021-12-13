package com.board.practice.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.practice.DTO.BoardDTO;

@Repository
public class BaordDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	private String namespace = "board.mappers.boardMapper";

	@Override
	public List<BoardDTO> postList() throws Exception {
		
		return sqlSession.selectList(namespace + ".postList");
	}

	@Override
	public void writePost(BoardDTO boardDTO) throws Exception {
		
		sqlSession.insert(namespace + ".writePost", boardDTO);
		
	}

	@Override
	public BoardDTO readPost(int postNum) throws Exception {
		return sqlSession.selectOne(namespace + ".readPost", postNum);
	}

}
