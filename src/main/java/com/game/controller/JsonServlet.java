package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.common.CommonView;
import com.game.service.BoardInfoService;
import com.game.service.impl.BoardInfoServiceImpl;
import com.game.vo.BoardInfoVO;
import com.google.gson.Gson;

@WebServlet("/json/*")
public class JsonServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private BoardInfoService biService = new BoardInfoServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		String searchType = request.getParameter("searchType");
		String searchStr = request.getParameter("searchStr");
		System.out.println("searchType : "+searchType);
		System.out.println("searchStr : "+searchStr);
		BoardInfoVO board = new BoardInfoVO();
		board.setSearchStr(searchStr);
		board.setSearchType(searchType);
		String json = gson.toJson(biService.selectBoardInfoList(board));
		*/
		/*
		 * Map<String,String> map = new HashMap<>();
		map.put("name", "hong");
		map.put("age", "20");*/
		//String json = map.toString();
		/*BoardInfoVO  biVo= new BoardInfoVO();
		biVo.setBiNum(1);
		biVo.setBiTitle("this is JSON test");
		biVo.setCredat("2023-08-07");*/
		/*List<String> strList = new ArrayList<>();
		strList.add("01");
		strList.add("02");
		strList.add("03");
		strList.add("04");
		biVo.setStrList(strList);*/
		/*List<BoardInfoVO> biList = new ArrayList<>();
		/biList.add(biVo);
		biList.add(biVo);*/
		//List<Map<String,String>> biList = biService.selectBoardInfoList(null);
		//List<BoardInfoVO> biList = biService.selectBoardInfoList(null);
		//String json = gson.toJson(biList);
		//String json = gson.toJson(biService.selectBoardInfoList(null));
		//response.setHeader("Access-Control-Allow-Headers", "Content-Type");
	    //response.setHeader("Access-Control-Allow-Origin", "*");
		String json = "";
		String cmd = CommonView.getCmd(request);
		if("list".equals(cmd)) {
			BoardInfoVO board = new BoardInfoVO();
			board.setSearchStr(request.getParameter("searchType"));
			board.setSearchType(request.getParameter("searchStr"));
			json = gson.toJson(biService.selectBoardInfoList(board));
		}else if("one".equals(cmd)) {
			String biNum = request.getParameter("biNum");
			json = gson.toJson(biService.selectBoardInfo(biNum));
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(json);
		
		/*
		String json = "{\"name\":\"hong\",\"age\":20}";
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println(json);
		out.print(json+"<br>");
		json = "{name:hong,age:20}";
		out.print(json);
		*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	public static void main(String[] args) throws ServletException, IOException {
		JsonServlet js = new JsonServlet();
		/*BoardInfoVO  biVo= new BoardInfoVO();
		biVo.setBiNum(1);
		biVo.setBiTitle("this is JSON test");
		biVo.setCredat("2023-08-07");
		String json = gson.toJson(biVo);
		System.out.println(json);*/
		js.doGet(null, null);
	}
}
