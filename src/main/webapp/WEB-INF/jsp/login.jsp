<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ChatSpringBoot | Login</title>
</head>
<body>
	<div class="container">
		<h1>Login</h1>
		<form:form action="/login" method="post">
			<div class="form-group" style="margin-bottom: 5px;">
				<label for="username"></label>
				<input type="text" id="username" name="username" placeholder="Enter username" />
			</div>
			<div class="form-group" style="margin-bottom: 5px;">
				<label for="password"></label>
				<input type="password" id="password" name="password" placeholder="Enter password" />
			</div>
			<c:if test="${not empty errmsg}">
			<div class="form-group">
				<p style="color: red;">${errmsg}</p>
			</div>
			</c:if>
			<div class="form-group">
				<button type="submit">Login</button>
			</div>
		</form:form>
	</div>
	
	<footer style="margin-top: 20px;"><a href="/">ChatSpringBoot</a> &copy; 2024. Made with love in Machang.</footer>
</body>
</html>