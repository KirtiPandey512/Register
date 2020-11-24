package com.Login.DAO;

import java.sql.SQLException;

import com.Login.entity.User;

public interface LoginDAOInterface {
	public boolean isValid(User user) throws SQLException;
}
