<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<h2>Registration</h2>
	<form method="post" action="register">
		First Name : <input type="text" name="firstName"/> <br> <br>
		Last Name : <input type="text" name="lastName"/> <br> <br>
		email : <input type="email" name="email"/> <br> <br>
		password : <input type="password" name="password"/> <br> <br>
		DOB : <input type="date" name="DOB"/> <br> <br>
	
		<input type="submit" name="Sign Up"/>
	</form>
	
	<p>
		<a href="index.html">Sign In</a>
	</p>
</body>
</html>