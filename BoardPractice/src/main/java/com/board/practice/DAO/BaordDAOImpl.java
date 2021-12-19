package com.board.practice.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

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

	@Override
	public void deletePost(int postNum) throws Exception {
		sqlSession.delete(namespace + ".deletePost", postNum);		
	}

	@Override
	public void modifyPost(BoardDTO boardDTO) throws Exception {
		sqlSession.update(namespace + ".modifyPost", boardDTO);		
	}

	@Override
	public List<BoardDTO> searchPostList(String searchOption, String searchKeyword) throws Exception {
		
		HashMap<String, String> searchInfo = new HashMap<String, String>();
		searchInfo.put("searchOption", searchOption);
		searchInfo.put("searchKeyword", searchKeyword);
		
		return sqlSession.selectList(namespace + ".searchPostList", searchInfo);
	}

	@Override
	public void plusViewCount(int postNum) throws Exception {
		sqlSession.update(namespace + ".plusViewCount", postNum);
		
	}

	@Override
	public void submitComment(BoardDTO boardDTO) throws Exception {
		sqlSession.insert(namespace + ".writeComment", boardDTO);
	}

	@Override
	public void deleteComment(BoardDTO boardDTO) throws Exception {
		sqlSession.delete(namespace + ".deleteComment", boardDTO);
		
	}

	@Override
	public List<BoardDTO> readComment(int postNum) throws Exception {
		
		return sqlSession.selectList(namespace + ".readComment", postNum);
	}

	@Override
	public void updateCommentCount(int postNum) throws Exception {
		
		sqlSession.update(namespace + ".updateCommentCount", postNum);
	}

}
