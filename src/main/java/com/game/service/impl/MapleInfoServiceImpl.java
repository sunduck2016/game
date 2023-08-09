package com.game.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybatisSqlSessionFactory;
import com.game.dao.MapleInfoDAO;
import com.game.dao.impl.MapleInfoDAOImpl;
import com.game.mapper.MapleInfoMapper;
import com.game.service.MapleInfoService;
import com.game.vo.MapleInfoVO;

public class MapleInfoServiceImpl implements MapleInfoService{
	private MapleInfoDAO miDAO = new MapleInfoDAOImpl();
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
	
	//public List<Map<String, String>> selectMapleInfoList(Map<String, String> Maple) {
	public List<MapleInfoVO> selectMapleInfoList(MapleInfoVO Maple) {
		try(SqlSession session = ssf.openSession()){
			MapleInfoMapper miMapper = session.getMapper(MapleInfoMapper.class);
			return miMapper.selectmapleInfoList(Maple);
		}catch(Exception e) {
			throw e;
		}
		//return miDAO.selectMapleInfoList(Maple);
	}
	/*
	public Map<String, String> selectMapleInfo(String miNum) {
		return miDAO.selectMapleInfo(miNum);
	}
	*/
	public MapleInfoVO selectMapleInfo(String miNum) {
		try(SqlSession session = ssf.openSession()){
			MapleInfoMapper miMapper = session.getMapper(MapleInfoMapper.class);
			return miMapper.selectmapleInfo(miNum);
		}catch(Exception e) {
			throw e;
		}
	}
	public int insertMapleInfo(Map<String, String> Maple) {
		return miDAO.insertMapleInfo(Maple);
	}
	
	public int updateMapleInfo(Map<String, String> Maple) {
		return miDAO.updateMapleInfo(Maple);
	}
	
	public int deleteMapleInfo(String miNum) {
		return miDAO.deleteMapleInfo(miNum);
	}
}
