<%@page import="com.jspiders.springmvc.pojo.CarPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="NavBar.jsp" />

<%
CarPOJO pojo = (CarPOJO) request.getAttribute("pojo");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: grey;
}

fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	margin-top: 100px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}

#data {
	color: white;
	border: 1px solid white;
}

#data td {
	color: white;
	border: 1px solid black;
	text-align: center;
}

h3 {
	color: white;
}

#button {
	padding: 10px;
	background-color: #4158D0;
	background-image: linear-gradient(43deg, #4158D0 0%, #C850C0 46%, #FFCC70 100%);
}
</style>
</head>
<body>
	<div align="center">
		<fieldset>
			<legend>Add Car Details</legend>
			<form action="./add" method="post">
				<table>
					<tr>
						<td>Name:</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>Brand:</td>
						<td><input type="text" name="brand"></td>
					</tr>
					<tr>
						<td>Type:</td>
						<td><input type="text" name="type"></td>
					</tr>
					<tr>
						<td>Price:</td>
						<td><input type="text" name="price"></td>
					</tr>
				</table>
				<input type="submit" id="button" value="Add">
			</form>
		</fieldset>
		<%
		if (msg != null) {
		%>
		<h3><%=msg%></h3>
		<%
		}
		%>
		<%
		if (pojo != null) {
		%>
		<table id="data">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Brand</th>
				<th>Type</th>
				<th>Price</th>
			</tr>

			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>
				<td><%=pojo.getBrand()%></td>
				<td><%=pojo.getType()%></td>
				<td><%=pojo.getPrice()%></td>
			</tr>
		</table>
		<%
		}
		%>
	</div>

</body>
</html>