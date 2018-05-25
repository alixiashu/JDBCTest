package com.jdbc.alixia.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;

import com.jdbc.alixia.DataSource.MyDataSource;
import com.jdbc.alixia.DataSource.MyDataSource1;
import com.jdbc.alixia.utils.C3P0Utils;
import com.jdbc.alixia.utils.JDBCUtils_v3;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

public class TestC3p0 {

	/**
	 * 添加用户，使用工具类C3P0Utils
	 */
	@Test
	public void testAddUsers() {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			//1、利用工具类从连接池中获取Connection对象
			conn = C3P0Utils.getConnection();
			String sql = "insert into tbl_users values(null,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "zhangsanc3p0");
			pstm.setString(2, "123");
			int rows = pstm.executeUpdate();
			if(rows != 0)
				System.out.println("更新成功！");
			else
				System.out.println("更新失败！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils_v3.release(conn, pstm, null);
		}
	}
	/**
	 * 添加用户，直接使用c3p0
	 */
	@Test
	public void testAdd() {
		Connection conn = null;
		PreparedStatement pstm = null;
		//1、加载默认配置
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		//加载默认带名称配置
//		ComboPooledDataSource dataSource = new ComboPooledDataSource("oracle");
		try {
			
			//2、从连接池中获取Connection对象
			conn = dataSource.getConnection();
			String sql = "insert into tbl_users values(null,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "zhangsanc3p0");
			pstm.setString(2, "123");
			int rows = pstm.executeUpdate();
			if(rows != 0)
				System.out.println("更新成功！");
			else
				System.out.println("更新失败！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils_v3.release(conn, pstm, null);
		}
	}
	

}
