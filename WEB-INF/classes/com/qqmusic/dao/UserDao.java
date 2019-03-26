package com.qqmusic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qqmusic.entity.User;


/*
 * 		处理用户 数据的 数据持久层
 * 
 * 
 * */

public class UserDao {

	private Connection conn = null;
	private String idname ="uid";
	private String namename ="uname";
	private String passwordname ="upassword";
	private String emailname ="uemail";
	private String generalSql="select * from UserTable";
	
	private User getUserByRS(ResultSet rs) {
		User tempUser=null;
		try {
			int id = rs.getInt(idname);
			String newName = rs.getString(namename);
			String password = rs.getString(passwordname);
			String email = rs.getString(emailname);
			tempUser = new User(id,newName, password, email);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return tempUser;
	}
	/*
	 * 这个方法 就是 去数据库里面去验证 当前的数据是否 能够登录成功
	 * 
	 * 1)进行数据库的连接
	 * 
	 */
	public User loginDao(User user) {

		conn = BaseDao.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		User newUser = null;

		String sql = generalSql;

		System.out.println("--" + conn);

		try {
			// 对sql 进行预编译
			pstm = conn.prepareStatement(sql);
			// 去数据库里面执行sql语句，返回 ResultSet对象
			rs = pstm.executeQuery();

			// 遍历ResultSet对象
			while (rs.next()) {

				// 通过字段名取数据
				String uname = rs.getString(namename);
				String password = rs.getString(passwordname);

				if (uname.equals(user.getName()) && password.equals(user.getPassword())) {
					// 用户名和密码 匹配成功
					int id = rs.getInt(idname);
					String email = rs.getString(emailname);
					// 匹配成功，创建 User 对象，用作返回
					newUser = new User(id,uname, password, email);
					break;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(pstm, rs);
		}

		return newUser;

	}

	/*
	 * 通过 用户的名字 去查找对应的用户
	 * 
	 */
	public User getUserByNameDao(String name) {

		conn = BaseDao.getConnection();

		String sql = generalSql+" where "+namename+" = ?"; // 占位符

		PreparedStatement pstm = null;
		ResultSet rs = null;

		User newUser = null;

		try {
			pstm = conn.prepareStatement(sql);
			// 填充预编译 sql 中的占位符
			pstm.setString(1, name);

			rs = pstm.executeQuery();

			// 进到这个while 循环，说明 根据这个用户名我们查出了数据
			while (rs.next()) {
				int id = rs.getInt(idname);
				String newName = rs.getString(namename);
				String password = rs.getString(passwordname);
				String email = rs.getString(emailname);
				newUser = new User(id,newName, password, email);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(pstm, rs);
		}

		return newUser;
	}

	/*
	 * 保存 一个新的用户到数据库
	 * 
	 * 
	 */
	public boolean saveUserDao(User user) {

		conn = BaseDao.getConnection();

		PreparedStatement pstm = null;
		// 受影响的行数
		int row = 0;

		String sql = "INSERT INTO UserTable(uname, upassword, uemail) VALUES (?, ?,?)";

		try {
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, user.getName());
			pstm.setString(2, user.getPassword());
			pstm.setString(3, user.getEmail());

			// 执行sql 语句，方法的返回值 是受影响的行数
			row = pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(pstm, null);
		}

		// 如果受影响的行数 为 1 行
		if (row == 1) {
			return true;
		} else {
			return false;
		}

	}

	public List<User> getAllUserDao() {
		conn = BaseDao.getConnection();
		
		String sql = generalSql;
		
		List<User> list = new ArrayList<User>();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt =  conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			//遍历的过程，把 List<user> 封装好
			while(rs.next()){
				
				//获取 当前这一条字段的信息
				int id = rs.getInt(idname);
				String name = rs.getString(namename);
				String password = rs.getString(passwordname);
				String email = rs.getString(emailname);
				//把数据封装到 user对象
				User tempuser = new User(id,name,password,email);
				
				//把user对象存到 list 集合中
				list.add(tempuser);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BaseDao.close(stmt, rs);
		}
		
		return list;
	
	}

	public User getUserByIdDao(int id) {

		conn = BaseDao.getConnection();

		String sql = generalSql+" where UserTable.uid = ?";

		PreparedStatement pstm = null;
		ResultSet rs = null;

		User user = null;

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			rs = pstm.executeQuery();

			while (rs.next()) {
				user = getUserByRS(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			BaseDao.close(pstm, rs);
		}

		return user;
	}


	
	
}
