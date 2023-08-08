package com.game.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/views/*")
public class ViewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PREFIX = "/WEB-INF";
	private static final String SUFFIX = ".jsp";
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = PREFIX + request.getRequestURI() + SUFFIX;
		//PrintWriter out = response.getWriter();
		//out.print(uri);
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request,response);
		//request.getRequestDispatcher(PREFIX + request.getRequestURI() + SUFFIX).forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/*
	public static void main(String[] args) {
		long sTime = System.currentTimeMillis();
		String str = "";
		for(int i=1;i<100000;i++) {
			str += i;
		}
		long eTime = System.currentTimeMillis() - sTime;
		System.out.println();
	}
	 */
}
