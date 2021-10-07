<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Candy CRUD Operation</title>
</head>
<body>
	<h1>Add Company For ${name}</h1>
	<form action="SaveCompanyData" method="post">
		<input type="hidden" name="candyId" value="${candyId}"> <input
			type="hidden" name="id" value="0"> Company Name: <input
			type="text" name="name"> <input type="submit" value="Save">
		<br />
	</form>
	<br />
	<br />
	<br />
	<a href="ViewAllNameServlet">View the complete list</a>
</body>
</html>