package com.jdbc.alixia.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtils {
	private static DataSource dataSource;
	static {
		
		try {
			//1、加载properties文件输入流
			InputStream iS = ClassLoader.getSystemResourceAsStream("db.properties");
			//2、读入properties内容
			Properties props = new Properties();
			props.load(iS);
			//3、创建数据连接池
			dataSource = BasicDataSourceFactory.createDataSource(props);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
