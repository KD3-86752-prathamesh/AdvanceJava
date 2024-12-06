<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="vb" class="com.sunbeam.beans.VoteBean"></jsp:useBean>
<jsp:setProperty  property ="candidate" name= "vb" param = "candidate"/> 
<jsp:setProperty property= "userId" name = "vb"  value = "${ub.user.id}"/>

${vb.doVote() }

<c:choose>
<c:when test = "${ub.user.status == 0 }"></c:when>
${vb.doVote() }

</c:choose> 


</body>
</html>