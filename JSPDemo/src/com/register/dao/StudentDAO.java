package com.register.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.register.exception.StudentException;
import com.register.exception.daoException.DaoException;
import com.register.exception.daoException.DataBaseConnectionFailedException;
import com.register.model.Student;
import com.register.utility.DBUtil;



public class StudentDAO implements StudentDAOInterface{

	DBUtil dbUtil=new  DBUtil();
	@Override
	public List<String> getYear(int courseid) throws DaoException {
		// TODO Auto-generated method stub
		List<String> years=new ArrayList<String>();
		Connection conn=null;
		try {
			 conn=dbUtil.createConnection();
				
			ResultSet rs=null;
			Statement st=null;
			String query="select year from year where cid="+courseid;
			try {
				st=conn.createStatement();
				rs=st.executeQuery(query);
				while(rs.next())
				{
					String year=rs.getString(1);
					years.add(year);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DaoException(e);
			}
			finally
			{
			dbUtil.closeResources(rs);
			dbUtil.closeResources(conn);
			}
		} catch (DataBaseConnectionFailedException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);
		}
		return years;
	}
	@Override
	public String register(Student student) throws DaoException {
		// TODO Auto-generated method stub
		String str="Student not inserted";
		Connection conn=null;
		try {
			 conn=dbUtil.createConnection();
				
			
			PreparedStatement ps=null;
			String query="insert into register values(?,?,?,?,?,?)";
			try {
				ps=conn.prepareStatement(query);
				ps.setString(1, student.getName());
				ps.setString(2, student.getMob());
				ps.setString(3, student.getMail());
				ps.setString(4, student.getCourse());
				ps.setString(5, student.getYear());
				ps.setString(6, student.getPass());
				ps.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DaoException(e);
			}
			finally
			{
			dbUtil.closeResources(ps);
			dbUtil.closeResources(conn);
			}
		} catch (DataBaseConnectionFailedException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);
		}
		return str;
		
	}
	

}
