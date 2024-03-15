<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>ChatSpringBoot | Live Chat</title>
</head>
<body>
	<div class="container">
		<input type="text" id="messageInput" placeholder="Enter your message" />
		<button onclick="sendmessage()">Send</button>
		<div id="chatArea"></div>
	</div>
	
	<script>
		var socket = new WebSocket("ws://localhost:8080/chat/user/user1");
		
		socket.onmessage(function(event) {
			var message = event.data;
			var chatArea = document.getElementById("chatArea");
			chatArea.innerHTML = "<p>" + message + "</p>";
		});
		
		function sendmessage() {
			var messageInput = document.getElementById("messageInput");
			var message = messageInput.value;
			socket.send(message);
			messageInput.value = "";
		}
	</script>
</body>
</html>