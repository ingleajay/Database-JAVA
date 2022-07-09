<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="google-signin-client_id"
	content="894727450578-oll9m0c12qj31n873rt8t22s9q4lqhgp.apps.googleusercontent.com">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script src="https://apis.google.com/js/platform.js?onload=onLoad" async
	defer></script>
<title>Welcome</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8 offset-md-2">
						<img src="backtodo.jpeg" class="img-fluid mt-4">
			
				<div class="login-form bg-light mt-4 p-4"
					style="box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);">
					<%@include file="navbar.jsp"%>
					<div class="text-center mt-2"></div>
					<div class="card">
					<%
					int task_id = Integer.parseInt(request.getParameter("task_id").trim());
					Session u1 = FactoryProvider.getFactory().openSession();
					Todo i = u1.get(Todo.class, task_id);
					%>
  <div class="card-body">
  <form action="edit" method="post">
  <div class="row">
    <input type="hidden" name="task_id" value="<%= i.getTid() %>" >
    <div class="col-5">
      <input type="text" class="form-control"  name="tname" value="<%= i.getTname() %>" >
    </div>
    <div class="col-4">
      <input type="date" class="form-control"  name="tdate" value="<%= i.getTaskDate() %>">
    </div>
    <div class="col-3">
    <button type="submit" class="btn btn-info">Update Task</button>
    </div>
  </div>
</form>
  </div>
</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="modalhistroy.jsp" %>
	<%@include file="modalprofile.jsp" %>
	<script type="text/javascript" src="logout.js"></script>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>