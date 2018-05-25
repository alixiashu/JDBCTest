package com.jdbc.alixia.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.jdbc.alixia.utils.DBCPUtils;
import com.jdbc.alixia.utils.JDBCUtils_v3;

public class TestDBCP {
	
	@Test
	public void testAddUser() {
		Connection conn = null;
		PreparedStatement  prpsm = null;
		
		try {
			conn = DBCPUtils.getConnection();
			String sql = "insert into tbl_users values(null,?,?)";
			prpsm = conn.prepareStatement(sql);
			prpsm.setString(1, "dbup");
			prpsm.setString(2, "utils");
			int rows = prpsm.executeUpdate();
			if(rows != 0)
				System.out.println("更新成功！");
			else
				System.out.println("更新失败！");
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils_v3.release(conn, prpsm, null);
		}
	}
	

}
