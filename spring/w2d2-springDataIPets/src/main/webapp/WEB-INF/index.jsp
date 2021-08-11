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
	<h1>Hello Pets! Here are all the wonderful pets</h1>

	<p>${allPets}</p>

	<table class="table">
		<thead>
		  <tr>
			<th scope="col">ID</th>
			<th scope="col">Name</th>
			<th scope="col">Age</th>
			<th scope="col">Description</th>
			<th scope="col">Actions</th>

			
		  </tr>
		</thead>
		<tbody>
		<c:forEach items='${ allPets }' var='p'>	
		  <tr>
			<th scope="row">${p.id}</th>
			<td><a href="/pet/info/${p.id}">${p.name}</a></td>
			<td>${p.age}</td>
			<td>${p.description}</td>
			<td><a href="/pet/edit/${p.id}">Edit</a> | <a href="/pet/delete/${p.id}">Delete Pet</a></td>
		  </tr>
		</c:forEach>
		</tbody>
	  </table>

	  <a href="/pets/new">Add a new Pet</a>

</body>
</html>