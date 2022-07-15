<!doctype html>
<html lang="en">
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

<title>Login</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="signup-form">
					<form id="login" action="login" method="post"
						class="mt-5 border p-4 bg-light shadow">
						<h4 class="mb-5 text-secondary">Login</h4>
						<div class="row">

							<div class="mb-3 col-md-12">
								<label>User Name<span class="text-danger">*</span></label> <input
									type="text" name="userName" class="form-control"
									placeholder="Enter User Name">
							</div>


							<div class="mb-3 col-md-12">
								<label>Password<span class="text-danger">*</span></label> <input
									type="password" name="password" class="form-control"
									placeholder="Enter Password">
							</div>

							<div class="col-md-12">
								<button class="btn btn-primary float-end">Login</button>
							</div>
						</div>
					</form>
					<p class="text-center mt-3 text-secondary">
						New User? <a href="Register.jsp">Sign Up Here</a>
					</p>
					<p class="text-center mt-3 text-secondary">
						<a href="ForgotPassword.jsp">Forgot Password?</a>
					</p>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>
