package com.jdbc.alixia.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.jdbc.alixia.utils.C3P0Utils;

public class TestDBUtils {
	/**
	 * 添加用户
	 */
	@Test
	public void testAddUser() {
		
		try {
			//1、创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			//2、编写sql语句
			String sql = "insert into tbl_users values(null,?,?)";
			//3、为占位符设置数值
			Object[] params = {"余淮","耿耿"};
			//4、执行添加操作
			int rows = qr.update(sql, params);
			if(rows > 0)
				System.out.println("更新成功！");
			else
				System.out.println("更新失败！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 修改用户信息
	 */
	@Test
	public void testUpdateUser() {
		
		try {
			//1、创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			//2、编写sql语句
			String sql = "update tbl_users set upassword = ? where uid = ?";
			//3、为占位符设置数值
			Object[] params = {"genggeng",18};
			//4、执行添加操作
			int rows = qr.update(sql, params);
			if(rows > 0)
				System.out.println("修改成功！");
			else
				System.out.println("修改失败！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 删除用户
	 */
	@Test
	public void testDeleteUser() {
		
		try {
			//1、创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			//2、编写sql语句
			String sql = "delete from tbl_users where uid = ?";
			//3、为占位符设置数值
			Object[] params = {19};
			//4、执行添加操作
			int rows = qr.update(sql, params);
			if(rows > 0)
				System.out.println("删除成功！");
			else
				System.out.println("删除失败！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
