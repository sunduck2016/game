package com.game.deo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;
import com.game.deo.UserInfoDAO;

public class UserInfoDAOImpl implements UserInfoDAO{
	
	public List<Map<String,String>> selectUserInfoList(Map<String, String> userInfo) {
		List<Map<String,String>> userInfoList = new ArrayList<>();
		
		try {
			Connection con =  DBCon.getCon();

			//String sql = "SELECT * FROM USER_INFO WHERE 1=1";
//			String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC,\r\n"
//					+ "UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM, ACTIVE FROM user_info";
			String sql = "SELECT * FROM user_info";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet  rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,String> user = new HashMap<>();
				userInfo.put("uiNum", rs.getString("UI_NUM"));
				userInfo.put("uiName", rs.getString("UI_NAME"));
				userInfo.put("uiId", rs.getString("UI_ID"));
				userInfo.put("uiPwd", rs.getString("UI_PWD"));
				userInfo.put("uiImgPath", rs.getString("UI_IMG_PATH"));
				userInfo.put("uiDesc", rs.getString("UI_DESC"));
				userInfo.put("uiBirth", rs.getString("UI_BIRTH"));
				userInfo.put("credat", rs.getString("UI_CREDAT"));
				userInfo.put("cretim", rs.getString("UI_CRETIM"));
				userInfo.put("lmodat", rs.getString("UI_LMODAT"));
				userInfo.put("lmotim", rs.getString("UI_LMOTIM"));
				userInfo.put("active", rs.getString("UI_ACTIVE"));
				userInfoList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoList;
		
	}

	public Map<String,String> selectUserInfo(String uiNum) {
		
		try {
			Connection con = DBCon.getCon();

			//String sql = "SELECT * FROM USER_INFO WHERE 1=1 AND UI_NUM=?";
			String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC,\r\n"
					+ "UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM, ACTIVE FROM user_info"
					+ "WHERE 1=1 AND UI_NUM=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,uiNum);
			ResultSet  rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,String> userInfo = new HashMap<>();
				userInfo.put("uiNum", rs.getString("UI_NUM"));
				userInfo.put("uiName", rs.getString("UI_NAME"));
				userInfo.put("uiId", rs.getString("UI_ID"));
				userInfo.put("uiPwd", rs.getString("UI_PWD"));
				userInfo.put("uiImgPath", rs.getString("UI_IMG_PATH"));
				userInfo.put("uiDesc", rs.getString("UI_DESC"));
				userInfo.put("uiBirth", rs.getString("UI_BIRTH"));
				userInfo.put("credat", rs.getString("UI_CREDAT"));
				userInfo.put("cretim", rs.getString("UI_CRETIM"));
				userInfo.put("lmodat", rs.getString("UI_LMODAT"));
				userInfo.put("lmotim", rs.getString("UI_LMOTIM"));
				userInfo.put("active", rs.getString("UI_ACTIVE"));
				return userInfo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insertUserInfo(Map<String,String> userInfo) {
//		String sql = "INSERT INTO USER_INFO(UI_ID, UI_PWD, UI_NAME)";
//		sql += " VALUES(?,?,?)";
		String sql = "INSERT INTO user_info(UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC,\r\n"
				+ "UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM)\r\n"
				+ "VALUES(\r\n"
				+ "?, ?, ?,?,?,?,DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'),DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'));\r\n";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, userInfo.get("uiName"));
//			ps.setString(2, userInfo.get("uiId"));
//			ps.setString(3, userInfo.get("uiPwd"));
//			ps.setString(4, userInfo.get("uiImgpath"));
//			ps.setString(5, userInfo.get("uidesc"));
//			ps.setString(6, userInfo.get("uibirth"));
			ps.setString(1, userInfo.get("uiName"));
			ps.setString(2, userInfo.get("uiPwd"));
			ps.setString(3, userInfo.get("uiDesc"));
			ps.setString(4, userInfo.get("uiBirth"));
			ps.setString(5, userInfo.get("lmodat"));
			ps.setString(6, userInfo.get("lmotim"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateUserInfo(Map<String,String> userInfo) {
		String sql = "UPDATE user_info \r\n"
				+ "SET UI_Name = ?,\r\n"
				+ "#UI_PWD = ?,\r\n"
				+ "UI_Desc = ?, \r\n"
				+ "UI_Birth = ?,\r\n"
				+ "LMODAT = ?,\r\n"
				+ "LMOTIM = ?\r\n"
				+ "WHERE UI_NUM = ?";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userInfo.get("uiName"));
			ps.setString(2, userInfo.get("uiPwd"));
			ps.setString(3, userInfo.get("uiDesc"));
			ps.setString(4, userInfo.get("uiBirth"));
			ps.setString(5, userInfo.get("lmodat"));
			ps.setString(6, userInfo.get("lmotim"));
			ps.setString(7, userInfo.get("uiNum"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteUserInfo(String uiNum) {
		String sql = "DELETE FROM user_info\r\n"
				+ "WHERE UI_NUM = ?";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uiNum);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		UserInfoDAOImpl uiRepo = new UserInfoDAOImpl();
		System.out.println(uiRepo.selectUserInfoList(null));
		System.out.println(uiRepo.selectUserInfo("1"));
	}

	@Override
	public List<Map<String, String>> selectuserInfoList(Map<String, String> userInfo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
