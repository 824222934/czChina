package c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;



public class C3p0Util {
	/*
	 * ���ݿ����ӳز���
	 */
	static ComboPooledDataSource cpds = null;
	static{
		cpds = new ComboPooledDataSource("library");
	}
	//������ݿ�����
	public static java.sql.Connection getConnection(){
		try {
			return  cpds.getConnection();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	//�ر����ݿ�����
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
