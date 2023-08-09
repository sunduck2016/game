package com.game.mapper;

import java.util.List;

import com.game.vo.MapleInfoVO;

public interface MapleInfoMapper {
	List<MapleInfoVO> selectmapleInfoList(MapleInfoVO maple);
	MapleInfoVO selectmapleInfo(String miNum);
	int insertmapleInfo(MapleInfoVO maple);
	int updatemapleInfo(MapleInfoVO maple);
	int deletemapleInfo(MapleInfoVO maple);
}
