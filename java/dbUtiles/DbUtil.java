package dbUtiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {

	public static String username = "root";
	public static String pwd = "123456";
	public static String url = "jdbc:mysql://localhost:3306/library?serverTimezone=UTC";
	
	static{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConn(){
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(url,username,pwd);
		
		} catch (SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void CloseDB(ResultSet rs, PreparedStatement stm, Connection conn){
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stm!=null)
		{
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}

