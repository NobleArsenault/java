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
			<p>Name: ${language.name}</p>
			<p>Creator: ${language.creator}</p>
			<p>Version: ${language.version}</p>

			<form:form action="/languages/${id}/edit" method="POST" modelAttribute="language">
				<form:label path="name">Name:
					<form:errors path="name"></form:errors>
						<form:input type="text" path="name"></form:input>
				</form:label>
<Br>
				<form:label path="creator">Creator:
					<form:errors path="creator"></form:errors>
						<form:input type="text" path="creator"></form:input>
				</form:label>
<br>
				<form:label path="version">Version:
					<form:errors path="version"></form:errors>
						<form:input type="number" path="version"></form:input>
				</form:label>
<br>
				<input type="submit" value="Update language">
			</form:form>
	</body>
</html>