package com.game.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.game.common.CommonView;
import com.game.service.MapleInfoService;
import com.game.service.impl.MapleInfoServiceImpl;
import com.game.vo.MapleInfoVO;

/**
 * Servlet implementation class mapleInfoServlet
 */
@WebServlet("/maple-info/*")
public class MapleInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MapleInfoService miService = new MapleInfoServiceImpl();
       
    private boolean isLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null) {
			request.setAttribute("msg",  "please log-in");
			request.setAttribute("url",  "/user-info/login");
			CommonView.forwardMessage(request, response);
			return false;
		}
		return true;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!isLogin(request,response)) {
			return;
		}
		String cmd = CommonView.getCmd(request);
		if("list".equals(cmd)) {
			Map<String,String> param = new HashMap<>();
			if(request.getParameter("searchType")!=null) {
				param = new HashMap<>();
				String key = request.getParameter("searchType");
				String value = request.getParameter("searchStr");
				param.put("key",key);
				param.put("value",value);
			}
			//List<Map<String, String>> list = miService.selectmapleInfoList(null);
			List<MapleInfoVO> list = miService.selectMapleInfoList(null);
			request.setAttribute("miList", list);
		}else if("view".equals(cmd) || "update".equals(cmd)) {
			String miNum = request.getParameter("miNum");
			MapleInfoVO maple = miService.selectMapleInfo(miNum);
			request.setAttribute("maple", maple);
		}
		CommonView.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if(!isLogin(request,response)) {
			return;
		}
		String cmd = CommonView.getCmd(request);
		HttpSession session = request.getSession();
		Map<String, String> user = (Map<String,String>)session.getAttribute("user");
		if("insert".equals(cmd)) {
			String miTitle = request.getParameter("miTitle");
			String miContent = request.getParameter("miContent");
			Map<String,String> maple = new HashMap<>();
			maple.put("miTitle",miTitle);
			maple.put("miContent", miContent);
			maple.put("uiNum", user.get("uiNum"));
			int result = miService.insertMapleInfo(maple);
			request.setAttribute("msg", "insert fail");
			request.setAttribute("url", "/maple-info/insert");
			if(result==1) {
				request.setAttribute("msg", "insert success");
				request.setAttribute("url", "/maple-info/list");
			}
		}else if("update".equals(cmd)) {
			String miNum = request.getParameter("miNum");
			String miTitle = request.getParameter("miTitle");
			String miContent = request.getParameter("miContent");
			Map<String,String> maple = new HashMap<>();
			maple.put("miNum", miNum);
			maple.put("miTitle", miTitle);
			maple.put("miConent", miContent);
			maple.put("uiNum", user.get("uiNum"));
			int result = miService.updateMapleInfo(maple);
			request.setAttribute("msg", "update fail");
			request.setAttribute("url", "/maple-info/update?miNum="+miNum);
			if(result==1) {
				request.setAttribute("msg", "update success");
				request.setAttribute("url", "/maple-info/list");
			}
		}else if("delete".equals(cmd)) {
			String miNum = request.getParameter("miNum");
			int result = miService.deleteMapleInfo(miNum);
			request.setAttribute("msg", "delete fail");
			request.setAttribute("url", "/maple-info/list");
			if(result==1) {
				request.setAttribute("msg","delete success");
				request.setAttribute("url", "/maple-info/list");
			}
		}
		CommonView.forwardMessage(request,response);
	}
	
}
