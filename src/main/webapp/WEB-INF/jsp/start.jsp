<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ChatSpringBoot | Start</title>
</head>
<body>
	<div class="container">
		<h1>Start</h1>
		
		<form:form action="/start" method="post" modelattribute="user">
			<div class="form-group" style="margin-bottom: 5px;">
				<label for="username"></label>
				<input type="text" id="username" name="username" placeholder="Enter your username" required />
			</div>
			<div class="form-group" style="margin-bottom: 5px;">
				<label for="email"></label>
				<input type="email" id="email" name="email" placeholder="Enter your email" required />
			</div>
			<div class="form-group" style="margin-bottom: 5px;">
				<label for="password"></label>
				<input type="password" id="password" name="password" placeholder="Enter password" required />
			</div>
			<div class="form-group" style="margin-bottom: 5px;">
				<label for="cpassword"></label>
				<input type="password" id="cpassword" name="cpassword" placeholder="Confirm password" required />
			</div>
			<c:if test="${not empty errmsg}">
			<div class="form-group">
				<p style="color: red">${errmsg}</p>
			</div>
			</c:if>
			<c:if test="${not empty msg}">
				<p style="color: green;">${msg}</p>
			</c:if>
			<div class="form-group" style="margin-top: 5px; margin-bottom: 20px;">
				<button type="submit">Enter</button>
			</div>
		</form:form>
	</div>
	
	<footer><a href="/">ChatSpringBoot</a> &copy; 2024. Made with love in Machang.</footer>
</body>
</html>