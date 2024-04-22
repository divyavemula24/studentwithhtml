package studentwithhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import studentwithhtml.dto.Student;
import studentwithhtml.dao.StudentDao;

public class SignUpServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone"));
		
		
		
		
		

		
		Student  student=new Student();
		student.setAddress(address);
		student.setEmail(email);
		student.setName(name);
		student.setPassword(password);
		student.setPhone(phone);
		
		StudentDao dao=new StudentDao();
		dao.saveStudent(student);
		
		
		PrintWriter printWriter=res.getWriter();
		printWriter.print("SignedUp Successfully Please Login");
		RequestDispatcher dispatcher=req.getRequestDispatcher("loginn.html"); 
		dispatcher.include(req, res);
		
		
	}	
	}

	

