<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h2>List of candidates</h2>

<jsp:useBean id="sd" class="beans.resultbin" />

${sd.fetchCandidates()}
<table border="1">

<thead>
<tr>
  	<th>Sr. </th>
  	<th>Name </th>
  	<th>Party </th>
  	<th>Votes </th>	
  	<th>Action</th>
</tr>
</thead>

<tbody>

<c:forEach var="s" items="${sd.candList}">

	<tr>
	   <td>${s.id}</td>
	   <td>${s.name}</td>
	   <td>${s.party}</td>
	   <td>${s.votes}</td>

	   <td>
	    <button ><a href="editcand.jsp?id=${s.id}">Edit</a></button>
	   <button> <a href="delete.jsp?id=${s.id}"> Delete</a></button>
	  
	   
	   
	   </td>
	   
	    
	   
	</tr>
</c:forEach>
</tbody>
</table>

<p>${param.msg}</p>
	<p>
	<a href="logout.jsp">Sign Out</a>
	<a href="AddCandidate.jsp">Add Candidate</a>
	</p>
</body>
</html>