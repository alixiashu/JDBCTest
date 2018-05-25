package com.jdbc.alixia.utils;

import java.sql.Connection;
import java.sql.SQLException;


import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("oracle");
	
	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}
	
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
