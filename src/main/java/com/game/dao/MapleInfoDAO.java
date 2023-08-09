package com.game.dao;

import java.util.List;
import java.util.Map;

public interface MapleInfoDAO {
	List<Map<String,String>> selectMapleInfoList(Map<String,String> maple);
	Map<String,String> selectMapleInfo(String miNum);
	int insertMapleInfo(Map<String,String> maple);
	int updateMapleInfo(Map<String,String> maple);
	int deleteMapleInfo(String miNum);
}
