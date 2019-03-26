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

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1634435321526587374L;

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

		System.out.println(name + "--" + password);

		// 2)去验证 这个用户名和密码在数据库里面是否存在

		// 2.1）把数据 封装到实体类中
		User user = new User(name, password);

		// 2.2)创建 Service对象 去进行业务逻辑的处理（数据的验证）
		UserService userService = new UserService();
		User newUser = userService.loginService(user);

		// 3) 处理结果，跳转界面
		HttpSession session = req.getSession();
		session.setAttribute("messageTitle", "用户登录");
		if (newUser == null) {
			// 登录不成功
			System.out.println("登录不成功");
			session.setAttribute("messageContext", "用户名或密码错误！");
		} else {
			// 登录成功
			// 把数据用户保存 到 Session 域对象中
			// 现在，把session这个对象单纯地理解为 后台与前端的数据 传递（域对象）
			System.out.println("登录成功");
			session.setAttribute("messageContext", "您已成功登录！");
			session.setAttribute("user", newUser);
		}

		resp.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = resp.getWriter();
		out.println("success");

		resp.sendRedirect("./message.jsp");
		// 跳转

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
