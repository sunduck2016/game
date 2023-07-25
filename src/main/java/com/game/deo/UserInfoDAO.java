package com.game.deo;

import java.util.List;
import java.util.Map;

public interface UserInfoDAO {
	List<Map<String,String>> selectuserInfoList(Map<String, String> userInfo);
	Map<String,String> selectUserInfo(String uiNum);
	int insertUserInfo(Map<String,String> userInfo);
	int updateUserInfo(Map<String,String> userInfo);
	int deleteUserInfo(String uiNum);
}
