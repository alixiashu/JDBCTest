package com.jdbc.alixia.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.jdbc.alixia.domain.User;
import com.jdbc.alixia.utils.C3P0Utils;

public class TestDBUtils1 {
	/**
	 * 查询所有用户信息
	 */
	@Test
	public void testGetAllUser() {
		
		try {
			//1、创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			//2、编写sql语句
			String sql = "select * from tbl_users";
			//3、执行查询操作
			List<User> users = qr.query(sql, new BeanListHandler<User>(User.class));
			for (User user : users) {
				System.out.println(user.getUid() + " : " + user.getUname() + " : " + user.getUpassword());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	/**
	 * 查询所有用户信息,使用MapListHandler
	 */
	@Test
	public void testGetAllUserMap() {
		
		try {
			//1、创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			//2、编写sql语句
			String sql = "select * from tbl_users";
			//3、执行查询操作
			List<Map<String, Object>> users = qr.query(sql, new MapListHandler());
			for (Map<String, Object> user : users) {
				System.out.println(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	/**
	 * 查询所有用户信息,使用ColumnListHandler
	 */
	@Test
	public void testGetAllUserColumn() {
		
		try {
			//1、创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			//2、编写sql语句
			String sql = "select * from tbl_users";
			//3、执行查询操作
			List<Object> users = qr.query(sql, new ColumnListHandler("uname"));
			for (Object user : users) {
				System.out.println(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 根据id查询单个用户信息
	 */
	@Test
	public void testGetUserById() {
		
		try {
			//1、创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			//2、编写sql语句
			String sql = "select * from tbl_users where uid = ?";
			//3、设置占位符
			Object[] param = {18};
			//4、执行查询操作
			User user = qr.query(sql,new BeanHandler<User>(User.class),param);
			System.out.println(user.getUname() + " : " + user.getUpassword());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	/**
	 * 查询用户个数
	 */
	@Test
	public void testGetUserCount() {
		
		try {
			//1、创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			//2、编写sql语句
			String sql = "select count(*) from tbl_users";
			//3、执行查询操作
			Long count = (Long) qr.query(sql,new ScalarHandler());
			System.out.println(count);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
