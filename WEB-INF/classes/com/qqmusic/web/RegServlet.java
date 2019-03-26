package com.qqmusic.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qqmusic.entity.User;
import com.qqmusic.service.UserService;

/*
 * 1）用户登录访问的servlet
 * 		获取 用户数据
 *  
 * 
 * */

public class RegServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6203658875221136960L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		// 请求和响应的一个编码问题
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		// 1)获取用户名和密码
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");

		User user = new User(name, password, email);

		UserService userService = new UserService();
		boolean isReg = userService.regService(user);

		HttpSession session = req.getSession();
		session.setAttribute("messageTitle", "用户注册");
		if (isReg) {
			user = userService.loginService(user);
			System.out.println("注册成功");
			session.setAttribute("messageContext", "您已成功注册！");
			session.setAttribute("user", user);
		} else {
			session.setAttribute("messageContext", "注册失败！");
			System.out.println("注册失败");
		}

		resp.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = resp.getWriter();
		out.println("success");

		resp.sendRedirect("message.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
