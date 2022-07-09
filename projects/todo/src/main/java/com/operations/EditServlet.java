package com.operations;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.loggeduser.User;
import com.todo.ServicesImpl;
import com.todo.Todo;

@WebServlet("/edit")
public class EditServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int task_id = Integer.parseInt(req.getParameter("task_id").trim());
		String tname = req.getParameter("tname");
		String tdate = req.getParameter("tdate");
		HttpSession s = req.getSession();
		String uid = s.getAttribute("hash").toString();
		User u = new User();
		u.setId(uid);
		Todo t = null;
		try {
			Date d = new SimpleDateFormat("yyyy-MM-dd").parse(tdate);
			t = new Todo(task_id, tname,d,u);
			System.out.println(t.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean result = new ServicesImpl().updatetask(task_id,t);
		if(result == true) {
			resp.sendRedirect("/todo/message.jsp?status="+"edit");
		}
	}
}
