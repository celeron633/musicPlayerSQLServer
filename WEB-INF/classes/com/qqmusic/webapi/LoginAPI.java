package com.qqmusic.webapi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qqmusic.entity.User;
import com.qqmusic.service.UserService;

public class LoginAPI extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3848608511938023355L;

	@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");

		String name = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter out = resp.getWriter();
		User newUser = null;
		if (name != null && password != null) {
			System.out.println(name + "--" + password);
			User user = new User(name, password);
			UserService userService = new UserService();
			newUser = userService.loginService(user);
		}
		if (newUser == null) {
			// 登录不成功
			out.println("login faild");
		} else {
			// 登录成功
			out.println("login success");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		doGet(req, resp);
	}

}
