package com.game.deo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;
import com.game.deo.BoardInfoDAO;

public class BoardInfoDAOImpl implements BoardInfoDAO {
	
	public List<Map<String, String>> selectBoardInfoList(Map<String,String> board) {
		List<Map<String, String>> list = new ArrayList<>();
		String sql = "SELECT * FROM BOARD_INFO";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
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
		String sql = "INSERT INFO BOARD_INFO(\r\n"
				+ "BI_TITLE, BI_CONTENT, UI_NUM, CREDAT, \r\n"
				+ "CRETIM, LMODAT, LMOTIM\r\n"
				+ ")\r\n"
				+ "VALUES(\r\n"
				+ "?,?,?, DATE_FORMAT(NOW(),'%Y%m%d'),\r\n"
				+ "DATE_FORMAT(NOW(),'%H%i%s'), DATE_FORMAT(NOW(),'%Y%m%d'),DATE_FORMAT(NOW(),'%H%i%s')\r\n"
				+ ")";
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
		String sql = "UPDATE INFO BOARD_INFO\r\n"
				+ "SET BI_TITLE=?, \r\n"
				+ "BI_CONENT=?, \r\n"
				+ "UI_NUM=?, \r\n"
				+ "LMODAT=DATE_FORMAT(NOW(),'%Y%m%d'),\r\n"
				+ "LMOTIM=DATE_FORMAT(NOW(),'%Y%m%d'),\r\n"
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
