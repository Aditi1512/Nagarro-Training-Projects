<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@page import="java.util.List"%>
<%@page import="com.nagarro.model.Tshirt"%>
<%@page import="com.nagarro.controller.SearchController"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Result</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">-->

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body style="margin: 0px">
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	String username = (String) session.getAttribute("username");

	if (username == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<h2 style="background-color: #D5D8DC; margin-top: 0px; padding: 10px"
		align="center">
		Search Result <a
			style="float: right; font-size: 18px; padding-right: 10px"
			href="tshirtManagement.jsp"> <span
			class="glyphicon glyphicon-log-in"></span> Back to Search Page
		</a>
	</h2>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Name</th>
				<th scope="col">Color</th>
				<th scope="col">Gender</th>
				<th scope="col">Size</th>
				<th scope="col">Price</th>
				<th scope="col">Rating</th>
				<th scope="col">Availability</th>
			</tr>
		</thead>
	</table>
	
  <h5 align="center">T-shirt is Unavailable!</h5>
 


</body>
</html>