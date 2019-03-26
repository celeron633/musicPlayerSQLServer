package com.qqmusic.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qqmusic.entity.Album;
import com.qqmusic.entity.Singer;
import com.qqmusic.entity.Song;
import com.qqmusic.entity.User;
import com.qqmusic.service.AlbumService;
import com.qqmusic.service.SingerService;
import com.qqmusic.service.SongService;
import com.qqmusic.service.UserService;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("<br>Database Test finish, no error.</br>");
		SongService songService2 = new SongService();
		Song song2 = songService2.getSongByIdService(1);
		if (song2 != null) {
			System.out.println(song2.getName());
		}

		SongService songService = new SongService();
		List<Song> list = songService.getAllSongService();
		for (int i = 0; i < list.size(); i++) {
			Song test1 = list.get(i);
			System.out.println(test1.toString());
		}

		Song newSong = songService.getSongByNameService("หýหต");
		System.out.println(newSong.toString());

		SingerService singerService = new SingerService();
		List<Singer> list2 = singerService.getAllSingerService();
		for (int i = 0; i < list2.size(); i++) {
			Singer test1 = list2.get(i);
			System.out.println(test1.toString());
		}

		UserService userService = new UserService();
		List<User> list3 = userService.getAllUserService();
		for (int i = 0; i < list3.size(); i++) {
			User test1 = list3.get(i);
			System.out.println(test1.toString());
		}

		AlbumService albumService = new AlbumService();
		List<Album> albumList = albumService.getAllAlbumService();

		for (int i = 0; i < albumList.size(); i++) {
			Album test1 = albumList.get(i);
			System.out.println(test1.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
