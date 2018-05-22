package execise.ali;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
/**
 * 用户登录类
 * @author alixia
 * @date 2018-05-14
 * @version v1.0
 */
public class Login {
	@Test
	public void test() {
		try {
			login1("li","123");
			login1("li' or 'zs","123");
			login("li","123");
			login("li' or 'zs","123");
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	void login(String username,String password) throws ClassNotFoundException, SQLException {
		//1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、获得连接
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08?useSSL=false","root","12121735");
		
		/**
		 * 使用PreparedStatement可以解决login1中的sql书写和注入问题
		 */
		//3、书写查询语句
		String sql = "select * from tbl_users where uname = ? and upassword = ?;";;
		//4、创建预处理对象
		PreparedStatement pst = con.prepareStatement(sql);
		//5、设置参数给占位符(?);必须从1开始
		pst.setString(1, username);
		pst.setString(2, password);
		
		//System.out.println(sql);
		ResultSet rs = pst.executeQuery();
		if(rs.next())
			System.out.println("恭喜登录成功");
		else
			System.out.println("账号或者密码错误");
		if(rs != null)
			rs.close();
		if(pst != null)
			pst.close();
		if(con != null)
			con.close();
	}
	
	public void login1(String username,String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08?useSSL=false","root","12121735");
		Statement stm = con.createStatement();
		//书写查询语句
		String sql = "select * from tbl_users where uname = '"+username+"' and upassword = '"+password+"';";;
		System.out.println(sql);
		ResultSet rs = stm.executeQuery(sql);
		if(rs.next())
			System.out.println("恭喜登录成功");
		else
			System.out.println("账号或者密码错误");
		if(rs != null)
			rs.close();
		if(stm != null)
			stm.close();
		if(con != null)
			con.close();
	}

}
