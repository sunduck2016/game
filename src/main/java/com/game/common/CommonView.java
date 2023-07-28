package com.game.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonView {

	/*
	 * public static String getCmd(String uri) { int idx = uri.lastIndexOf("/")+1;
	 * 
	 * if(idx == 0 || idx == -1) { throw new RuntimeException("error"); }
	 * 
	 * 
	 * return uri.substring(idx); }
	 */
	private static final String PREFIX = "/WEB-INF/views";
	private static final String SUFFIX = ".jsp";
	
	public static void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = PREFIX + request.getRequestURI() + SUFFIX;
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	public static String getCmd(HttpServletRequest request) {

		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/") + 1;
		return uri.substring(idx);

		// return request.getRequestURI().substring(request.getRequestURI());
	}
	
	public static void forwardMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/common/message.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	/*
	 * public static void main(String[] args) { String uri = "/user-info/list";
	 * 
	 * int idx = uri.lastIndexOf("/")+1; uri = uri.substring(idx);
	 * 
	 * uri = getCmd(uri);
	 * 
	 * uri = "/user-info/insert";
	 * 
	 * idx = uri.lastIndexOf("/") + 1; uri = uri.substring(idx);
	 * 
	 * uri = getCmd(uri);
	 * 
	 * uri = "/test/view";
	 * 
	 * idx = uri.lastIndexOf("/") + 1; uri = uri.substring(idx);
	 * 
	 * uri = getCmd(uri); }
	 */

}
