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
		<table>
			<tr>
				<th>Name:</th>
				<th>Creator:</th>
				<th>Version:</th>
				<th>Action:</th>
			</tr>

		<c:forEach items="${languages}" var="lang">

			<tr>
				<td><a href="/languages/${lang.id}">${ lang.name }</a></td>
				<td>${ lang.creator }</td>
				<td>${ lang.version }</td>
				<td>

					<form action="/languages/${lang.id}/delete" method="POST">
						<input type="submit" value="delete">
					</form>

					<form action="/languages/${lang.id}/edit">
						<input type="submit" value="edit">
					</form>
				</td>

			</tr>
		</c:forEach>
		</table>


			<form:form action="/languages" method="POST" modelAttribute="language">
				<form:label path="name">
					<form:errors path="name"></form:errors>
						<form:input type="text" path="name"></form:input>
				</form:label>

				<form:label path="creator">
					<form:errors path="creator"></form:errors>
						<form:input type="text" path="creator"></form:input>
				</form:label>

				<form:label path="version">
					<form:errors path="version"></form:errors>
						<form:input type="number" path="version"></form:input>
				</form:label>
				
				<input type="submit" value="Create language">
			</form:form>

	</body>
</html>