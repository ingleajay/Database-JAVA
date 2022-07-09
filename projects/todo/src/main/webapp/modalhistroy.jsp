<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.todo.Todo"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.todo.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">History of your
						task :</h5>
				</div>
				<div class="modal-body">
					<div class="row">
						<table class="table">
							<thead class="thead-dark">
								<tr>
									
									<th scope="col">Task Name</th>
									<th scope="col">Date</th>
									<th scope="col">Actions</th>
								</tr>
							</thead>
							<tbody>
							<% Session s = FactoryProvider.getFactory().openSession();
							 String u = session.getAttribute("hash").toString();
							 System.out.println(u);
							  Query q = s.createQuery("from Todo as a where a.user.id=:uid");
							  q.setParameter("uid", u);
							  List<Todo> task = q.list();
							  for(Todo t : task){
							%>
								<tr>
									<td><%= t.getTname() %></td>
									<td><%= t.getTaskDate() %></td>
									<td>
									<a href="edit.jsp?task_id=<%= t.getTid() %>"><button class="btn btn-warning">Edit</button></a>
									
									<a href="delete?t_id=<%= t.getTid() %>"><button class="btn btn-danger">Delete</button></a>
									</td>
								</tr>
								<% } %>
							</tbody>
						</table>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
    