package com.qqmusic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qqmusic.entity.Song;

/*
 * 		处理音乐 数据的 数据持久层
 */

public class SongDao {

	private Connection conn = null;
	private String generalSql="SELECT SongTable.id,SingerTable.id singer,SongTable.Name, SingerTable.Name singername, SongTable.slyric, SongTable.stimes,SongTable.slanguage, SongTable.sstyle ,SongTable.sfile FROM SongTable INNER JOIN SingingTable ON SongTable.id = SingingTable.Son_id INNER JOIN SingerTable ON SingingTable.id = SingerTable.id";
	
	private Song getSongByRS(ResultSet rs)
	{
		Song tempSong=null;
		try {
			int id = rs.getInt("id");
			String name = rs.getString("Name");
			int singer = rs.getInt("singer");
			String file = rs.getString("sfile");
			String language = rs.getString("slanguage");
			String style = rs.getString("sstyle");
			String lyric = rs.getString("slyric");
			int times =rs.getInt("stimes");
			String singername = rs.getString("singername");
			tempSong = new Song(id, name, singer, file,language,style,lyric,times,singername);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return tempSong;
	}
	
	public List<Song> getAllSongDao() {

		conn = BaseDao.getConnection();

		String sql = generalSql;
		List<Song> list = new ArrayList<Song>();

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			// 遍历的过程，把 List<Song> 封装好
			while (rs.next()) {

				Song tempSong = getSongByRS(rs);
				// 把Song对象存到 list 集合中
				list.add(tempSong);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(stmt, rs);
		}

		return list;

	}

	/*
	 * 通过 id 去数据库中 取出 song对象
	 * 
	 */
	public Song getSongByIdDao(int id) {

		conn = BaseDao.getConnection();

		String sql = generalSql+" where SongTable.id = ?";

		PreparedStatement pstm = null;
		ResultSet rs = null;

		Song song = null;

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			rs = pstm.executeQuery();

			while (rs.next()) {
				song = getSongByRS(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			BaseDao.close(pstm, rs);
		}

		return song;
	}

	public Song getSongByNameDao(String name) {

		conn = BaseDao.getConnection();

		String sql = generalSql+" WHERE SongTable.Name=?";

		PreparedStatement pstm = null;
		ResultSet rs = null;

		Song newSong = null;

		try {
			pstm = conn.prepareStatement(sql);
			// 填充预编译 sql 中的占位符
			pstm.setString(1, name);

			rs = pstm.executeQuery();

			// 进到这个while 循环，说明 根据这个用户名我们查出了数据
			while (rs.next()) {
				newSong = getSongByRS(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(pstm, rs);
		}

		return newSong;
	}
	
	public List<Song> getAllSongBySingerNameDao(String name) {

		conn = BaseDao.getConnection();

		String sql = generalSql+" WHERE SingerTable.Name=?";
		List<Song> list = new ArrayList<Song>();

		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = conn.prepareStatement(sql);
			// 填充预编译 sql 中的占位符
			pstm.setString(1, name);
			rs = pstm.executeQuery();

			// 遍历的过程，把 List<Song> 封装好
			while (rs.next()) {

				Song tempSong = getSongByRS(rs);
				// 把Song对象存到 list 集合中
				list.add(tempSong);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(pstm, rs);
		}

		return list;

	}
	public List<Song> getAllSongByAlbumIDDao(int id) {

		conn = BaseDao.getConnection();

		String sql = "select * from CollectingTable where id=?";
		List<Song> list = new ArrayList<Song>();

		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = conn.prepareStatement(sql);
			// 填充预编译 sql 中的占位符
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			SongDao songDao = new SongDao();
			// 遍历的过程，把 List<Song> 封装好
			while (rs.next()) {

				Song tempSong = songDao.getSongByIdDao(rs.getInt("Son_id"));
				// 把Song对象存到 list 集合中
				list.add(tempSong);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(pstm, rs);
		}

		return list;

	}

	public List<Song> getAllSongByListqIDDao(int id) {
		conn = BaseDao.getConnection();

		String sql = "select * from ListingTable where id=?";
		List<Song> list = new ArrayList<Song>();

		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = conn.prepareStatement(sql);
			// 填充预编译 sql 中的占位符
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			SongDao songDao = new SongDao();
			// 遍历的过程，把 List<Song> 封装好
			while (rs.next()) {

				Song tempSong = songDao.getSongByIdDao(rs.getInt("Son_id"));
				// 把Song对象存到 list 集合中
				list.add(tempSong);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(pstm, rs);
		}

		return list;

	}

}
