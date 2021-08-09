<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body onload="sendCustomAlert('okayyyy den')">
	<script src="/js/appointment.js"></script>
	<h1>Schedule an appointment for today, which is: ${today}</h1>
	<form action="/createAppointment" method="post">
		<div class= "form-group">
			<label for="">First Name: </label>
			<input class = "form-control" type="text" name="firstname" id="" />
		</div>
		<div>
			<label for="">What do you want to talk about?</label>
			<textarea name="topic" id="" cols="30" rows="10"></textarea>
		</div>
		<div>
			<label for="">Select the language you need help with:</label>
			<select name="language" id="">
				<option value="python">Python</option>
				<option value="js">JS</option>
				<option value="java">Java</option>
				<option value="html/css">Html/CSS</option>
			</select>
		</div>
		<input class = "btn btn-success" type="submit" value="Make appointment!" />
	</form>
</body>
</html>