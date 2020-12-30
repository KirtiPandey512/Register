package com.register.service;

import java.util.List;

import com.register.dao.StudentDAO;
import com.register.dao.StudentDAOInterface;
import com.register.exception.daoException.DaoException;
import com.register.exception.service.ServiceException;
import com.register.model.Student;



public class StudentService implements StudentServiceInterface{
	StudentDAOInterface studentdao=new StudentDAO();
	
	@Override
	public List<String> getYear(int courseid) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return studentdao.getYear(courseid);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
	}
	@Override
	public String register(Student student) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return studentdao.register(student);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
	}


}
