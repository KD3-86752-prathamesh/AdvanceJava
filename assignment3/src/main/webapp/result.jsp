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

<jsp:useBean  id="rb" class="com.sunbeam.beans.ResultBean" /> 

<jsp:setProperty property="candId" name="rb" value="${ub.user.id }"/>
${rb.getResult() }
<table border="1" >

<tr>
		<th>id</th>
		<th>Name</th>
		<th>Party</th>
		<th>Votes</th>
		<th>Action</th>
</tr>

<c:forEach var="c" items="${rb.candList }">


		<tr>
		<td>${c.id }</td>
		<td>${c.name }</td>
		<td>${c.party }</td>
		<td>${c.votes }</td>
		<td>
			<a href="edit.jsp"><img src="images/edit.png" width="20" height="20"/></a> 
			<a href="delete.jsp"> <img src="images/delete.png" width="20" height="20"/>   </a>
		</td></tr>


</c:forEach>

</table>
<a href="logout.jsp">logout</a>


</body>
</html>