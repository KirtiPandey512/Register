package com.Login.Service;

import java.sql.SQLException;

import com.Login.entity.User;

public interface LoginServiceInterface {
	public boolean isValid(User user) throws SQLException;

}
