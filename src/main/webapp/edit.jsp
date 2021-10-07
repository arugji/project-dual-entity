<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Candy CRUD Operation</title>
</head>
<body>
	<h1>Edit Candy Details</h1>
	<form action="SaveData" method="post">
		<input type="hidden" name="id" value="${candy.id}"> Name: <input
			type="text" name="name" value="${candy.name}"> Colour: <input
			type="text" name="colour" value="${candy.colour}"> <input
			type="submit" value="Save"> <br />
	</form>
	<br />
	<br />
	<br />
	<a href="ViewAllNameServlet">View the complete list</a>
</body>
</html>