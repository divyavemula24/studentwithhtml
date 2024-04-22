package studentwithhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import studentwithhtml.dto.Student;
import studentwithhtml.dao.StudentDao;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");


		StudentDao dao=new StudentDao();
		List<Student> students=dao.getAllStudents();

		boolean value=false;
		String dbPassword=null;

		for(Student student:students ) {
			if(email.equals(student.getEmail())) {
//				student is present with this email
				value=true;
				dbPassword=student.getPassword();
				break;
			}
		}
		PrintWriter printWriter=resp.getWriter();

//		if(value) {
////			value=true 
////			Email is present in the db then the student is present inthis email
////			now i want to check password
//			if(password.equals(dbPassword)) {
////				loginsuccess
////				it is a perfect email and perfect password
//				printWriter.print("LOGINSUCCESSS");
//			}else {
////				it is a perfect email but invalid password
//				printWriter.print("Sorry Invalid Password");
//			}
//		}else {
////			value=false
////			email is not present
//			printWriter.print("Sorry Invalid Email");
//		}

		
		if(value) {
		if(password.equals(dbPassword)) {

			//loginsuccess
			//	it is a perfect email and perfect password 
//			RequestDispatcher dispatcher=req.getRequestDispatcher("select.html");
//			dispatcher.forward(req, resp);
			resp.sendRedirect("https://www.javatpoint.com/");
			}
		else {
			//			it is a perfect email but invalid passwrd

			RequestDispatcher dispatcher=req.getRequestDispatcher("loginn.html"); 
			dispatcher.include(req, resp);
			}
			}
	      else {
			//value=false
			//	email is not present
			RequestDispatcher dispatcher=req.getRequestDispatcher("loginn.html");
			dispatcher.include(req, resp);
			}

	}




	
	
}