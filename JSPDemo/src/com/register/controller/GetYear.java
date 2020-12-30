package com.register.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.dao.StudentDAO;
import com.register.dao.StudentDAOInterface;
import com.register.service.StudentService;
import com.register.service.StudentServiceInterface;


/**
 * Servlet implementation class GetYear
 */
@WebServlet("/GetYear")
public class GetYear extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetYear() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
	        try {
	            int courseid = Integer.parseInt(request.getParameter("datapost"));
	            StudentServiceInterface userdao=new StudentService();
	            List<String> years=userdao.getYear(courseid);
	            switch (courseid) {
	                case 1: 
	                {
	                	for(int i=0;i<years.size();i++)
	                	{
	                    out.print(
	                        "<option value="+years.get(i)+">"+years.get(i)+"</option>"
	                    );
	                	}
	                    break;
	                }
	                case 2:  
	                {
	                	for(int i=0;i<years.size();i++)
	                	{
	                    out.print(
	                        "<option value="+years.get(i)+">"+years.get(i)+"</option>"
	                    );
	                	}
	                    break;
	                }
	                case 3:  
	                {
	                	for(int i=0;i<years.size();i++)
	                	{
	                    out.print(
	                        "<option value="+years.get(i)+">"+years.get(i)+"</option>"
	                    );
	                	}
	                    break;
	                }
	                case 4:  
	                {
	                	for(int i=0;i<years.size();i++)
	                	{
	                    out.print(
	                        "<option value="+years.get(i)+">"+years.get(i)+"</option>"
	                    );
	                	}
	                    break;
	                }
	            }
	        }
	          catch (Exception ex) {
	            out.print("Error getting Year..." + ex.toString());
	        }
	        finally {
	            out.close();
	        }
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
