<%@page import="com.sunbeam.beans.ResultBean"%>
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

<h2>Happy voting</h2>

<jsp:useBean id="clb" class="com.sunbeam.beans.ResultBean"></jsp:useBean>
<jsp:setProperty property="candId" name="clb"  value= "${ub.user.id }"/> 
${clb.getResult() }




<form action="vote.jsp" method="post" > 

<c:forEach var="li" items="${clb.candList }">
<input type="radio"  name="candidate" value="${li.id }"/>${li.name } - ${li.party } <br/>
</c:forEach>
<br/>
<input type= "submit" value ="vote"/> 
</form>


</body>
</html>