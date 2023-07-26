package com.game.service.impl;

import java.util.List;
import java.util.Map;

import com.game.deo.UserInfoDAO;
import com.game.deo.impl.UserInfoDAOImpl;
import com.game.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDAO uiDAO = new UserInfoDAOImpl();
	
	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String,String> userInfo) {
		return uiDAO.selectUserInfoList(userInfo);
	}
	
	public Map<String, String> selectUserInfo(String uiNum) {
		return uiDAO.selectUserInfo(uiNum);
	}
	
	public int insertUserInfo(Map<String,String> userInfo) {
		return uiDAO.insertUserInfo(userInfo);
	}
	
	public int updateUserInfo(Map<String,String> userInfo) {
		return uiDAO.updateUserInfo(userInfo);
	}
	
	public int deleteUserInfo(String uiNum) {
		return uiDAO.deleteUserInfo(uiNum);
	}

}
