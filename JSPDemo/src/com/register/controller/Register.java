package com.register.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.exception.service.ServiceException;
import com.register.model.Student;
import com.register.service.StudentService;
import com.register.service.StudentServiceInterface;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html;charset=UTF-8");
		doGet(req, res);
		
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
			System.out.println(str);
			 PrintWriter out = res.getWriter();
			 out.print(
                     "<h1>"+"Successfully Registered"+"</h1>"
                 );
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*try {
			RequestDispatcher dispatcher=req.getRequestDispatcher("/Success.html");
			dispatcher.include(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
