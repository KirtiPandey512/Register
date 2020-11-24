package com.Login.Service;

import java.sql.SQLException;

import com.Login.DAO.LoginDAOImpl;
import com.Login.entity.User;

public class LoginServiceImpl implements LoginServiceInterface{

	@Override
	public boolean isValid(User user) throws SQLException {
		// TODO Auto-generated method stub
		LoginDAOImpl daoImpl=new LoginDAOImpl();
		return daoImpl.isValid(user);
		
	}

}
