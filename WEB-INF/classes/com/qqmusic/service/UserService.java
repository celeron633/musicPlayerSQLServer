package com.qqmusic.service;

import java.util.List;

import com.qqmusic.dao.UserDao;
import com.qqmusic.entity.User;

/*
 * 	用户操作的一个业务处理类
 *  	-- 登录
 *  	-- 注册
 * 
 * */

public class UserService {

	/*
	 * 处理的是 登录的一个业务逻辑
	 * 
	 * 1）判断 user对象是否符合要求
	 * 2）再将User对象交给 Dao (数据持久层)处理\
	 * 3)如果 登录成功，返回一个完整的User 对象
	 * 4）如果登录不成功，返回 null
	 * 
	 * 
	 * */
	public User loginService(User user) {
		
		//验证数据是否合法
		if(user.getName() == null || "".equals(user.getName())){
			return null;
		}
		
		//创建 dao 层对象
		UserDao userDao = new UserDao();
		
		//调用 dao 层方法：登录成功 ：返回 User对象；登录不成功：返回null
		User newUser = userDao.loginDao(user);
		
		return newUser;


	}
	
	/*
	 * 	 注册的业务逻辑 
	 * 		1)告诉 servlet  你是否 注册成功
	 * 		2)判断 用户名是否在数据库中已经存在 
	 *  		存在： 直接返回false
	 *  
	 *  		不存在： 注册成功，信息保存到数据库
	 * 
	 * */
	public boolean regService(User user){
		
		//1)判断用户名是否存在
		UserDao userDao = new UserDao();
		User userByName = userDao.getUserByNameDao(user.getName());
		
		if(userByName == null){
			//当前 要注册的用户名在数据库中是不存在的
			//System.out.println("用户名可用");
			
			//把 用户数据保存到数据库
			boolean isSave = userDao.saveUserDao(user);
			//保存成功，返回 true ,保存不成功，返回false
			return isSave;
			
		}else{
			//System.out.println("用户名已存在");
			
			return false;
		}
		
	}
	
	public List<User> getAllUserService() {
		// TODO Auto-generated method stub
		
		UserDao userDao = new UserDao();
		
		List<User> list = userDao.getAllUserDao();
		
		return list;
	}

	public User getUserByIdService(int id){
		
		if(id == 0){
			//数据错误
			return null;
		}
		
		//调用 Dao层方法去操作数据库
		UserDao userDao = new UserDao();
		
		User user = userDao.getUserByIdDao(id);
		
		return user;
		
	}

}






