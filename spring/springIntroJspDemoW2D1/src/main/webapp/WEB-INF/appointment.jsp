<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Schedule an appointment for today, which is: ${today}</h1>
	<form action="/createAppointment" method="post">
		<div>
			<label for="">First Name: </label>
			<input type="text" name="firstname" id="" />
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
		<input type="submit" value="Make appointment!" />
	</form>
</body>
</html>