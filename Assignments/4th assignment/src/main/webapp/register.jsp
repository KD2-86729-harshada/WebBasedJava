<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="r" class="beans.registerbin"/>
<jsp:setProperty name="r" property="fname" param="fname" />
<jsp:setProperty name="r" property="lname" param="lname"/>
<jsp:setProperty name="r" property="email" param="email"/>
<jsp:setProperty name="r" property="pass" param="pass" />
<jsp:setProperty name="r" property="dob" param="dob" />


<%-- Result: <jsp:getProperty name="s" property="result" />--%>

${r.adddata()}

 <c:choose>

 <c:when test="${r.result==1}">
<h2> Register Successfully.... :) </h2>

		<a href="index.jsp"/>Login</a>
</c:when>

<c:otherwise>

<h3>registration fail</h3>

</c:otherwise>
</c:choose>
</body>
</html>