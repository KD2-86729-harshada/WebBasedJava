<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<jsp:useBean id="del" class="beans.deletebin" />
<jsp:setProperty name="del" property="id" param="id" />

${del.delete()}

$<jsp:forward page="result.jsp"/> 


</body>
</html>