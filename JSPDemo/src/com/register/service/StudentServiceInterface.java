package com.register.service;

import java.util.List;

import com.register.exception.service.ServiceException;
import com.register.model.Student;



public interface StudentServiceInterface {
	public List<String> getYear(int courseid) throws ServiceException;
	public String register(Student  student) throws ServiceException;

}
