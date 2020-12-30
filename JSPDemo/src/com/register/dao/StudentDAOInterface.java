package com.register.dao;

import java.util.List;

import com.register.exception.daoException.DaoException;
import com.register.model.Student;

public interface StudentDAOInterface {
	public List<String> getYear(int courseid) throws DaoException;
	public String register(Student  student) throws DaoException;

}
