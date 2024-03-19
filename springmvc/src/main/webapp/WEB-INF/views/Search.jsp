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

form {
	margin-top: 10px;
}

form table {
	margin: auto;
	width: 100%;
}

tr {
	text-align: center;
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
	border: 1px solid black;
	width: 50%;
	border: 1px solid white;
	background-color: transparent;
}

#data td {
	border: 1px solid white;
	text-align: center;
}

th {
	color: yellow;
}

td {
	color: white
}

#button {
	background-color: #4158D0;
	background-image: linear-gradient(43deg, #4158D0 0%, #C850C0 46%, #FFCC70 100%);
}

h3 {
	color: white;
}
</style>
</head>
<body>
	<div align="center">
		<fieldset>
			<legend>Search Car Details</legend>
			<form action="./search" method="post">
				<table>
					<tr>
						<td>Enter Id</td>
						<td><input type="text" autofocus="autofocus" name="id"></td>
					</tr>
				</table>
				<input type="submit" id="button" value="Search">
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