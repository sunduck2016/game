package com.game.dao.impl;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.game.common.DBCon;
//import com.game.dao.impl.UserInfoDAOImpl;
//import com.game.deo.UserInfoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;
import com.game.dao.UserInfoDAO;


public class UserInfoDAOImpl implements UserInfoDAO{
	
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {
		String sql ="SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC ,\r\n"
				+ "UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM, ACTIVE FROM USER_INFO";
		List<Map<String, String>> userList = new ArrayList<>();

		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String,String> map = new HashMap<>();
						map.put("uiNum", rs.getString("UI_NUM"));
						map.put("uiName", rs.getString("UI_NAME"));
						map.put("uiId", rs.getString("UI_ID"));
						map.put("uiPwd", rs.getString("UI_PWD"));
						map.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						map.put("uiDesc", rs.getString("UI_DESC"));
						map.put("uiBirth", rs.getString("UI_BIRTH"));
						map.put("credat", rs.getString("CREDAT"));
						map.put("cretim", rs.getString("CRETIM"));
						map.put("lmodat", rs.getString("LMODAT"));
						map.put("lmotim", rs.getString("LMOTIM"));
						map.put("active", rs.getString("ACTIVE"));
						userList.add(map);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	
//	public List<Map<String,String>> selectUserInfoList(Map<String, String> userInfo) {
//		List<Map<String,String>> userInfoList = new ArrayList<>();
//		
//		try {
//			Connection con =  DBCon.getCon();
//
//			//String sql = "SELECT * FROM USER_INFO WHERE 1=1";
////			String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC,\r\n"
////					+ "UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM, ACTIVE FROM user_info";
//			String sql = "SELECT * FROM user_info";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ResultSet  rs = ps.executeQuery();
//			while(rs.next()) {
//				Map<String,String> user = new HashMap<>();
//				user.put("uiNum", rs.getString("UI_NUM"));
//				user.put("uiName", rs.getString("UI_NAME"));
//				user.put("uiId", rs.getString("UI_ID"));
//				user.put("uiPwd", rs.getString("UI_PWD"));
//				user.put("uiImgPath", rs.getString("UI_IMG_PATH"));
//				user.put("uiDesc", rs.getString("UI_DESC"));
//				user.put("uiBirth", rs.getString("UI_BIRTH"));
//				user.put("credat", rs.getString("CREDAT"));
//				user.put("cretim", rs.getString("CRETIM"));
//				user.put("lmodat", rs.getString("LMODAT"));
//				user.put("lmotim", rs.getString("LMOTIM"));
//				user.put("active", rs.getString("ACTIVE"));
//				userInfoList.add(user);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return userInfoList;
		
	}

	public Map<String,String> selectUserInfo(String uiNum) {

		String sql ="SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC ,\r\n"
				+ "DATE_FORMAT(UI_BIRTH,'%Y-%m-%d') UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM, ACTIVE FROM USER_INFO WHERE UI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, uiNum);
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String,String> map = new HashMap<>();
						map.put("uiNum", rs.getString("UI_NUM"));
						map.put("uiName", rs.getString("UI_NAME"));
						map.put("uiId", rs.getString("UI_ID"));
						map.put("uiPwd", rs.getString("UI_PWD"));
						map.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						map.put("uiDesc", rs.getString("UI_DESC"));
						map.put("uiBirth", rs.getString("UI_BIRTH"));
						map.put("credat", rs.getString("CREDAT"));
						map.put("cretim", rs.getString("CRETIM"));
						map.put("lmodat", rs.getString("LMODAT"));
						map.put("lmotim", rs.getString("LMOTIM"));
						map.put("active", rs.getString("ACTIVE"));
						return map;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
//		String sql = "SELECT * FROM user_info WHERE 1=1 AND UI_NUM=?";
//		try 
//			(Connection con = DBCon.getCon()){
//			try(PreparedStatement ps = con.prepareStatement(sql)){
//			//String sql = "SELECT * FROM USER_INFO WHERE 1=1 AND UI_NUM=?";
//			/*
//			 * String sql =
//			 * "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC,\r\n" +
//			 * "UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM, ACTIVE FROM user_info" +
//			 * "WHERE 1=1 AND UI_NUM=?";
//			 */
//				ps.setString(1,uiNum);
//			try(
//			ResultSet  rs = ps.executeQuery()){
//			while(rs.next()) {
//				Map<String,String> userInfo = new HashMap<>();
//				userInfo.put("uiNum", rs.getString("UI_NUM"));
//				userInfo.put("uiName", rs.getString("UI_NAME"));
//				userInfo.put("uiId", rs.getString("UI_ID"));
//				userInfo.put("uiPwd", rs.getString("UI_PWD"));
//				userInfo.put("uiImgPath", rs.getString("UI_IMG_PATH"));
//				userInfo.put("uiDesc", rs.getString("UI_DESC"));
//				userInfo.put("uiBirth", rs.getString("UI_BIRTH"));
//				userInfo.put("credat", rs.getString("CREDAT"));
//				userInfo.put("cretim", rs.getString("CRETIM"));
//				userInfo.put("lmodat", rs.getString("LMODAT"));
//				userInfo.put("lmotim", rs.getString("LMOTIM"));
//				userInfo.put("active", rs.getString("ACTIVE"));
//				return userInfo;
//			}}}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
	}
	
	public int insertUserInfo(Map<String,String> userInfo) {
		
		String sql = "INSERT INTO USER_INFO(\r\n"
				+ "UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, \r\n"
				+ "UI_DESC, UI_BIRTH, CREDAT, CRETIM, \r\n"
				+ "LMODAT, LMOTIM)\r\n"
				+ "VALUES(\r\n"
				+ "?, ?,?,?,\r\n"
				+ "?,?,DATE_FORMAT(NOW(),'%Y%m%d'), DATE_FORMAT(NOW(),'%H%i%s'),\r\n"
				+ "DATE_FORMAT(NOW(),'%Y%m%d'), DATE_FORMAT(NOW(),'%H%i%s'))";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, userInfo.get("uiName"));
				ps.setString(2, userInfo.get("uiId"));
				ps.setString(3, userInfo.get("uiPwd"));
				ps.setString(4, userInfo.get("uiImgPath"));
				ps.setString(5, userInfo.get("uiDesc"));
				ps.setString(6, userInfo.get("uiBirth"));
				return ps.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
		
////		String sql = "INSERT INTO USER_INFO(UI_ID, UI_PWD, UI_NAME)";
////		sql += " VALUES(?,?,?)";
////		String sql = "INSERT INTO user_info(UI_ID, UI_NAME, UI_PWD, UI_IMG_PATH, UI_DESC,\r\n"
////				+ "UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM)\r\n"
////				+ "VALUES(\r\n"
////				+ "?, ?, ?,?,?,?,DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'),DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'));\r\n";
////		String sql = "INSERT INTO user_info(UI_NAME, UI_PWD, UI_DESC, UI_BIRTH, UI_DESC,\r\n"
////				+ "UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM)\r\n"
////				+ "VALUES(\r\n"
////				+ "?, ?, ?,?,?,?,DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'),DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'));\r\n";
//		String sql = "INSERT INTO user_info(UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC, UI_BIRTH,\r\n"
//				+ "CREDAT, CRETIM, LMODAT, LMOTIM)\r\n"
//				+ "VALUES(\r\n"
//				+ "'홍길동', 'Changseop', 'Kim',NULL,'동에번쩍서에번쩍','20001022',"
//				+ "DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'),"
//				+ "DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'))";
//		String sql2 = "INSERT INTO user_info(UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC, UI_BIRTH,\r\n"
//				+ "CREDAT, CRETIM, LMODAT, LMOTIM)\r\n"
//				+ "VALUES(\r\n"
//				+ "'홍길동', 'Changseop', 'Kim',NULL,'동에번쩍서에번쩍','20001022',"
//				+ "DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'),"
//				+ "DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(), '%H%i%s'))";
//		Connection con = DBCon.getCon();
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, userInfo.get("uiId"));
//			ps.setString(2, userInfo.get("uiName"));
//			ps.setString(3, userInfo.get("uiPwd"));
//			ps.setString(4, userInfo.get("uiImgpath"));
//			ps.setString(5, userInfo.get("uidesc"));
//			ps.setString(6, userInfo.get("uibirth"));
////			ps.setString(1, userInfo.get("uiName"));
////			ps.setString(2, userInfo.get("uiPwd"));
////			ps.setString(3, userInfo.get("uiDesc"));
////			ps.setString(4, userInfo.get("uiBirth"));
////			ps.setString(5, userInfo.get("lmodat"));
////			ps.setString(6, userInfo.get("lmotim"));
//			return ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return 0;
	}
	
	public int updateUserInfo(Map<String,String> userInfo) {
		String sql = "UPDATE USER_INFO\r\n"
				+ "SET UI_NAME=?,\r\n"
				+ "UI_PWD=?,\r\n"
				+ "UI_IMG_PATH=?,\r\n"
				+ "UI_DESC=?,\r\n"
				+ "UI_BIRTH=?,\r\n"
				+ "LMODAT=DATE_FORMAT(NOW(),'%Y%m%d'),\r\n"
				+ "LMOTIM=DATE_FORMAT(NOW(),'%H%i%s')\r\n"
				+ "WHERE UI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, userInfo.get("uiName"));
				ps.setString(2, userInfo.get("uiPwd"));
				ps.setString(3, userInfo.get("uiImgPath"));
				ps.setString(4, userInfo.get("uiDesc"));
				ps.setString(5, userInfo.get("uiBirth"));
				ps.setString(6, userInfo.get("uiNum"));
				return ps.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
////		String sql = "UPDATE user_info \r\n"
////				+ "SET UI_Name = ?,\r\n"
////				+ "#UI_PWD = ?,\r\n"
////				+ "UI_Desc = ?, \r\n"
////				+ "UI_Birth = ?,\r\n"
////				+ "LMODAT = ?,\r\n"
////				+ "LMOTIM = ?\r\n"
////				+ "WHERE UI_NUM = ?";
//		String sql = "UPDATE user_info \r\n"
//				+ "SET UI_Name = ?,\r\n"
//				+ "#UI_PWD = ?,\r\n"
//				+ "UI_Desc = ?, \r\n"
//				+ "UI_Birth = ?,\r\n"
//				+ "LMODAT = DATE_FORMAT(NOW(), '%Y%m%d'),LMOTIM = DATE_FORMAT(NOW(), '%H%i%s')\r\n"
//				+ "WHERE UI_NUM = ?";
//		try(Connection con = DBCon.getCon()){
//		try (
//			PreparedStatement ps = con.prepareStatement(sql)){
//			ps.setString(1, userInfo.get("uiName"));
//			try(ResultSet rs = ps.executeQuery()){
//				while(rs.next()) {
//				Map<String, String> map = new HashMap<>();
//				map.put("uiNum",  rs.getString("UI_NUM"));
//				map.put("uiNum",  rs.getString("UI_NUM"));
//				map.put("uiNum",  rs.getString("UI_NUM"));
//				map.put("uiNum",  rs.getString("UI_NUM"));
//				map.put("uiNum",  rs.getString("UI_NUM"));
//				map.put("uiNum",  rs.getString("UI_NUM"));
//				map.put("uiNum",  rs.getString("UI_NUM"));
//				map.put("uiNum",  rs.getString("UI_NUM"));
//				map.put("uiNum",  rs.getString("UI_NUM"));
//				map.put("uiNum",  rs.getString("UI_NUM"));
////				ps.setString(1, userInfo.get("uiPwd"));
////				ps.setString(2, userInfo.get("uiPwd"));
////				ps.setString(3, userInfo.get("uiDesc"));
////				ps.setString(4, userInfo.get("uiBirth"));
////				ps.setString(5, userInfo.get("uiNum"));
//				return map;
//	//			ps.setString(5, userInfo.get("lmodat"));
//	//			ps.setString(6, userInfo.get("lmotim"));
//	//			ps.setString(7, userInfo.get("uiNum"));
//	//			return ps.executeUpdate();
//		}}} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return 0;
	}
	
	
	public int deleteUserInfo(String uiNum) {
		String sql = "DELETE FROM USER_INFO WHERE UI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1,uiNum);
				return ps.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
//		String sql = "DELETE FROM user_info\r\n"
//				+ "WHERE UI_NUM = ?";
//		Connection con = DBCon.getCon();
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, uiNum);
//			return ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return 0;
	}
	
	public static void main(String[] args) {
		UserInfoDAO uiDAO = new UserInfoDAOImpl();
		Map<String,String> map = new HashMap<>();
		map.put("uiName", "test");
		map.put("uiId", "test");
		map.put("uiPwd", "test");
		map.put("uiDesc", "test");
		map.put("uiBirth", "20100510");
		List<Map<String,String>> userInfoList = uiDAO.selectUserInfoList(null);
		for(Map<String,String> userInfo : userInfoList) {
			System.out.println(userInfo);
		}
		Map<String,String> userInfo = uiDAO.selectUserInfo("1");
		System.out.println(userInfo);
		userInfo.put("uiName", "updateTest");
		int result = uiDAO.updateUserInfo(userInfo);
		System.out.println(result);
		userInfo = uiDAO.selectUserInfo("1");
		System.out.println(userInfo);
		result = uiDAO.deleteUserInfo("1");
		System.out.println(result);
//		UserInfoDAOImpl uiRepo = new UserInfoDAOImpl();
//		System.out.println(uiRepo.selectUserInfoList(null));
//		System.out.println(uiRepo.selectUserInfo("1"));
	}

	@Override
	public Map<String, String> selectUserInfoById(String uiId) {
		String sql ="SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, UI_DESC ,\r\n"
				+ "DATE_FORMAT(UI_BIRTH,'%Y-%m-%d') UI_BIRTH, CREDAT, CRETIM, LMODAT, LMOTIM, ACTIVE FROM USER_INFO WHERE UI_ID=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, uiId);
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String,String> map = new HashMap<>();
						map.put("uiNum", rs.getString("UI_NUM"));
						map.put("uiName", rs.getString("UI_NAME"));
						map.put("uiId", rs.getString("UI_ID"));
						map.put("uiPwd", rs.getString("UI_PWD"));
						map.put("uiImgPath", rs.getString("UI_IMG_PATH"));
						map.put("uiDesc", rs.getString("UI_DESC"));
						map.put("uiBirth", rs.getString("UI_BIRTH"));
						map.put("credat", rs.getString("CREDAT"));
						map.put("cretim", rs.getString("CRETIM"));
						map.put("lmodat", rs.getString("LMODAT"));
						map.put("lmotim", rs.getString("LMOTIM"));
						map.put("active", rs.getString("ACTIVE"));
						return map;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
