<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ChatSpringBoot | Chat</title>
</head>
<body>
	<div class="container" style="margin-bottom: 30px;">
		<h1>Hi, ${username}</h1>
		<c:if test="${not empty users}">
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Username</th>
					<th>#action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users}" varStatus="row">
				<tr>
					<td>${row.index+1}</td>
					<td>${user.username}</td>
					<td><a href="/chat/${user.username}">Chat</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
	</div>
	
	<div class="container" style="margin-bottom: 10px;">
		<form:form action="${pageContext.request.contextPath}/logout" method="post">
			<button type="submit">Logout</button>
		</form:form>
	</div>
	<footer><a href="/">ChatSpringBoot</a> &copy; 2024. Made with love in Machang.</footer>
</body>
</html>