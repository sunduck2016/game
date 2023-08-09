package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

//@WebServlet("/list/*")
@WebServlet("/list2/*")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private static final List<Map<String,String>> MOCK_LIST;
	static {
		MOCK_LIST = new ArrayList<>();
		for(int i=1;i<4;i++) {
			Map<String,String> map = new HashMap<>();
			map.put("number", i+"");
			map.put("name","이름"+i);
			map.put("age",i+"살");
			map.put("address","일산");
			MOCK_LIST.add(map);
		}
	}
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = "";
		json = gson.toJson(MOCK_LIST);
    	//response.setContentType("text/html;charset=UTF-8");
    	response.setContentType("application/json;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	List<String> jsonList = new ArrayList<>();
    	for(Map<String,String> map : MOCK_LIST) {
    		/*Iterator<String> it = map.keySet().iterator();
    		StringBuffer sb = new StringBuffer();
    		sb.append(")
    		while(it.hasNaxt()) {
    			String key = it.next();
    			sb.append("\"")
    			.append(key)
    			.append("\":")
    			.append("\"")
    			.append(map.get(key))
    			.append("\","")
    		}*/
    	}
    	out.println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
