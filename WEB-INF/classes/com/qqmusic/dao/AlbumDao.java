package com.qqmusic.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qqmusic.entity.Album;

/*
 * 		处理用户 数据的 数据持久层
 * */ 
public class AlbumDao {
	
	private Connection conn = null;
	private String generalSql="select * from AlbumTable";
	private String idname="id";
	private String namename="Name";
	
	private Album getAlbumByRS(ResultSet rs)
	{
		Album tempAlbum=null;
		try {
			int id = rs.getInt("id");
			String name = rs.getString("Name");
			String style = rs.getString("astyle");
			String language = rs.getString("alanguage");
			Date date= rs.getDate("adate");
			String company = rs.getString("acompany");
			
			//把数据封装到 Album对象
			tempAlbum = new Album(id,name,style,language,date,company);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return tempAlbum;
	}

	public List<Album> getAllAlbumDao() {
		
		conn = BaseDao.getConnection();
		
		String sql = generalSql;
		
		List<Album> list = new ArrayList<Album>();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt =  conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			//遍历的过程，把 List<Album> 封装好
			while(rs.next()){
				
				//把数据封装到 Album对象
				Album tempAlbum = getAlbumByRS(rs);
				
				//把Album对象存到 list 集合中
				list.add(tempAlbum);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BaseDao.close(stmt, rs);
		}
		
		return list;
	
	}

	/*
	 * 通过 id 去数据库中 取出 album对象
	 * 
	 * */
	public Album getAlbumByIdDao(int id) {
		
		
		conn = BaseDao.getConnection();
		
		String sql = generalSql+" where "+idname+" = ?";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		Album album = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			
			rs = pstm.executeQuery();
			
			while(rs.next()){
				//把数据封装到 Album对象
				album = getAlbumByRS(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			BaseDao.close(pstm, rs);
		}
		
		return album;
	}
	
	public Album getAlbumByNameDao(String name) {

		conn = BaseDao.getConnection();

		String sql = generalSql+" where "+namename+" = ?"; // 占位符

		PreparedStatement pstm = null;
		ResultSet rs = null;

		Album newAlbum = null;

		try {
			pstm = conn.prepareStatement(sql);
			// 填充预编译 sql 中的占位符
			pstm.setString(1, name);

			rs = pstm.executeQuery();

			// 进到这个while 循环，说明 根据这个用户名我们查出了数据
			while (rs.next()) {

				//把数据封装到 Album对象
				newAlbum = getAlbumByRS(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(pstm, rs);
		}

		return newAlbum;
	}
	
	
}

