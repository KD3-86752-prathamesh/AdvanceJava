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

<h4>hello :)</h4>
<br/> 
<br/> 

<jsp:useBean id="ub" class="com.sunbeam.beans.LoginBean" scope="session"/>
<jsp:setProperty property="*" name="ub" /> 

${ub.loginUser() }
<c:choose>
	<c:when test="${ub.success}">
	<c:choose>
	<c:when test="${ub.user.role=='admin'}"> <jsp:forward page="result.jsp"></jsp:forward></c:when>
	<c:otherwise> <jsp:forward page="candiList.jsp"></jsp:forward></c:otherwise>
</c:choose>
	</c:when>
	<c:otherwise>
	something went wrong :(
	</c:otherwise>
</c:choose>

</body>
</html>