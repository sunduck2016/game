package com.game.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.game.common.CommonView;
import com.game.common.JSON;
import com.game.service.UserInfoService;
import com.game.service.impl.UserInfoServiceImpl;
import com.game.vo.UserInfoVO;
import com.google.gson.Gson;

@WebServlet("/user-info/*")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService uiService = new UserInfoServiceImpl();
	private Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		// String path = "/WEB-INF/views";
		String json = "";
		if ("list".equals(cmd)) {
			// path += "/game/user-info/list";
			/*
			 * List<Map<String, String>> userInfoList = uiService.selectUserInfoList(null);
			 * request.setAttribute("userInfoList", userInfoList);
			 */
			json = gson.toJson(uiService.selectUserInfoList(null));
		} else if ("view".equals(cmd) || "update".equals(cmd)) {
			/*
			 * String uiNum = request.getParameter("uiNum"); Map<String, String> userInfo =
			 * uiService.selectUserInfo(uiNum); request.setAttribute("userInfo", userInfo);
			 */
		} /*
			 * else if("view".equals(cmd)) { String uiNum = request.getParameter("uiNum");
			 * Map<String,String> userInfo = uiService.selectUserInfo(uiNum);
			 * request.setAttribute("userInfo", userInfo); } else if("update".equals(cmd)) {
			 * String uiNum = request.getParameter("uiNum"); Map<String, String> userInfo =
			 * uiService.selectUserInfo(uiNum); request.setAttribute("userInfo", userInfo);
			 * 
			 * String uiName = request.getParameter("uiName"); String uiPwd =
			 * request.getParameter("biPwd"); String uiDesc =
			 * request.getParameter("uiDesc"); String uiBirth =
			 * request.getParameter("uiBirth"); Map<String, String> userInfo = new
			 * HashMap<>(); userInfo.put("uiName", uiName); userInfo.put("uiPwd", uiPwd);
			 * userInfo.put("uiDesc", uiDesc); //userInfo.put("uiBirth", uiBirth);
			 * userInfo.put("uiBirth", uiBirth.replace("-","")); int result =
			 * uiService.insertUserInfo(userInfo); request.setAttribute("msg",
			 * "update success"); request.setAttribute("url", "/user-info/login");
			 * if(result!=1) { request.setAttribute("msg", "update fail");
			 * request.setAttribute("url", "/user-info/insert"); }
			 * 
			 * }
			 */
		/*
		 * path += ".jsp"; RequestDispatcher rd = request.getRequestDispatcher(path);
		 * rd.forward(request, response);
		 */
		// CommonView.forward(request, response);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	private final static Gson GSON = new Gson();

	public static <T> T casting(HttpServletRequest request, Class<T> clazz) throws IOException {
		BufferedReader br = request.getReader();
		String str = null;
		StringBuffer sb = new StringBuffer();
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		return GSON.fromJson(sb.toString(), clazz);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = CommonView.getCmd(request);

		Map<String, String> userInfo = JSON.parse(request, Map.class);
		
		if(userInfo.get("uiBirth")!=null) {
			userInfo.put("uiBirth",  userInfo.get("uiBirth").replace("-", ""));
		}
		Map<String,String> result = new HashMap<>();
		int result = 0;
		if ("insert".equals(cmd)) {
			result = uiService.insertUserInfo(userInfo);
			if(uiService.insertUserInfo(userInfo)==1) {
				
			}
		} else if ("update".equals(cmd)) {
			String uiNum = request.getParameter("uiNum");
			userInfo.put("uiNum",  uiNum);
			result = uiService.updateUserInfo(userInfo);
			request.setAttribute("msg", "update success");
			request.setAttribute("url", "/user-info/view?uiNum="+uiNum);
			if (result != 1) {
				request.setAttribute("msg", "update fail");
				request.setAttribute("url", "/user-info/update?uiNum="+uiNum);
			}
		} else if ("delete".equals(cmd)) {
			String uiNum = request.getParameter("uiNum");
			result = uiService.deleteUserInfo(uiNum);
			request.setAttribute("msg", "update success");
			request.setAttribute("url", "/user-info/list");
			if (result != 1) {
				request.setAttribute("msg", "update fail");
				request.setAttribute("url", "/user-info/view?uiNum="+uiNum);
			}
		} else if ("login".equals(cmd)) {
			request.setAttribute("msg", "id or pw check");
			request.setAttribute("url", "/user-info/login");
			HttpSession session = request.getSession();
			boolean login = uiService.login(userInfo, session);
			if(login) {
				request.setAttribute("msg", "login end");
				request.setAttribute("url", "/");
			}
		}
		//CommonView.forwardMessage(request, response);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result);
	}

}
