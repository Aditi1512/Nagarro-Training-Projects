<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

String username = (String) session.getAttribute("username");

if (username == null) {
	response.sendRedirect("login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Product</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">-->

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<style>
#logoutDiv {
	float: right;
	margin-right: 40px;
	margin-top: 18px;
}

#usernameDiv {
	float: right;
	margin-right: 10px;
	margin-top: 20px;
}
</style>

</head>
<body>
	<div>
		<div id="logoutDiv">
			<form action="logout">
				<input type="submit" value="Logout">
			</form>
		</div>
		<div id="usernameDiv">Hi ${username}</div>
		<div style="margin-left: 300px; margin-right: 300px">
			<h2
				style="background-color: #808080; margin-top: 0px; padding: 10px; border-style: solid;"
				align="center">T-SHIRT SEARCH PAGE</h2>

		</div>
		<div class='container-fluid py-5'
			style="border-style: solid; background-color: #C0C0C0">
			<div class='row py-4 my-4'>
				<div class="col-4"></div>
				<div class="col-12 col-md-5 ml-5 mr-0 vertical">
					<!--form-->
					<form method="POST" action="search">
						<!--Color input-->

						<div class="row mb-3">
							<div class="col-3 col-md-4 text-start">
								<label class="form-label">Color:</label>
							</div>
							<div class="col-9 col-md-6 text-center">
								<input type="text" class="form-input m-0 w-100 rounded border-1"
									name="color" id="color" required />
								<%
								session.setAttribute("username", username);
								%>
							</div>
						</div>
						<!--size input-->
						<div class="row mb-3">
							<div class="col-3 col-md-4 text-start">
								<label class="form-label">Size</label>
							</div>
							<div class="col-9 col-md-6 text-start">
								<select class="btn btn-mini" style="margin-left: 40px"
									name="size" id="size" required>
									<option selected>Select Size</option>
									<option value="S">S</option>
									<option value="M">M</option>
									<option value="L">L</option>
									<option value="XL">XL</option>
									<option value="XXL">XXL</option>
								</select>
							</div>
						</div>
						<!--gender radio buttons-->
						<div class="row mb-3">
							<div class="col-3 col-md-4 text-start">
								<label class="form-label">Gender</label>
							</div>
							<div class="col-9 col-md-6 text-start">
								<div class="form-check">
									<input class="form-check-input" type="radio" name="gender"
										id="gender" value="M" /> <label class="form-check-label"
										for="male"> Male </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="gender"
										id="gender" value="F" /> <label class="form-check-label"
										for="female"> Female </label>
								</div>
							</div>
						</div>
						<!--output preference radio buttons-->
						<div class="row mb-3">
							<div class="col-3 col-md-4 text-start">
								<label class="form-label">Sort By:</label>
							</div>
							<div class="col-9 col-md-6 text-start">
								<div class="form-check">
									<input class="form-check-input" type="radio" name="outputPref"
										id="outputPref" value="Price" /> <label
										class="form-check-label" for="male"> Price </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="outputPref"
										id="outputPref" value="Rating" /> <label
										class="form-check-label" for="female"> Rating </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="outputPref"
										id="outputPref" value="Both" /> <label
										class="form-check-label" for="female"> Both (Price and
										Rating) </label>
								</div>
							</div>
						</div>
						<!--buttons-->
						<div class="row mb-3">
							<div class="col-6 col-md-4 text-start mb-3 ml-5">
								<button type="submit" class="btn btn-primary"
									style="float: right">Search</button>
							</div>
						</div>
					</form>
				</div>
				<div class="col-4"></div>
			</div>
		</div>
	</div>
</body>
</html>