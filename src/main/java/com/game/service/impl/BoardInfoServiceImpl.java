package com.game.service.impl;

import java.util.List;
import java.util.Map;

import com.game.deo.BoardInfoDAO;
import com.game.deo.impl.BoardInfoDAOImpl;
import com.game.service.BoardInfoService;

public class BoardInfoServiceImpl implements BoardInfoService{
	private BoardInfoDAO biDAO = new BoardInfoDAOImpl();
	
	public List<Map<String, String>> selectBoardInfoList(Map<String, String> board) {
		return biDAO.selectBoardInfoList(board);
	}
	
	public Map<String, String> selectBoardInfo(String biNum) {
		return biDAO.selectBoardInfo(biNum);
	}
	
	public int insertBoardInfo(Map<String, String> board) {
		return biDAO.insertBoardInfo(board);
	}
	
	public int updateBoardInfo(Map<String, String> board) {
		return biDAO.updateBoardInfo(board);
	}
	
	public int deleteBoardInfo(String biNum) {
		return biDAO.deleteBoardInfo(biNum);
	}
}
