package com.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;
import com.game.dao.MapleInfoDAO;

public class MapleInfoDAOImpl implements MapleInfoDAO {
	
	public List<Map<String, String>> selectMapleInfoList(Map<String,String> maple) {
		List<Map<String, String>> list = new ArrayList<>();
		String sql = "SELECT mi.*, UI.UI_NAME FROM maple_info mi\r\n"
				+ "INNER JOIN user_info UI\r\n"
				+ "ON mi.UI_NUM = UI.UI_NUM WHERE 1=1";
		if(maple!=null) {
			//sql += " AND " + maple.get("key") + " LIKE CONCAT('%',?,'%')";
			
			String key = maple.get("key");
			if("1".equals(key)) {
				sql += " AND mi_TITLE LIKE CONCAT('%',?,'%')";
			} else if("2".equals(key)) {
				sql += " AND UI_NAME LIKE CONCAT('%',?,'%')";
			} else if("3".equals(key)) {
				sql += " AND mi_CONTENT LIKE CONCAT('%',?,'%')";
			} else if("4".equals(key)) {
				sql += " AND (mi_TITLE LIKE CONCAT('%',?,'%') OR mi_CONTENT LIKE CONCAT('%',?,'%'))";
			} else if("5".equals(key)) {
				sql += " AND (UI_NAME LIKE CONCAT('%',?,'%') OR mi_CONTENT LIKE CONCAT('%',?,'%'))";
			} else if("6".equals(key)) {
				sql += " AND (mi_TITLE LIKE CONCAT('%',?,'%') OR UI_NAME LIKE CONCAT('%',?,'%'))";
			} else if("7".equals(key)) {
				sql += " AND (mi_TITLE LIKE CONCAT('%',?,'%') OR UI_NAME LIKE CONCAT('%',?,'%') OR mi_CONTENT LIKE CONCAT('%',?,'%'))";
			}
		}
		//String sql = "SELECT * FROM maple_INFO";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				if(maple!=null) {
					String key = maple.get("key");
					if("1".equals(key)) {
						ps.setString(1, maple.get("value"));
					} else if("2".equals(key)) {
						ps.setString(1, maple.get("value"));
					} else if("3".equals(key)) {
						ps.setString(1, maple.get("value"));
					} else if("4".equals(key)) {
						ps.setString(1, maple.get("value"));
						ps.setString(2, maple.get("value"));
					} else if("5".equals(key)) {
						ps.setString(1, maple.get("value"));
						ps.setString(2, maple.get("value"));
					} else if("6".equals(key)) {
						ps.setString(1, maple.get("value"));
						ps.setString(2, maple.get("value"));
					} else if("7".equals(key)) {
						ps.setString(1, maple.get("value"));
						ps.setString(2, maple.get("value"));
						ps.setString(3, maple.get("value"));
					}
				}
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String,String> mi = new HashMap<>();
						mi.put("miNum", rs.getString("mi_NUM"));
						mi.put("miTitle", rs.getString("mi_TITLE"));
						mi.put("miContent", rs.getString("mi_CONTENT"));
						mi.put("uiNum", rs.getString("UI_NUM"));
						mi.put("uiName", rs.getString("UI_NAME"));
						mi.put("credat", rs.getString("CREDAT"));
						mi.put("crdtim", rs.getString("CRETIM"));
						mi.put("lmodat", rs.getString("LMODAT"));
						mi.put("lmotim", rs.getString("LMOTIM"));
						mi.put("active", rs.getString("ACTIVE"));
						list.add(mi);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Map<String, String> selectMapleInfo(String miNum) {
		String sql = "SELECT * FROM maple_INFO WHERE mi_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, miNum);
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String,String> mi = new HashMap<>();
						mi.put("miNum", rs.getString("mi_NUM"));
						mi.put("miTitle", rs.getString("mi_TITLE"));
						mi.put("miContent", rs.getString("mi_CONTENT"));
						mi.put("uiNum", rs.getString("UI_NUM"));
						mi.put("credat", rs.getString("CREDAT"));
						mi.put("crdtim", rs.getString("CRETIM"));
						mi.put("lmodat", rs.getString("LMODAT"));
						mi.put("lmotim", rs.getString("LMOTIM"));
						mi.put("active", rs.getString("ACTIVE"));
						return mi;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insertMapleInfo(Map<String,String> maple) {
		/*
		 * String sql = "INSERT INFO maple_INFO(\r\n" +
		 * "mi_TITLE, mi_CONTENT, UI_NUM, CREDAT, \r\n" + "CRETIM, LMODAT, LMOTIM\r\n" +
		 * ")\r\n" + "VALUES(\r\n" + "?,?,?, DATE_FORMAT(NOW(),'%Y%m%d'),\r\n" +
		 * "DATE_FORMAT(NOW(),'%H%i%s'), DATE_FORMAT(NOW(),'%Y%m%d'),DATE_FORMAT(NOW(),'%H%i%s')\r\n"
		 * + ")";
		 */
		String sql = "INSERT INTO maple_info(mi_TITLE, mi_CONTENT, UI_NUM, CREDAT, CRETIM, LMODAT, LMOTIM)\r\n"
				+ "VALUES(?, ?, ?, DATE_FORMAT(NOW(),'%Y%m%d'),\r\n"
				+ "DATE_FORMAT(NOW(), '%H%i%s'),\r\n"
				+ "DATE_FORMAT(NOW(), '%Y%m%d'),\r\n"
				+ "DATE_FORMAT(NOW(), '%H%i%s'))";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					ps.setString(1, maple.get("miTitle"));
					ps.setString(2, maple.get("miContent"));
					ps.setString(3, maple.get("uiNum"));
					return ps.executeUpdate();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateMapleInfo(Map<String,String> maple) {
		/*
		 * String sql = "UPDATE INFO maple_INFO\r\n" + "SET mi_TITLE=?, \r\n" +
		 * "mi_CONENT=?, \r\n" + "UI_NUM=?, \r\n" +
		 * "LMODAT=DATE_FORMAT(NOW(),'%Y%m%d'),\r\n" +
		 * "LMOTIM=DATE_FORMAT(NOW(),'%Y%m%d'),\r\n" + "WHERE mi_NUM=?";
		 */
		String sql = "UPDATE maple_info\r\n"
				+ "SET mi_TITLE = ?,\r\n"
				+ "mi_CONTENT=?,\r\n"
				+ "UI_NUM=?,\r\n"
				+ "LMODAT=DATE_FORMAT(NOW(),'%Y%m%d'),\r\n"
				+ "LMOTIM=DATE_FORMAT(NOW(),'%H%i%s')\r\n"
				+ "WHERE mi_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, maple.get("miTitle"));
				ps.setString(2, maple.get("miContent"));
				ps.setString(3, maple.get("uiNum"));
				ps.setString(4, maple.get("miNum"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteMapleInfo(String miNum) {
		String sql = "DELETE FROM maple_INFO WHERE mi_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, miNum);
				return ps.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[] args) {
		MapleInfoDAO miDAO = new MapleInfoDAOImpl();
		Map<String,String> miMock = new HashMap<>();
		miMock.put("miTitle", "test");
		miMock.put("miContent", "test");
		miMock.put("uiNum", "2");
		int result = miDAO.insertMapleInfo(miMock);
		System.out.println("result : " + result);
		System.out.println(miDAO.selectMapleInfoList(null));
		System.out.println(miDAO.selectMapleInfo("3"));
	}
}
