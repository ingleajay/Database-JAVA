package com.operations;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todo.ServicesImpl;
import com.todo.Todo;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int task_id = Integer.parseInt(req.getParameter("t_id").trim());
		System.out.println(task_id);
		boolean result = new ServicesImpl().deletetask(task_id);
		if(result == true) {
			resp.sendRedirect("/todo/message.jsp?status="+"del");
		}
	}
}
