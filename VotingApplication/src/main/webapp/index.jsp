<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voting Application</title>
</head>
<body>
	<h2>Login</h2>
	
	<form method="get" action="login" >
		
		Email : <input type="text" name="email"/> <br>  <br>
		Password : <input type="password" name="passwd"/>  <br> <br>
		
		<input type="submit" name="Sign In"/>
		<p>
			<a href="newuser.jsp" >Sign Up</a>
		</p>
	</form>
</body>
</html>