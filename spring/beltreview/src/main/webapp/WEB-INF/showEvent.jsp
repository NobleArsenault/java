<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<h1>${event.name}</h1>


		<p>Date: ${event.date}</p>
		<p>Location: ${event.city}, ${event.state}</p>
		<p>People Attending: ${event.users.size()}</p>

		<table>
			<tr>
				<th>Name: </th>
				<th>Location: </th>

			</tr>

			<c:forEach items="${event.users}" var="user">
			<tr>
				<td>${user.name}</td>
				<td>${user.city}, ${user.state}</td>
			</tr>
			</c:forEach>
		</table>

		<h1>Message Wall:</h1>

			<c:forEach items="${event.messages}" var="messagess">
				<p>${messagess.text}</p>
			</c:forEach>


		<form:form action="/events/${event.id}/messages/new" method="POST" modelAttribute="message">
			<form:label path="text">Add Comment:
				<form:errors path="text"></form:errors>
				<form:input path="text"></form:input>
			</form:label>
			<input type="submit" value="Post Message">
		</form:form>
	</body>
</html>