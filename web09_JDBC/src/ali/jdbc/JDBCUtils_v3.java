package ali.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class JDBCUtils_v3 {
	public static String driver;
	public static String url;
	public static String username;
	public static String password;
	/**
	 * 静态代码块加载配置文件信息
	 */
	static {
		try {
			//1、获取类加载器
			ClassLoader clsaaLoader = JDBCUtils_v3.class.getClassLoader();
			//2、获取properties文件输入流
			InputStream is = ClassLoader.getSystemResourceAsStream("db.properties");
			//3、创建properties对象
			Properties props = new Properties();
			//4、加载输入流
			props.load(is);
			//5、获取相关参数值
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			username = props.getProperty("username");
			password = props.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}

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
