<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
body {
	background-color: grey;
}

* {
	margin: 0;
	padding: 0;
}

nav {
	background-color: #f8f8f8;
	display: flex;
	justify-content: space-between;
}

div {
	line-height: 50px;
	text-shadow: 0 0 10px red;
}

div h1 {
	font-size: 28px;
}

ul {
	height: 50px;
	display: flex;
	justify-content: end;
	align-items: center;
}

li {
	list-style-type: none;
}

a {
	text-decoration: none;
	padding: 20px;
	color: black;
	font-size: 24px;
	cursor: pointer;
}

a:hover {
	text-decoration: underline;
}

.main {
	height: 100vh;
	background-image: url(./pexels-mike-b-112460.jpg);
	background-position: center;
	background-size: cover;
}
</style>
</head>
<body>
	<nav>
		<div>
			<h1>CarDekho</h1>
		</div>
		<ul>
			<li><a href="./home">Home</a></li>
			<li><a href="./add">Add Car</a></li>
			<li><a href="./search">Search Car</a></li>
			<li><a href="./remove">Remove Car</a></li>
			<li><a href="./update">Update Car</a></li>
			<li><a href="./logout">Logout</a></li>

		</ul>
	</nav>

</body>
</html>