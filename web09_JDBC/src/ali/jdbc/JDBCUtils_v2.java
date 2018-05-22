package ali.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCUtils_v2 {
	public static String driver;
	public static String url;
	public static String username;
	public static String password;
	/**
	 * 静态代码块加载配置文件信息
	 */
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("db");
		driver = bundle.getString("driver");
		url = bundle.getString("url");
		username = bundle.getString("username");
		password = bundle.getString("password");
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
			
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return conn;
	}
	
	public static void release(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		
	}

}
