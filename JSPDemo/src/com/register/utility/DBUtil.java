package com.register.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.register.exception.daoException.DataBaseConnectionFailedException;

public class DBUtil {
	private final String url="jdbc:mysql://localhost:3306/";
	private final String db="Student";
	private final String user="root";
	private final String pass="";
	public Connection createConnection() 
	{
		Connection conn=null;
		try {
			 conn=DriverManager.getConnection(url+db,user,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		return conn;
		
	}
	public void closeResources(Connection conn) throws DataBaseConnectionFailedException
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DataBaseConnectionFailedException(e);
		}
	}
	public void closeResources(PreparedStatement ps) throws DataBaseConnectionFailedException
	{
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DataBaseConnectionFailedException(e);
		}
	}
	public void closeResources(ResultSet rs) throws DataBaseConnectionFailedException
	{
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DataBaseConnectionFailedException(e);
		}
	}

}
