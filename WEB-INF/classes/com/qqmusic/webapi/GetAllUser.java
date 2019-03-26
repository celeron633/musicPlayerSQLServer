package com.qqmusic.webapi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qqmusic.entity.User;
import com.qqmusic.service.UserService;

import com.alibaba.fastjson.*;

public class GetAllUser extends HttpServlet {

	private static final long serialVersionUID = 6203658875221136960L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 请求和响应的一个编码问题
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		resp.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = resp.getWriter();

		UserService userService = new UserService();
		List<User> allUser = userService.getAllUserService();
		String jsonString = JSON.toJSONString(allUser);

		out.println(jsonString);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
