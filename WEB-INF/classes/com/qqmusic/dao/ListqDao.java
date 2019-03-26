package com.qqmusic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qqmusic.entity.Listq;

/*
 * 		处理用户 数据的 数据持久层
 * */
public class ListqDao {
	
	private Connection conn = null;
	private String generalSql="select * from ShowList";
	private String idname="id";
	private String namename="Name";
	
	private Listq getListqByRS(ResultSet rs)
	{
		Listq tempListq=null;
		try {
			int id = rs.getInt("id");
			String info = rs.getString("linfo");
			String name = rs.getString("Name");
			Boolean open = rs.getBoolean("lopen");
			String style = rs.getString("lstyle");
			int times = rs.getInt("ltimes");
			int uid = rs.getInt("uid");
			String uname = rs.getString("uname");
	
			
			//把数据封装到 Listq对象
			tempListq = new Listq(id,name,uid,style, info,times,open, uname);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return tempListq;
	}

	public List<Listq> getAllListqDao() {
		
		conn = BaseDao.getConnection();
		
		String sql = generalSql;
		
		List<Listq> list = new ArrayList<Listq>();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt =  conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			//遍历的过程，把 List<Listq> 封装好
			while(rs.next()){
				
				//把数据封装到 Listq对象
				Listq tempListq = getListqByRS(rs);
				
				//把Listq对象存到 list 集合中
				list.add(tempListq);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BaseDao.close(stmt, rs);
		}
		
		return list;
	
	}

	/*
	 * 通过 id 去数据库中 取出 listq对象
	 * 
	 * */
	public Listq getListqByIdDao(int id) {
		
		
		conn = BaseDao.getConnection();
		
		String sql = generalSql+" where "+idname+" = ?";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		Listq listq = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			
			rs = pstm.executeQuery();
			
			while(rs.next()){
				//把数据封装到 Listq对象
				listq = getListqByRS(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			BaseDao.close(pstm, rs);
		}
		
		return listq;
	}
	
	public Listq getListqByNameDao(String name) {

		conn = BaseDao.getConnection();

		String sql = generalSql+" where "+namename+" = ?"; // 占位符

		PreparedStatement pstm = null;
		ResultSet rs = null;

		Listq newListq = null;

		try {
			pstm = conn.prepareStatement(sql);
			// 填充预编译 sql 中的占位符
			pstm.setString(1, name);

			rs = pstm.executeQuery();

			// 进到这个while 循环，说明 根据这个用户名我们查出了数据
			while (rs.next()) {

				//把数据封装到 Listq对象
				newListq = getListqByRS(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(pstm, rs);
		}

		return newListq;
	}
	
	
}

