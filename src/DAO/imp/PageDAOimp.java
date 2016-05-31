package DAO.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import c3p0.C3p0Util;
import entity.Mood;
import DAO.PageDAO;

public class PageDAOimp implements PageDAO{
	
	 

	/**
	  * 分页查询
	  * 
	  * @param offset 开始记录
	  * @param length 一次查询几条记录
	  * @return
	  */
	@Override
	public List queryForPage(int offset, int length) {
		
		String sql = "select * from mood limit ?,?";
		List<Mood> list = new ArrayList<Mood>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = C3p0Util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, offset);
			ps.setInt(2, length);
			rs = ps.executeQuery();
			while(rs.next()){
				Mood mood = new Mood();
				mood.setMoodTitle(rs.getString("moodtitle"));
				mood.setMoodContent(rs.getString("moodContent"));
				mood.setPhotoUrl(rs.getString("photourl"));
				list.add(mood);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3p0Util.close(conn, ps, rs);
		}
		return list;
	}

	@Override
	public int getAllRowCount() {
		String sql = "select * from mood";
		int count = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = C3p0Util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3p0Util.close(conn, ps, rs);
		}
		
		return count;
	}

}
