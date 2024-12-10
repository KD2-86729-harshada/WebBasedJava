<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Thank you</h3>
<%session.invalidate(); %>
<p>You are successfully logged out</p>

<a href="index.jsp">Login again</a>
</body>
</html>