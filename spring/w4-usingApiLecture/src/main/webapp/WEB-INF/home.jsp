<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
	<h1>Hello World!</h1>
	<h3>${actualObj.get("totalResults")}</h3>
	<h3>${articles.size()}</h3>
	
	<ol>
		<c:forEach begin="0" end="${articles.size() -1}" var="i">
     			<li>${articles.get(i).get("title")}</li>
				 <li><img src=${articles.get(i).get("urlToImage")} alt=""></li>
				 <p>${articles.get(i).get("urlToImage")}</p>
		</c:forEach>

	</ol>
</body>
</html>