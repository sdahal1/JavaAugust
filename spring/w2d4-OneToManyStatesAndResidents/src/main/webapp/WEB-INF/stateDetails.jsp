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
	<h1>Info about the beautiful state of: ${state.name}</h1>
	<p>Description: ${state.description}</p>
	<p>Capital: ${state.capital}</p>
	<p>Animal: ${state.animal}</p>
	<p>Residents: ${state.residents}</p>

	<hr>

	<table class="table table-dark">
		<thead>
		  <tr>
			<th scope="col">ID</th>
			<th scope="col">Name</th>
			
		  </tr>
		</thead>
		<tbody>
			<c:forEach items='${ state.residents }' var='resident'>
				<tr>
					<th scope="row">${resident.id}</th>
					<td>${resident.name}</td>
					
				</tr>
			</c:forEach>
		  
		</tbody>
	  </table>


</body>
</html>