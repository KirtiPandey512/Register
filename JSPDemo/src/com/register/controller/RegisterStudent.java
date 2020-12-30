package com.register.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.exception.service.ServiceException;
import com.register.model.Student;
import com.register.service.StudentService;
import com.register.service.StudentServiceInterface;

public class RegisterStudent extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		StudentServiceInterface serviceInterface=new StudentService();
		Student student=new Student();
		String name=req.getParameter("name");
		String mail=req.getParameter("mail");
		String mob=req.getParameter("mob");
		String pass=req.getParameter("pass");
		String course=req.getParameter("course");
		String year=req.getParameter("year");
		student.setCourse(course);
		student.setMail(mail);
		student.setMob(mob);
		student.setName(name);
		student.setPass(pass);
		student.setYear(year);
		String str;
		try {
			str = serviceInterface.register(student);
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		RequestDispatcher dispatcher=req.getRequestDispatcher("/Success.html");
		try {
			dispatcher.include(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
