package studentwithhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtml.dao.StudentDao;
import studentwithhtml.dto.Student;

public class SelectServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	StudentDao dao=new StudentDao();
	Student student=dao.findStudentById(id);
	PrintWriter printWriter=resp.getWriter();
	if(student!=null) {
//		that student is presnet
		printWriter.print(student);
	}else {
//		id is not present
		printWriter.print("Sorry Id is not present");
	}
	
}
}
