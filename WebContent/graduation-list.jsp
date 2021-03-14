<!--  
/**
 * @author Tom Sorteberg - tsorteberg
 * @author Levi Olson - lolson17
 * CIS175 - Spring 2021
 * Mar 9, 2021
 */
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Graduation List</title>
</head>
<body>
	<h1>Graduation List</h1>
	<h2>All Courses:</h2>
	<form method="post" action="NavigationServlet">
		<table>
			<tr>
				<th></th>
				<th>Course Name:</th>
				<th>Start Date:</th>
				<th>Credits:</th>
				<th>Instructor:</th>
			</tr>
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<tr>
					<td><input type="radio" name="id" value="${currentitem.id}"></td>
					<td>${currentitem.courseName}</td>
					<td>${currentitem.startDate}</td>
					<td>${currentitem.credits}</td>
					<td>${currentitem.instructor.firstName} ${currentitem.instructor.lastName}</td>
					<td></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Delete:" name="doThisToItem">
		<input type="submit" value="Add:" name="doThisToItem">
		<input type="submit" value="Edit:" name="doThisToItem">
		<input type="submit" value="Go to homepage:" name="doThisToItem">
	</form>
</body>
</html>