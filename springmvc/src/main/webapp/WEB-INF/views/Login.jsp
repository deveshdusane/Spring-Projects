<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.login-container {
	background-color: #ffffff;
	border-radius: 5px;
	padding: 20px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
	width: 300px;
}

.login-container h2 {
	text-align: center;
}

.login-container form {
	display: flex;
	flex-direction: column;
}

.login-container input[type="text"], .login-container input[type="password"]
	{
	margin: 10px 0;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
}

.login-container input[type="submit"] {
	background-color: #007bff;
	color: #fff;
	border: none;
	padding: 10px;
	border-radius: 3px;
	cursor: pointer;
}

.login-container input[type="submit"]:hover {
	background-color: #0056b3;
}

fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}

body {
	background-size: 100%;
}
</style>
</head>
<body>
	<div align="center">
		<%
		if (msg != null) {
		%>
		<h3><%=msg%></h3>
		<%
		}
		%>
		<div class="login-container">
			<h2>Login</h2>
			<form action="./login" method="post">
				<input type="text" name="username" placeholder="Username"
					required="required"> <input type="password" name="password"
					placeholder="Password" required="required"> <input
					type="submit" value="Login">
			</form>
			<a href="http://localhost:8080/springmvc/createAccount">Create
				Account</a>
		</div>
	</div>

</body>
</html>