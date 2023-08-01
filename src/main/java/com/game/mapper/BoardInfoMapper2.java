package com.game.mapper;

import java.util.List;

import com.game.vo.BoardInfoVO;

public interface BoardInfoMapper2 {
	/*
	BoardInfoVO SelectBoardInfoMapper = new BoardInfoVO();
	int InsertBoardInfoMapper(BoardInfoMapper);
	int UpdateBoardInfoMapper(BoardInfoMapper);
	int DeleteBoardInfoMapper(BoardInfoMapper);
	*/
	List<BoardInfoVO> selectBoardInfoList(BoardInfoVO board);
	BoardInfoVO selectBoardInfo(BoardInfoVO board);
	int insertBoardInfo(BoardInfoVO board);
	int updateBoardInfo(BoardInfoVO board);
	int deleteBoardInfo(BoardInfoVO board);
}
