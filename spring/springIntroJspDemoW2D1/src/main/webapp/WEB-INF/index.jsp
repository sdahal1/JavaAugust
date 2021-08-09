<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World with the JSP template thooo!</h1>
	<h3>Hello ${n}</h3>
	<p>A Sensei with ${numberOfBelts} belts</p>
	<h1>${favArtists}</h1>
	
	<c:out value="${2+2}"/>
	
	<c:forEach var="artist" items="${favArtists}">
            <p><c:out value="${artist}"></c:out></p>
     </c:forEach>
     
     
</body>
</html>