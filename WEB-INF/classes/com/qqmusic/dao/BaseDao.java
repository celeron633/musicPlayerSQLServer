package com.qqmusic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * 1）获取 Connection 对象  
 * 		使用 单例模式 去获取 Connection 对象
 * 2）释放相关资源
 * */

public class BaseDao {

	// 维护一个私有的 Connection 对象
	private static Connection conn = null;

	// 提供一个公共的方法让别人能获取到这个Connection 对象
	public static Connection getConnection() {

		if (conn == null) {

			try {
				String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				String dbURL = "jdbc:sqlserver://www.adamqqq.com:1433;DatabaseName=qqmusic";
				String userName = "LoginAdmin";
				String userPwd = "qqmusic-123";

				// 创建Connection对象
				// 1)加载 jdbc的驱动

				Class.forName(driverName);
				// 2)连接数据库实例，获取连接对象
				conn = DriverManager.getConnection(dbURL, userName, userPwd);

				System.out.println(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// 自定义异常
				System.out.println("数据库连接异常");
			}

		}

		return conn;

	}

	/*
	 * 关闭相关资源
	 * 
	 */

	public static void close(Statement stmt, ResultSet rs) {

		try {

			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			System.out.println("释放资源异常");
			e.printStackTrace();
		}

	}
}
