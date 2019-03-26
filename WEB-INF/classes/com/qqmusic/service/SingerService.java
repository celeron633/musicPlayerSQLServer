package com.qqmusic.service;

import java.util.List;

import com.qqmusic.dao.SingerDao;
import com.qqmusic.entity.Singer;

/*
 * 
 * 用来处理 歌手模块的业务逻辑
 * 
 * */

public class SingerService {

	/*
	 * 查询所有歌手的 业务逻辑
	 * 	
	 *  创建dao层对象，去数据库中取出数据
	 * 
	 * 
	 * */
	
	public List<Singer> getAllSingerService() {
		// TODO Auto-generated method stub
		
		SingerDao singerDao = new SingerDao();
		
		List<Singer> list = singerDao.getAllSingerDao();
		
		return list;
	}
	
	/*
	 * 	通过 id 取 Singer对象的业务逻辑方法
	 * 
	 * */
	public Singer getSingerByNameService(String name){
		
		if(name == null|| name.equals("")){
			//数据错误
			return null;
		}
		
		//调用 Dao层方法去操作数据库
		SingerDao singerDao = new SingerDao();
		
		Singer singer = singerDao.getSingerByNameDao(name);
		
		return singer;
		
	}
	
	public Singer getSingerByIdService(int id){
		
		if(id == 0){
			//数据错误
			return null;
		}
		
		//调用 Dao层方法去操作数据库
		SingerDao singerDao = new SingerDao();
		
		Singer singer = singerDao.getSingerByIdDao(id);
		
		return singer;
		
	}


}
