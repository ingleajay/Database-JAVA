<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Message</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-4 mt-4">
				<div class="card"
					style="box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);">
					<div class="login-form bg-white mt-4 ">
					
                        <%
                        String status = request.getParameter("status");
                        System.out.println(status);
                        
                        %>
                       
						<div class="col-12 text-center" style="margin-top: 10px;">
							<div class="alert alert-success alert-dismissible fade show"
								role="alert">
								 <% if(status.equals("add") ){
									
                                  %>
								<strong>Your Task Added Successfully !</strong>
								 <% 
								  System.out.println(status);
								 } %>
								 <% if(status.equals("del") ){
                                  %>
                                  <strong>Your Task Deleted Successfully !</strong>
								 <% 
								 System.out.println(status);
								 } %>
								  <% if(status.equals("edit") ){
									
                                  %>
								<strong>Your Task Updated Successfully !</strong>
								 <% 
								  System.out.println(status);
								 } %>
								<a href="welcome-page.jsp"><button class="btn btn-primary" >Go back</button></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
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