package com.game.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.game.mapper.UserInfoMapper;
import com.game.vo.UserInfoVO;

public class MybatisSqlSessionFactory {
	
	private static SqlSessionFactory SSF;
	private final static String CONFIG_PATH = "config/mybatis-config.xml";
	static {
		try {
			InputStream is = Resources.getResourceAsStream(CONFIG_PATH);
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SSF = ssfb.build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return SSF;
	}
	
	public static void main(String[] args) {
		/*
		 SqlSessionFactory ssf = getSqlSessonFactory();
		SqlSession session = null;
		try {
			session = ssf.openSession(false);
			BoardInfoMapper biMapper = session.getMapper(BoardInfoMapper.class);
			BoardInfoVO bi = new BoardInfoVO();
			bi.setBiNum(1);
			bi.setBiTitle("mapper test");
			bi.setBiContent("hello mybatis insert");
			bi.setUiNum(1);
			int result=biMapper.insertBoardInfo(bi);
			System.out.println("insert result : "+result);
			bi=biMapper.selectBoardInfo(bi);
			bi.setBiTitle("myobatis update test");
			result=biMapper.updateBoardInfo(bi);
			System.out.println("update result : "+result);
			
			List<BoardInfoVO> list = biMapper.selectBoardInfoList(null);
			for(BoardInfoVO board:list) {
				System.out.println(board);
			}
			//BoardInfoVO board = biMapper.selectBoardInfo(bi);
			//System.out.println(board);
			//System.out.println(list);
			//session.getMapper(BoardInfoMapper.class);
		} catch(Exception e) {
			e.printStackTrace();
		}*/
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		UserInfoMapper uiMapper = session.getMapper(UserInfoMapper.class);
		List<UserInfoVO> list = uiMapper.selectUserInfoList(null);
		System.out.println(list);
	}

}
