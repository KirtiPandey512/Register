package com.Login.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private final String URL="jdbc:mysql://localhost:3306/";
	private final String DB="canteen_data";
	private final String USER_NAME="root";
	private final String PASSWORD="";
	public DBUtil() {
		// TODO Auto-generated constructor stub
	}
	public Connection createConnection() throws SQLException
	{
		Connection conn=null;
		 
			conn= DriverManager.getConnection(URL+DB,USER_NAME,PASSWORD);
		
		return conn;
	}
	public void closeResources(Connection conn)
	{
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void closeResources(PreparedStatement ps)
	{
		if(ps!=null)
		{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void closeResources(ResultSet rs)
	{
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
