package com.game.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybatisSqlSessionFactory;
import com.game.dao.UserInfoDAO;
import com.game.dao.impl.UserInfoDAOImpl;
import com.game.mapper.UserInfoMapper;
import com.game.service.UserInfoService;
import com.game.vo.UserInfoVO;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDAO uiDAO = new UserInfoDAOImpl();
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
	
	@Override
	//public List<Map<String, String>> selectUserInfoList(Map<String,String> userInfo) {
	public List<UserInfoVO> selectUserInfoList(UserInfoVO userInfo) {
		try(SqlSession session = ssf.openSession()){
			UserInfoMapper uiMapper = session.getMapper(UserInfoMapper.class);
			return uiMapper.selectUserInfoList(userInfo);
		}//return uiDAO.selectUserInfoList(userInfo);
		catch(Exception e) {
			throw e;
		}
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
