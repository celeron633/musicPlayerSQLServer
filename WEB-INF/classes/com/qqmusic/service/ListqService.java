package com.qqmusic.service;

import java.util.List;

import com.qqmusic.dao.ListqDao;
import com.qqmusic.entity.Listq;

/*
 * 
 * 用来处理 歌单模块的业务逻辑
 * 
 * */

public class ListqService {

	/*
	 * 查询所有歌单的 业务逻辑
	 * 	
	 *  创建dao层对象，去数据库中取出数据
	 * 
	 * 
	 * */
	
	public List<Listq> getAllListqService() {
		// TODO Auto-generated method stub
		
		ListqDao listqDao = new ListqDao();
		
		List<Listq> list = listqDao.getAllListqDao();
		
		return list;
	}
	
	
	/*
	 * 	通过 id 取 Listq对象的业务逻辑方法
	 * 
	 * */
	public Listq getListqByNameService(String name){
		
		if(name == null|| name.equals("")){
			//数据错误
			return null;
		}
		
		//调用 Dao层方法去操作数据库
		ListqDao listqDao = new ListqDao();
		
		Listq listq = listqDao.getListqByNameDao(name);
		
		return listq;
		
	}
	
	public Listq getListqByIdService(int id){
		
		if(id == 0){
			//数据错误
			return null;
		}
		
		//调用 Dao层方法去操作数据库
		ListqDao listqDao = new ListqDao();
		
		Listq listq = listqDao.getListqByIdDao(id);
		
		return listq;
		
	}

}
