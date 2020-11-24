package com.Login.DAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Login.entity.User;
import com.Login.utility.DBUtil;

public class LoginDAOImpl implements LoginDAOInterface{
	public boolean isValid(User user) throws SQLException
	{
		boolean b=false;
		DBUtil dbUtil=new DBUtil();
		Connection conn=dbUtil.createConnection();

		String query=("select * from customer where c_mail="+"'"+user.getName()+"'"+"and c_password="+"'"+user.getPassword()+"'");
		ResultSet rs=null;
		Statement st=null;
		try
		{
			st=conn.createStatement();
			rs=st.executeQuery(query);
			while(rs.next())
			{
				b=true;
			}
			return b;
		}
		catch(SQLException ex)
		{
			System.out.print(ex.getMessage());
		}
		finally
		{
			dbUtil.closeResources(rs);
			dbUtil.closeResources(conn);
		}
		return b;
	}
}
