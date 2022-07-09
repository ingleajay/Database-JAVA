<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id"
     content="894727450578-oll9m0c12qj31n873rt8t22s9q4lqhgp.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js" async defer></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Login</title>
</head>
<body>
<div class="container">
   <div class="row">
     <div class="col-md-4 offset-md-4 mt-4">
       <div class="card" style=" box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);">
       <div class="login-form bg-white mt-4 p-4">
     <h4 class="text-center">Please Login Yourself</h4>
        <div class="row justify-content-center">
   	   <img id="image-1" alt="todo" src="todo.png" class="img-fluid" height="400px"/>
   </div>
   <div class="col-12 text-center " style="margin-top:19px;">
        	<div class="g-signin2" data-onsuccess="onSignIn" align="center"></div>
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
	 <script type="text/javascript" src="login.js"></script>
</body>
</html>