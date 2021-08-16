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
	<h1>Info about this group: ${group.name}</h1>
	<p>Description: ${group.description}</p>
	<p>Group Members:</p>
	<ul>
		<c:forEach items='${ group.members }' var='user'>
			<li>${user.name}</li>
		</c:forEach>
	</ul>

	<h3>Add some members to this group!</h3>
	<form action="/addMembers/${group.id}" method="post">
		<select name="userId" id="">
			<c:forEach items='${ allUsers }' var='user'>
				<option value="${user.id}">${user.name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Add Member to group!">
	</form>

</body>
</html>