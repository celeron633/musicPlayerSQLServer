package com.qqmusic.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qqmusic.entity.Singer;
import com.qqmusic.entity.Song;
import com.qqmusic.service.SingerService;
import com.qqmusic.service.SongService;

/*
 * 1）用户登录访问的servlet
 * 		获取 用户数据
 * 
 * 
 * */

public class SearchServlet extends HttpServlet {

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

		// 1)获取
		String name = req.getParameter("searchname");

		// 2)验证

		// 2.1）把数据 封装到实体类中

		// 2.2)创建 Service对象 去进行业务逻辑的处理（数据的验证）
		SongService songService = new SongService();
		Song songResult = songService.getSongByNameService(name);

		SingerService singerService = new SingerService();
		Singer singerResult = singerService.getSingerByNameService(name);

		// 3) 处理结果，跳转界面
		HttpSession session = req.getSession();
		session.setAttribute("messageTitle", "搜索");
		if (songResult != null) {
			session.setAttribute("song", songResult);

			Singer singer2 = singerService.getSingerByIdService(songResult.getSinger());
			session.setAttribute("singerName", singer2.getName());
			session.setAttribute("singer", singer2);
			resp.sendRedirect("song.jsp");
		} else if (singerResult != null) {
			session.setAttribute("singer", singerResult);
			resp.sendRedirect("singer.jsp");
		} else {
			session.setAttribute("messageContext", "找不到歌曲或歌手");
			resp.sendRedirect("message.jsp");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
