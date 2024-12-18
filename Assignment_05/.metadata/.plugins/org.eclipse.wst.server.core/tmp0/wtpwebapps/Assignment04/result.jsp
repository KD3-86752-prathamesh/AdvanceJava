<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ResultList</title>
</head>
<body>
<center>
	<h1>Result table</h1>
	
	<jsp:useBean id="cd" class="com.sunbaeam.jsp.ResultList"></jsp:useBean>
	${cd.getAllCandidate()}
	<table border="2">
			<thead>
			<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Party</th>
			<th>Votes</th>
			<th>Action</th>
			</tr>
			</thead>
			<tbody>
			
			<c:forEach var="c" items="${cd.candlist}">
			
			<tr>
			<td>${c.id}</th>
			<td>${c.name}</th>
			<td>${c.party}</th>
			<td>${c.votes}</th>
			<td>
				<a href="edit.jsp?id=${c.id}">
				<img alt="Edit" src="image/edit.png" width="20" height="20" /></a>
				
				<a href="delete.jsp?id=${c.id}">
				<img alt="Edit" src="image/delete.jpg" width="20" height="20" /></a>
			
			</td>
			</tr>
			
			</c:forEach>
			
			</tbody>
	
	</table>
	
	<p>${param.msg}</p>
	
	<a href="index.jsp"><button> Login </button></a>

</body>
</html>