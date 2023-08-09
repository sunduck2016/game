package com.game.service;

import java.util.List;
import java.util.Map;

import com.game.vo.MapleInfoVO;

public interface MapleInfoService {
	//List<Map<String,String>> selectMapleInfoList(Map<String,String> Maple);
	List<MapleInfoVO> selectMapleInfoList(MapleInfoVO Maple);
	//Map<String,String> selectMapleInfo(String miNum);
	MapleInfoVO selectMapleInfo(String miNum);
	int insertMapleInfo(Map<String,String> Maple);
	int updateMapleInfo(Map<String,String> Maple);
	int deleteMapleInfo(String miNum);
}
