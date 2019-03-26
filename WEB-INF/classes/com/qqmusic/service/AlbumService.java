package com.qqmusic.service;

import java.util.List;

import com.qqmusic.dao.AlbumDao;
import com.qqmusic.entity.Album;

/*
 * 
 * 用来处理 专辑模块的业务逻辑
 * 
 * */

public class AlbumService {

	/*
	 * 查询所有专辑的 业务逻辑
	 * 	
	 *  创建dao层对象，去数据库中取出数据
	 * 
	 * 
	 * */
	
	public List<Album> getAllAlbumService() {
		// TODO Auto-generated method stub
		
		AlbumDao albumDao = new AlbumDao();
		
		List<Album> list = albumDao.getAllAlbumDao();
		
		return list;
	}
	
	
	/*
	 * 	通过 id 取 Album对象的业务逻辑方法
	 * 
	 * */
	public Album getAlbumByNameService(String name){
		
		if(name == null|| name.equals("")){
			//数据错误
			return null;
		}
		
		//调用 Dao层方法去操作数据库
		AlbumDao albumDao = new AlbumDao();
		
		Album album = albumDao.getAlbumByNameDao(name);
		
		return album;
		
	}
	
	public Album getAlbumByIdService(int id){
		
		if(id == 0){
			//数据错误
			return null;
		}
		
		//调用 Dao层方法去操作数据库
		AlbumDao albumDao = new AlbumDao();
		
		Album album = albumDao.getAlbumByIdDao(id);
		
		return album;
		
	}

}
