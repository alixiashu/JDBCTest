package ali.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import org.junit.Test;

import ali.jdbc.JDBCUtils_v1;
import ali.jdbc.JDBCUtils_v2;
import ali.jdbc.JDBCUtils_v3;
/**
 * 
 * @author alixia
 * @version v1.0
 */

 
public class TestUtils {
	/**
	 * 插入数据
	 */
	@Test
	public void testAdd() {
		Connection conn = null;
		PreparedStatement pstmt =null;
		try {
			conn = JDBCUtils_v2.getConnection();
			String sql = "insert into tbl_users values(null,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "ali");
			pstmt.setString(2, "ali");
			int i = pstmt.executeUpdate();
			if(i>0)
				System.out.println("添加成功！");
			else
				System.out.println("添加失败！");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils_v2.release(conn, pstmt, null);
		}
	}
	/**
	 * 根据id删除数据
	 */
	@Test
	public void testDeleteById() {
		Connection conn = null;
		PreparedStatement pstmt =null;
		try {
			conn = JDBCUtils_v2.getConnection();
			String sql = "delete from tbl_users where uid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "16");
			//删除操作
			int i = pstmt.executeUpdate();
			if(i>0)
				System.out.println("删除成功！");
			else
				System.out.println("删除失败！");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils_v3.release(conn, pstmt, null);
		}
	}
	/**
	 * 根据id更新数据
	 */
	@Test
	public void testUpdateById() {
		Connection conn = null;
		PreparedStatement pstmt =null;
		try {
			conn = JDBCUtils_v2.getConnection();
			String sql = "update tbl_users set upassword=? where uid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "5");
			pstmt.setString(2, "alixia");
			//删除操作
			int i = pstmt.executeUpdate();
			if(i>0)
				System.out.println("更新成功！");
			else
				System.out.println("更新失败！");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils_v3.release(conn, pstmt, null);
		}
	}
	/**
	 * 根据用户id查询信息
	 */
	@Test
	public void testFindUserById() {
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		//1、获取连接
		Connection conn= JDBCUtils_v1.getConnection();
		//2、sql语句
		String sql = "select * from tbl_users where uid=?";
		
		try {
			//3、获取PreparedStatement
			pstmt = conn.prepareStatement(sql);
			//4、设置占位符
			pstmt.setInt(1, 5);
			rs = pstmt.executeQuery();
			while(rs.next())
				System.out.println(rs.getString(2)+" | "+rs.getString("upassword"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils_v1.release(conn, pstmt, rs);
		}
		
		
		
	}

}
