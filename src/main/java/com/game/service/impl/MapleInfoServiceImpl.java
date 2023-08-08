package com.game.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybatisSqlSessionFactory;
import com.game.dao.BoardInfoDAO;
import com.game.dao.impl.BoardInfoDAOImpl;
import com.game.mapper.BoardInfoMapper;
import com.game.service.BoardInfoService;
import com.game.vo.BoardInfoVO;

public class MapleInfoServiceImpl implements BoardInfoService{
	private BoardInfoDAO biDAO = new BoardInfoDAOImpl();
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
	
	//public List<Map<String, String>> selectBoardInfoList(Map<String, String> board) {
	public List<BoardInfoVO> selectBoardInfoList(BoardInfoVO board) {
		try(SqlSession session = ssf.openSession()){
			BoardInfoMapper biMapper = session.getMapper(BoardInfoMapper.class);
			return biMapper.selectBoardInfoList(board);
		}catch(Exception e) {
			throw e;
		}
		//return biDAO.selectBoardInfoList(board);
	}
	/*
	public Map<String, String> selectBoardInfo(String biNum) {
		return biDAO.selectBoardInfo(biNum);
	}
	*/
	public BoardInfoVO selectBoardInfo(String biNum) {
		try(SqlSession session = ssf.openSession()){
			BoardInfoMapper biMapper = session.getMapper(BoardInfoMapper.class);
			return biMapper.selectBoardInfo(biNum);
		}catch(Exception e) {
			throw e;
		}
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
