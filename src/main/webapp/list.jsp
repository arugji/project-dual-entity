<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to CRUD Operation</title>
</head>
<body>
	<h1>All Details</h1>
	<form method="post" action="NavigationServlet">
		<table border="2">
			<thead>
				<tr>
					<th></th>
					<th>Name</th>
					<th>Colour</th>
					<th>Company</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.candyList}" var="c">
					<tr>
						<td><input type="radio" name="id" value="${c.id}"></td>
						<td>${c.name}</td>
						<td>${c.colour}</td>
						<td><c:forEach items="${c.companyDetails}" var="cm">
								<span>${cm.name}</span>
								<br />
							</c:forEach></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br /> <br /> <input type="submit" value="edit" name="btn-op">
		<input type="submit" value="delete" name="btn-op"> <input
			type="submit" value="add" name="btn-op"> <input type="submit"
			value="add-company-details" name="btn-op">
	</form>
</body>
</html>