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

	
		<h1>Hello World- Welcome to the one to many lecture!</h1>
		<a href="/residents/new">Create a new resident</a>

		<table class="table table-dark">
			<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Name</th>
				<th scope="col">Description</th>
				<th scope="col">Capital</th>
				<th scope="col">Animal</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach items='${ allStates }' var='state'>
					<tr>
						<th scope="row">${state.id}</th>
						<td><a href="/state/${state.id}">${state.name}</a></td>
						<td>${state.description}</td>
						<td>${state.capital}</td>
						<td>${state.animal}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<hr>
		<h3>Add a new state</h3>
		<form:form action="/state/create" method="post" modelAttribute = "state">
			<div class="form-group">
				<form:label path="name">Name</form:label>
				<form:errors path="name" class ="text-danger"/>
				<form:input type= "text" path="name" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="description">Description</form:label>
				<form:errors path="description" class ="text-danger"/>
				<form:textarea path="description" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="capital">Capital</form:label>
				<form:errors path="capital" class ="text-danger"/>
				<form:input type= "text" path="capital" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="animal">State Animal</form:label>
				<form:errors path="animal" class ="text-danger"/>
				<form:input type= "text" path="animal" class="form-control"/>
			</div>
			<input type="submit" value="Submit!">
		</form:form>
		

	</div>
	
</body>
</html>