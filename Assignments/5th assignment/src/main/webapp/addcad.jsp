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


<jsp:useBean id="ad" class="beans.addCandidate"></jsp:useBean>
<jsp:setProperty name="ad" property="name" param="name"/>
<jsp:setProperty name="ad" property="party" param="party"/>

${ad.addCandidate()}
<c:choose>
<c:when test="${ad.res==1}">
<jsp:forward page="result.jsp"></jsp:forward>
		
</c:when>
<c:otherwise>
<jsp:forward page="result.jsp"></jsp:forward>

Adding Failed
</c:otherwise>
</c:choose>
</body>
</html>