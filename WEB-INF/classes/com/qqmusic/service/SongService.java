package com.qqmusic.service;

import java.util.List;

import com.qqmusic.dao.SongDao;
import com.qqmusic.entity.Song;

/*
 * 
 * 用来处理 歌曲模块的业务逻辑
 * 
 * */

public class SongService {

	/*
	 * 查询所有歌曲的 业务逻辑
	 * 	
	 *  创建dao层对象，去数据库中取出数据
	 * 
	 * 
	 * */
	
	public List<Song> getAllSongService() {
		// TODO Auto-generated method stub
		
		SongDao songDao = new SongDao();
		
		List<Song> list = songDao.getAllSongDao();
		
		return list;
	}
	
	public List<Song> getAllSongBySingerNameService(String name) {
		// TODO Auto-generated method stub
		
		SongDao songDao = new SongDao();
		List<Song> list = songDao.getAllSongBySingerNameDao(name);	
		return list;
	}
	
	public List<Song> getAllSongByAlbumIDService(int id) {
		// TODO Auto-generated method stub
		
		SongDao songDao = new SongDao();
		List<Song> list = songDao.getAllSongByAlbumIDDao(id);	
		return list;
	}
	
	public List<Song> getAllSongByListqIDService(int id) {
		SongDao songDao = new SongDao();
		List<Song> list = songDao.getAllSongByListqIDDao(id);	
		return list;
	}
	/*
	 * 	通过 id 取 Song对象的业务逻辑方法
	 * 
	 * */
	public Song getSongByNameService(String name){
		
		if(name == null|| name.equals("")){
			//数据错误
			return null;
		}
		
		//调用 Dao层方法去操作数据库
		SongDao songDao = new SongDao();
		
		Song song = songDao.getSongByNameDao(name);
		
		return song;
		
	}
	
	public Song getSongByIdService(int id){
		
		if(id == 0){
			//数据错误
			return null;
		}
		
		//调用 Dao层方法去操作数据库
		SongDao songDao = new SongDao();
		
		Song song = songDao.getSongByIdDao(id);
		
		return song;
		
	}



}
