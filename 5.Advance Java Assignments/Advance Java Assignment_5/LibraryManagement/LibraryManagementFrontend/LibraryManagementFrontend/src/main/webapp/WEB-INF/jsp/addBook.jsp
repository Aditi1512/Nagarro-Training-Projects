<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@page import="java.util.Date"%>

<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<title>Library Management</title>
<style>
.header {
	border-style: solid;
	border-color: black;
	background-color: white;
	color: black;
	font: "Times New Roman";
	font-size: large;
	text-align: center;
	padding: 10px;
}

body {
	background: #000000 url(https://wallpapercave.com/wp/VtwBflx.jpg);
}

.footer {
	border-style: solid;
	border-color: black;
	background-color: white;
	color: black;
	font: "Times New Roman";
	font-size: smaller;
	text-align: center;
	padding: 10px;
}

label {
	display: inline-block;
	width: 140px;
	text-align: right;
}
​
</style>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	String username = (String) session.getAttribute("username");
	if (username == null) {
		response.sendRedirect("login");
	}
	%>
	<div class="container">
		<div class="fixed-top">
			<div class="header">
				<b>Library Management</b>
			</div>
		</div>
		<div class="row py-5 mt-5">
			<div class="row">
				<div style="margin-left: 450px">
					<h4>
						<font color="#C0C0C0">Add Books Details</font>
					</h4>
				</div>
				<div class="col-md-6 offset-md-3">
					<div class="addBook-form">
						<form id="addBook" action="/add_book" method="post" class="mt-5">
							<div class="form-group px-5">
								<label for="bookCode-input"><font color="#C0C0C0"
									style="margin-right: 0px">Book Code</font></label> <input type="text"
									name="code" style="margin-left: 40px" id="book-code"
									placeholder="Enter Book Code" required>
							</div>
							<br>
							<div class="form-group px-5">
								<label for="bookName-input"><font color="#C0C0C0"
									style="margin-left: 5px">Book Name</font></label> <input type="text"
									name="name" style="margin-left: 40px" id="book-name"
									placeholder="Enter Book Name" required>
							</div>
							<br>


							<div class="form-group px-5">


								<label for="author-input"><font color="#C0C0C0"
									style="margin-right: 30px">Author</font></label> <select name='author'
									id="author" class="btn"
									style="margin-left: 40px; background-color: white;">
									<option selected>Select Author</option>
									<c:forEach var="author" items="${listOfAuthors}">
										<option id="${author.id}}" value="${author.authorName}">${author.authorName}</option>
									</c:forEach>
								</select>

							</div>
							<br>

							<div class="form-group px-5">
								<label for="date-input"><font color="#C0C0C0"
									style="margin-right: 8px">Added On</font></label>

								<%
								Date date = new Date();
								out.print("<p style='color: white; display:inline-block; padding-left:48px'>" + date.toString() + "</p>");
								%>
							</div>
							<br>

							<button class="btn btn-primary" id="add-user" type="submit"
								style="margin-left: 100px">Submit</button>
							<button class="btn btn-danger" id="cancelBtn" type="button"
								name="cancel" style="margin-left: 25px"
								onclick="location.href='/show_books'">Cancel</button>
						</form>
					</div>
				</div>
			</div>
		</div>



		<div class="footer fixed-bottom"></div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>