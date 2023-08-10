package com.game.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/input/*")
public class inputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		/*String cmd = CommonView.getCmd(request);
		String json = "0";
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String desc = request.getParameter("desc");
		String trans = request.getParameter("trans");
		String job = request.getParameter("job");
		
		response.setContentType("text/html;crarset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("name : "+name);
		out.print("id : "+id);
		out.print("pwd : "+pwd);
		out.print("desc : "+desc);
		out.print("trans : "+trans);
		out.print("job : "+job);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);*/
		
		BufferedReader br = request.getReader();
		StringBuffer sb = new StringBuffer();
		String str = "";
		while((str=br.readLine())!=null) {
			sb.append(str);
		}
		System.out.println(sb.toString());
		Gson gson = new Gson();
		Map<String,String> map = gson.fromJson(sb.toString(), Map.class);
		System.out.println(map);
		
		response.setContentType("text/html;crarset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("name : "+map.get("name"));
		out.print("id : "+map.get("id"));
		out.print("pwd : "+map.get("pwd"));
		out.print("desc : "+map.get("desc"));
		out.print("trans : "+map.get("trans"));
		out.print("job : "+map.get("job"));
	}

}
