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

<h2>Voting Result</h2>

<jsp:useBean id="vb" class="beans.votebin" />

<jsp:setProperty name="vb" property="candid" param="candidate"/>
<jsp:setProperty name="vb" property="userid" value="${lb.user.id}" />

<c:choose>
<c:when test="${lb.user.status==0}">
		${vb.vote()}
   		<c:choose>
    		 <c:when test="${vb.result}" >
     				<p>You have successfully Voted ...... :)</p>
     				${lb.user.setStatus(1)}
    		 </c:when>
    		 <c:otherwise>
     				<p>Your voting attempt failed</p>
			</c:otherwise>
		</c:choose>  
			</c:when>   
		<c:otherwise>
					<p>You are already Voted</p>
		</c:otherwise>
</c:choose>
<a href="logout.jsp">Sign out</a>

</body>
</html>