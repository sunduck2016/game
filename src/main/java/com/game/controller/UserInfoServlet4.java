package com.game.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.game.common.CommonView;
import com.game.service.UserInfoService;
import com.game.service.impl.UserInfoServiceImpl;
import com.game.vo.UserInfoVO;
import com.google.gson.Gson;

@WebServlet("/user-Info/*")
public class UserInfoServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService uiService = new UserInfoServiceImpl();
	private Gson gson = new Gson();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		String json = "";
		if ("list".equals(cmd)) {
			json = gson.toJson(uiService.selectUserInfoList(null));
		} else if ("view".equals(cmd) || "update".equals(cmd)) {
			
		} 
		response.setContentType("application/json;charset=UTF-8");
    	PrintWriter out = response.getWriter();
		List<String> list = new ArrayList<>();
		list.add("number 1");
		list.add("number 2");
		list.add("number 3");
		json = gson.toJson(list);
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
		/*request.setCharacterEncoding("UTF-8");
		String cmd = CommonView.getCmd(request);

		//Map<String, String> userInfo = JSON.parse(request, Map.class);
		UserInfoVO userInfo;
		
		if(userInfo.get("uiBirth")!=null) {
			userInfo.put("uiBirth",  userInfo.get("uiBirth").replace("-", ""));
		}
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
		out.print(result);*/
	}

}
