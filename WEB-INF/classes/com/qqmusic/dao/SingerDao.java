package com.qqmusic.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qqmusic.entity.Singer;

/*
 * 		处理用户 数据的 数据持久层
 * 
 * 
 * */
public class SingerDao {
	
	private Connection conn = null;
	private String idname ="id";
	private String namename ="Name";
	private String introductionname ="Sinfo";
	private String generalSql="select * from SingerTable";
	
	private Singer getSingerByRS(ResultSet rs)
	{
		Singer tempSinger=null;
		try {
			int id = rs.getInt(idname);
			String name = rs.getString(namename);
			String introduction = rs.getString(introductionname);
			Boolean sex =rs.getBoolean("ssex");
			Date birthday =rs.getDate("sbirthday");
			String nation =rs.getString("snation");
			String hometown =rs.getString("shometown");
			String image = rs.getString("simage");
			
			//把数据封装到 Singer对象
			tempSinger = new Singer(id,name,introduction,sex,birthday,nation,hometown,image);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return tempSinger;
	}

	public List<Singer> getAllSingerDao() {
		
		conn = BaseDao.getConnection();
		
		String sql = generalSql;
		
		List<Singer> list = new ArrayList<Singer>();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt =  conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			//遍历的过程，把 List<Singer> 封装好
			while(rs.next()){
				
				//把数据封装到 Singer对象
				Singer tempSinger = getSingerByRS(rs);
				
				//把Singer对象存到 list 集合中
				list.add(tempSinger);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			BaseDao.close(stmt, rs);
		}
		
		return list;
	
	}

	/*
	 * 通过 id 去数据库中 取出 singer对象
	 * 
	 * */
	public Singer getSingerByIdDao(int id) {
		
		
		conn = BaseDao.getConnection();
		
		String sql = generalSql+" where "+idname+" = ?";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		Singer singer = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			
			rs = pstm.executeQuery();
			
			while(rs.next()){
				//把数据封装到 Singer对象
				singer = getSingerByRS(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			BaseDao.close(pstm, rs);
		}
		
		return singer;
	}
	
	public Singer getSingerByNameDao(String name) {

		conn = BaseDao.getConnection();

		String sql = generalSql+" where "+namename+" = ?"; // 占位符

		PreparedStatement pstm = null;
		ResultSet rs = null;

		Singer newSinger = null;

		try {
			pstm = conn.prepareStatement(sql);
			// 填充预编译 sql 中的占位符
			pstm.setString(1, name);

			rs = pstm.executeQuery();

			// 进到这个while 循环，说明 根据这个用户名我们查出了数据
			while (rs.next()) {

				//把数据封装到 Singer对象
				newSinger = getSingerByRS(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(pstm, rs);
		}

		return newSinger;
	}
	

}

