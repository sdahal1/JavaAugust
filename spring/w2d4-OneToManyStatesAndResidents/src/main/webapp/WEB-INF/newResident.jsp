<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Create a new resident below</h1>
		
		<form:form action="/resident/create" method="post" modelAttribute = "resident">
			<div class="form-group">
				<form:label path="name">Name</form:label>
				<form:errors path="name" class ="text-danger"/>
				<form:input type= "text" path="name" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="age">Age</form:label>
				<form:errors path="age" class ="text-danger"/>
				<form:input type="number" path="age" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="state">State</form:label>
				<form:errors path="state" class ="text-danger"/>
				<form:select path="state" class="form-select">
					<c:forEach items='${ allStates }' var='state'>
						<option value="${state.id}">${state.name}</option>
					</c:forEach>
					
				</form:select>
				
			</div>


			<input type="submit" value="Submit!">
		</form:form>
	</div>
</body>
</html>