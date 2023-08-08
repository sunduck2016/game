package com.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;
import com.game.dao.BoardInfoDAO;

public class BoardInfoDAOImpl implements BoardInfoDAO {
	
	public List<Map<String, String>> selectBoardInfoList(Map<String,String> board) {
		List<Map<String, String>> list = new ArrayList<>();
		String sql = "SELECT BI.*, UI.UI_NAME FROM board_info BI\r\n"
				+ "INNER JOIN user_info UI\r\n"
				+ "ON BI.UI_NUM = UI.UI_NUM WHERE 1=1";
		if(board!=null) {
			//sql += " AND " + board.get("key") + " LIKE CONCAT('%',?,'%')";
			
			String key = board.get("key");
			if("1".equals(key)) {
				sql += " AND BI_TITLE LIKE CONCAT('%',?,'%')";
			} else if("2".equals(key)) {
				sql += " AND UI_NAME LIKE CONCAT('%',?,'%')";
			} else if("3".equals(key)) {
				sql += " AND BI_CONTENT LIKE CONCAT('%',?,'%')";
			} else if("4".equals(key)) {
				sql += " AND (BI_TITLE LIKE CONCAT('%',?,'%') OR BI_CONTENT LIKE CONCAT('%',?,'%'))";
			} else if("5".equals(key)) {
				sql += " AND (UI_NAME LIKE CONCAT('%',?,'%') OR BI_CONTENT LIKE CONCAT('%',?,'%'))";
			} else if("6".equals(key)) {
				sql += " AND (BI_TITLE LIKE CONCAT('%',?,'%') OR UI_NAME LIKE CONCAT('%',?,'%'))";
			} else if("7".equals(key)) {
				sql += " AND (BI_TITLE LIKE CONCAT('%',?,'%') OR UI_NAME LIKE CONCAT('%',?,'%') OR BI_CONTENT LIKE CONCAT('%',?,'%'))";
			}
		}
		//String sql = "SELECT * FROM BOARD_INFO";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				if(board!=null) {
					String key = board.get("key");
					if("1".equals(key)) {
						ps.setString(1, board.get("value"));
					} else if("2".equals(key)) {
						ps.setString(1, board.get("value"));
					} else if("3".equals(key)) {
						ps.setString(1, board.get("value"));
					} else if("4".equals(key)) {
						ps.setString(1, board.get("value"));
						ps.setString(2, board.get("value"));
					} else if("5".equals(key)) {
						ps.setString(1, board.get("value"));
						ps.setString(2, board.get("value"));
					} else if("6".equals(key)) {
						ps.setString(1, board.get("value"));
						ps.setString(2, board.get("value"));
					} else if("7".equals(key)) {
						ps.setString(1, board.get("value"));
						ps.setString(2, board.get("value"));
						ps.setString(3, board.get("value"));
					}
				}
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String,String> bi = new HashMap<>();
						bi.put("biNum", rs.getString("BI_NUM"));
						bi.put("biTitle", rs.getString("BI_TITLE"));
						bi.put("biContent", rs.getString("BI_CONTENT"));
						bi.put("uiNum", rs.getString("UI_NUM"));
						bi.put("uiName", rs.getString("UI_NAME"));
						bi.put("credat", rs.getString("CREDAT"));
						bi.put("crdtim", rs.getString("CRETIM"));
						bi.put("lmodat", rs.getString("LMODAT"));
						bi.put("lmotim", rs.getString("LMOTIM"));
						bi.put("active", rs.getString("ACTIVE"));
						list.add(bi);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Map<String, String> selectBoardInfo(String biNum) {
		String sql = "SELECT * FROM BOARD_INFO WHERE BI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, biNum);
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						Map<String,String> bi = new HashMap<>();
						bi.put("biNum", rs.getString("BI_NUM"));
						bi.put("biTitle", rs.getString("BI_TITLE"));
						bi.put("biContent", rs.getString("BI_CONTENT"));
						bi.put("uiNum", rs.getString("UI_NUM"));
						bi.put("credat", rs.getString("CREDAT"));
						bi.put("crdtim", rs.getString("CRETIM"));
						bi.put("lmodat", rs.getString("LMODAT"));
						bi.put("lmotim", rs.getString("LMOTIM"));
						bi.put("active", rs.getString("ACTIVE"));
						return bi;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insertBoardInfo(Map<String,String> board) {
		/*
		 * String sql = "INSERT INFO BOARD_INFO(\r\n" +
		 * "BI_TITLE, BI_CONTENT, UI_NUM, CREDAT, \r\n" + "CRETIM, LMODAT, LMOTIM\r\n" +
		 * ")\r\n" + "VALUES(\r\n" + "?,?,?, DATE_FORMAT(NOW(),'%Y%m%d'),\r\n" +
		 * "DATE_FORMAT(NOW(),'%H%i%s'), DATE_FORMAT(NOW(),'%Y%m%d'),DATE_FORMAT(NOW(),'%H%i%s')\r\n"
		 * + ")";
		 */
		String sql = "INSERT INTO board_info(BI_TITLE, BI_CONTENT, UI_NUM, CREDAT, CRETIM, LMODAT, LMOTIM)\r\n"
				+ "VALUES(?, ?, ?, DATE_FORMAT(NOW(),'%Y%m%d'),\r\n"
				+ "DATE_FORMAT(NOW(), '%H%i%s'),\r\n"
				+ "DATE_FORMAT(NOW(), '%Y%m%d'),\r\n"
				+ "DATE_FORMAT(NOW(), '%H%i%s'))";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					ps.setString(1, board.get("biTitle"));
					ps.setString(2, board.get("biContent"));
					ps.setString(3, board.get("uiNum"));
					return ps.executeUpdate();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateBoardInfo(Map<String,String> board) {
		/*
		 * String sql = "UPDATE INFO BOARD_INFO\r\n" + "SET BI_TITLE=?, \r\n" +
		 * "BI_CONENT=?, \r\n" + "UI_NUM=?, \r\n" +
		 * "LMODAT=DATE_FORMAT(NOW(),'%Y%m%d'),\r\n" +
		 * "LMOTIM=DATE_FORMAT(NOW(),'%Y%m%d'),\r\n" + "WHERE BI_NUM=?";
		 */
		String sql = "UPDATE board_info\r\n"
				+ "SET BI_TITLE = ?,\r\n"
				+ "BI_CONTENT=?,\r\n"
				+ "UI_NUM=?,\r\n"
				+ "LMODAT=DATE_FORMAT(NOW(),'%Y%m%d'),\r\n"
				+ "LMOTIM=DATE_FORMAT(NOW(),'%H%i%s')\r\n"
				+ "WHERE BI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, board.get("biTitle"));
				ps.setString(2, board.get("biContent"));
				ps.setString(3, board.get("uiNum"));
				ps.setString(4, board.get("biNum"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteBoardInfo(String biNum) {
		String sql = "DELETE FROM BOARD_INFO WHERE BI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, biNum);
				return ps.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[] args) {
		BoardInfoDAO biDAO = new BoardInfoDAOImpl();
		Map<String,String> biMock = new HashMap<>();
		biMock.put("biTitle", "test");
		biMock.put("biContent", "test");
		biMock.put("uiNum", "2");
		int result = biDAO.insertBoardInfo(biMock);
		System.out.println("result : " + result);
		System.out.println(biDAO.selectBoardInfoList(null));
		System.out.println(biDAO.selectBoardInfo("3"));
	}
}
