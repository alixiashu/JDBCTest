package com.jdbc.alixia.DataSource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.jdbc.alixia.utils.JDBCUtils_v3;
/**
 * 放入连接池经过改造的Connection
 * @author alixia
 *
 */
public class MyDataSource1 implements DataSource{
	//1、创建一个容器用于储存Connection对象
	private static LinkedList<Connection> pool = new LinkedList<>();
	//2、创建5个Connection放到连接池里去
	static {
		for (int i = 0; i < 5; i++) {
			Connection conn = JDBCUtils_v3.getConnection();
			MyConnection myConn = new MyConnection(conn, pool); 
			pool.add(myConn);
		}
	}
	/**
	 * 重写连接获取对象
	 */
	@Override
	public Connection getConnection() throws SQLException {
		//3、判断连接池里是否还有连接
		if(pool.size() == 0) {
			//4、连接池空了再放一些进去
			for (int i = 0; i < 5; i++) {
				Connection conn = JDBCUtils_v3.getConnection();
				MyConnection myConn = new MyConnection(conn, pool); 
				pool.add(myConn);
			}
		}
		//5、从连接池里获取一个连接对象并删除
		return pool.removeFirst();
	}
	
//	/** 替换为MyConnection里的增强的close()
//	 * 归还连接对象到连接池
//	 */
//	public void backConnection(Connection conn) {
//		pool.add(conn);
//	}

	
	
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
