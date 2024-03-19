<%@page import="java.util.List"%>
<%@page import="com.jspiders.springmvc.pojo.CarPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="NavBar.jsp" />
<%

List<CarPOJO> cars = (List<CarPOJO>) request.getAttribute("cars");
CarPOJO pojo = (CarPOJO) request.getAttribute("car");
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
		<%
		if (pojo == null) {
		%>
		<fieldset>
			<legend>Select Car to Update</legend>
			<form action="./update" method="post">
				<table>
					<tr>
						<td>Enter Id:</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
				<input type="submit" id="button" value="Select">
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
		if (cars != null) {
		%>
		<table id="data">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Brand</th>
				<th>Type</th>
				<th>Price</th>
			</tr>
			<%
			for (CarPOJO car : cars) {
			%>
			<tr>
				<td><%=car.getId()%></td>
				<td><%=car.getName()%></td>
				<td><%=car.getBrand()%></td>
				<td><%=car.getType()%></td>
				<td><%=car.getPrice()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		} else {
		%>
		<fieldset>
			<legend>Update Car</legend>
			<form action="./updateCar" method="post">
				<table id="data">
					<tr>
						<td>Id:</td>
						<td><%=pojo.getId()%></td>
						<td><input type="text" name="id" value="<%=pojo.getId()%>"
							hidden="true"></td>
					</tr>
					<tr>
						<td>Name:</td>
						<td><input type="text" name="name"
							value="<%=pojo.getName()%>"></td>
					</tr>
					<tr>
						<td>Brand:</td>
						<td><input type="text" name="brand"
							value="<%=pojo.getBrand()%>"></td>
					</tr>
					<tr>
						<td>Type:</td>
						<td><input type="text" name="type"
							value="<%=pojo.getType()%>"></td>
					</tr>
					<tr>
						<td>Price:</td>
						<td><input type="text" name="price"
							value="<%=pojo.getPrice()%>"></td>
					</tr>
				</table>
				<input type="submit" id="button" value="Update">
			</form>
		</fieldset>
		<%
		}
		%>

	</div>
</body>
</html>