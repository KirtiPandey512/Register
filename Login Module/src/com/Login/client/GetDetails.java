package com.Login.client;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Login.DAO.LoginDAOImpl;
import com.Login.Service.LoginServiceImpl;
import com.Login.Service.LoginServiceInterface;
import com.Login.entity.User;

public class GetDetails extends HttpServlet{	
	public void service (HttpServletRequest req,HttpServletResponse res)
	{
		String name=req.getParameter("usn");
		String pass=req.getParameter("pass");
		User user =new User();
		user.setName(name);
		user.setPassword(pass);
		LoginServiceInterface interface1=new LoginServiceImpl();
		try {
			if(interface1.isValid(user)==true)
			{
				RequestDispatcher dispatcher=req.getRequestDispatcher("/success.html");
				dispatcher.include(req, res);
			}
			else
			{
				RequestDispatcher dispatcher=req.getRequestDispatcher("/error.html");
				dispatcher.include(req, res);
			}
		} catch (SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
