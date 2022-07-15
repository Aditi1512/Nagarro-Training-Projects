<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@page import="java.util.List"%>
<%@page import="com.nagarro.LibraryManagementFrontend.model.Book"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>Book Listing</title>

<style>
table td {
	color: white;
	text-align: center;
}

table thead {
	color: white;
	text-align: center;
	width: 30%;
}

h3 {
	margin-left: 45%;
	color: white;
	display: inline-block;
	color: white;
}

#add-book {
	float: right;
	margin-right: 60px;
}

.navbar .title {
	float: left
}

.navbar .user {
	float: right
}

body, h1, h2, h3, h4, h5, h6 {
	font-family: Arial, Helvetica, sans-serif;
}
</style>
</head>
<body background='https://wallpapercave.com/wp/VtwBflx.jpg'>

	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	String username = (String) session.getAttribute("username");

	if (username == null) {
		response.sendRedirect("login");
	}
	int i = 0;
	%>
	<div>
		<nav class="navbar navbar-expand-sm bg-light navbar-light">
			<span class="title mb-0 h1" style="padding-left: 1%;">LIBRARY
				MANAGEMENT</span><span class="user mb-0 h5"
				style="padding-left: 37%; padding-right: 1%">Welcome
				${username}</span>


			<button class="btn btn-outline-primary bg-transparent"
				onclick="location.href='/logout'">Logout</button>


		</nav>
	</div>
	<br>
	<div>

		<h3>BOOK LISTING</h3>
		<button class="btn btn-outline-success bg-transparent" id="add-book"
			onclick="location.href='/addBook'">Add Book</button>
		<!-- <button class="btn btn-outline-success bg-transparent" id="add-book"
			onclick="location.href='/show_books'" style="margin-right: 10px;">Show
			Books</button> -->


	</div>
	<br>
	<div class='table'>
		<table
			class="table table-sm table-hover table-bordered table-striped align-middle"
			border="1">
			<thead class="thead-dark">
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Book Code</th>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Date Added</th>
					<th scope="col">Action</th>
				</tr>
			</thead>

			<c:forEach items="${books}" var="book">
				<tr>
					<td>
						<%
						out.println(++i);
						%>
					</td>
					<td>${book.code}</td>
					<td>${book.name}</td>
					<td>${book.author}</td>
					<td>${book.date}</td>
					<td><button class="btn btn-outline-primary bg-transparent"
							onclick="location.href='/edit_book/${book.code}'">Edit</button>
						<button class="btn btn-outline-danger bg-transparent"
							onclick="location.href='/deleteBook/${book.code}'">Delete</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class='footer fixed-bottom'></div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>