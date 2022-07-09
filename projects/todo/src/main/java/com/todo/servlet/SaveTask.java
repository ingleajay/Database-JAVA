package com.todo.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.loggeduser.User;
import com.todo.ServicesImpl;
import com.todo.Todo;

@WebServlet("/save")
public class SaveTask extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("working....");
			String tname = req.getParameter("tname");
			String tdate = req.getParameter("tdate");
			HttpSession s = req.getSession();
			String uid = s.getAttribute("hash").toString();
			String uname = s.getAttribute("userName").toString();
			String uimg = s.getAttribute("pic").toString();
			String uemail = s.getAttribute("userEmail").toString();
			User u = new User();
			u.setId(uid);
			u.setImg(uimg);
			u.setUemail(uemail);
			u.setUname(uname);
			
			Todo t = new Todo();
			t.setUser(u);
			t.setTname(tname);
			
			List<Todo> list = new ArrayList<Todo>();
			list.add(t);
			u.setTodo(list);
			
			try {
				t.setTaskDate(new SimpleDateFormat("yyyy-MM-dd").parse(tdate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boolean result = new ServicesImpl().savetask(t);
			if(result == true) {
				resp.sendRedirect("/todo/message.jsp?status="+"add");
			}
			System.out.println(t.getTname() + " " + t.getTaskDate().toString());
	}
}
