package com.jdbc.alixia.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;

import com.jdbc.alixia.DataSource.MyDataSource;
import com.jdbc.alixia.DataSource.MyDataSource1;
import com.jdbc.alixia.utils.JDBCUtils_v3;

public class TestMyDataSource {

	/**
	 * 添加用户，使用增强的Connection
	 */
	@Test
	public void testAdd() {
		Connection conn = null;
		PreparedStatement pstm = null;
		//1、创建连接池
		MyDataSource myDataSource = new MyDataSource();
		try {
			
			//2、从连接池中获取Connection对象
			conn = myDataSource.getConnection();
			String sql = "insert into tbl_users values(null,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "zhangsan");
			pstm.setString(2, "123");
			int rows = pstm.executeUpdate();
			if(rows != 0)
				System.out.println("更新成功！");
			else
				System.out.println("更新失败！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myDataSource.backConnection(conn);
		}
	}
	
	/**
	 * 添加用户，使用增强的Connection
	 */
	@Test
	public void testAddNew() {
		Connection conn = null;
		PreparedStatement pstm = null;
		//1、创建连接池
		DataSource myDataSource = new MyDataSource1();
		try {
			
			//2、从连接池中获取Connection对象
			conn = myDataSource.getConnection();
			String sql = "insert into tbl_users values(null,?,?)";
			//3、需要重写MyConnection里的prepareStatement(sql)方法
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "zhangsan1");
			pstm.setString(2, "1231");
			int rows = pstm.executeUpdate();
			if(rows != 0)
				System.out.println("更新成功！");
			else
				System.out.println("更新失败！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			myDataSource.backConnection(conn);
			JDBCUtils_v3.release(conn,pstm,null);
		}
	}

}
