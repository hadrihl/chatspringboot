<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ChatSpringBoot | Chat</title>
</head>
<body>
	<div class="container">
		<h1>Hi, ${username}</h1>
		<c:if test="${not empty msg}"><p>${msg}</p></c:if>
	</div>
	
	<footer><a href="/">ChatSpringBoot</a> &copy; 2024. Made with love in Machang</footer>
</body>
</html>