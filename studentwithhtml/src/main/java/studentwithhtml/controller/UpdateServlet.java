package studentwithhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtml.dto.Student;
import studentwithhtml.dao.StudentDao;

public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String password=req.getParameter("password"); 
		long phone=Long.parseLong(req.getParameter("phone"));
		int id=Integer.parseInt(req.getParameter("id"));
		
		Student student=new Student();
		student.setAddress(address);
		student.setEmail(email);
		student.setName(name);
		student.setPassword(password); 
		student.setPhone(phone);
		
		
		
		
		PrintWriter printwriter=resp.getWriter();
		StudentDao dao=new StudentDao();
		Student dbStudent=dao.updateStudent(id, student);
		if(dbStudent!=null) {
		//updated successfully
		printwriter.print("Upodated successfullly");
		
		}else {
			printwriter.print("Sorry Id is not present");

		}
		
		
	}
	

}
