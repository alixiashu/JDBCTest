package execise.ali;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testJDBC {
	@Before
	public void before() {
		System.out.println("Before");
		
	}
	@After
	public void after() {
		System.out.println("After");
	}
	
	@Test
	public void testJUnit() {
//		System.out.println("Hello,Junit!");
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
//			Login.login("li", "123");
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08?useSSL=false","root","12121735");
			stm = con.createStatement();
			//DML操作
			stm.executeUpdate("insert into tbl_users values(null,'ali','12121735')");
			//DQL操作
			String sql = "select * from tbl_users";
			rs = stm.executeQuery(sql);
			while(rs.next())
				System.out.println("序号： "+rs.getString(1)+" 用户名："+rs.getString(2)+" 密码："+rs.getString("upassword"));
			
			System.out.println("Hello,Junit!");
			
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				rs.close();
				stm.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
