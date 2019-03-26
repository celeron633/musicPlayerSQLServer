package com.qqmusic.webapi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qqmusic.entity.User;
import com.qqmusic.service.UserService;

public class RegAPI extends HttpServlet {

	private static final long serialVersionUID = 6203658875221136960L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 请求和响应的一个编码问题
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		resp.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = resp.getWriter();

		// 1)获取用户名和密码
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");

		boolean isReg = false;
		if (name != null && password != null && email != null) {
			User user = new User(name, password, email);
			UserService userService = new UserService();
			isReg = userService.regService(user);
		}
		if (isReg) {
			out.println("reg success");
		} else {
			out.println("reg faild");
		}

		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
