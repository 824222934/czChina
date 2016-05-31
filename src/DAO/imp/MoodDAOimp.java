package DAO.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import c3p0.C3p0Util;
import entity.Mood;
import DAO.MoodDAO;

public class MoodDAOimp implements MoodDAO{

	/**
	 * ���һ��mood���ݵ����ݿ�
	 * 
	 * @param moodtitle �������
	 * @param moodcontent ��������
	 * @param imgUrl �����ͼƬ��ַ
	 * 
	 * @return ������ȷ���
	 */
	@Override
	public boolean publishDD(String moodTitle, String moodContent, String imgUrl) {
		// TODO Auto-generated method stub
		String sql = "insert into mood(moodtitle,moodcontent,photourl) values(?,?,?);";
		Connection conn  = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = C3p0Util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, moodTitle);
			ps.setString(2, moodContent);
			ps.setString(3, imgUrl);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3p0Util.close(conn, ps, rs);
		}
		
		return false;
	}

	@Override
	public List<Mood> showMoods() {
		// TODO Auto-generated method stub
		String sql = "select * from mood";
		List<Mood> moodList = new ArrayList<Mood>();
		Connection conn  = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = C3p0Util.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Mood mood = new Mood();
				mood.setMoodTitle(rs.getString("moodtitle"));
				mood.setMoodContent(rs.getString("moodcontent"));
				mood.setPhotoUrl(rs.getString("photourl"));
				
				moodList.add(mood);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moodList;
	}

}
