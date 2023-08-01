package com.game.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.game.dao.UserInfoDAO;
import com.game.dao.impl.UserInfoDAOImpl;
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

	@Override
	public boolean login(Map<String, String> userInfo, HttpSession session) {
		String uiId = userInfo.get("uiId");
		Map<String, String> tmp = uiDAO.selectUserInfoById(uiId);
		if(tmp!=null) {
			String uiPwd = tmp.get("uiPwd");
			if(uiPwd.equals(userInfo.get("uiPwd"))) {
				session.setAttribute("user", tmp);
				return true;
			}
		}
		return false;
	}

}
