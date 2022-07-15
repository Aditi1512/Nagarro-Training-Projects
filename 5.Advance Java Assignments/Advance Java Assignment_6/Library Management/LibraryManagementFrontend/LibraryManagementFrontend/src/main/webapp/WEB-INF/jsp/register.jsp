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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<script type="module"
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

<title>Register</title>
<style>
body {
	background: #000000 url(https://wallpapercave.com/wp/VtwBflx.jpg);
}

.register-dark form {
	max-width: 320px;
	width: 90%;
	background-color: #3A3B3C;
	padding: 40px;
	border-radius: 4px;
	transform: translate(-50%, -50%);
	position: absolute;
	top: 50%;
	left: 50%;
	color: #fff;
	box-shadow: 3px 3px 4px rgba(0, 0, 0, 0.2);
}

.btn {
	background-color: #D3D3D3;
	color: black;
	border: 2px solid #555555;
}

.register-dark .illustration {
	text-align: center;
	padding: 15px 0 20px;
	font-size: 100px;
	color: #2980ef;
}

input.form-control, textarea {
	background: #C0C0C0;
}
</style>
</head>


<body>

	<div class="container">
		<div class="row py-5 mt-4">
			<div class="row">
				<div class="col-md-6 offset-md-3">
					<div class="signup-form">
						<div class="register-dark">
							<form id="register" action="/do_register" method="post"
								class="mt-5">
								<!--  <h4 class="mb-5 text-secondary"><font color="#C0C0C0">Login</font></h4>  -->
								<div class="illustration">
									<ion-icon name="person-add"></ion-icon>
									<i class="bi bi-person-plus-fill"></i>
								</div>
								<div class="row">
									<div class="mb-3 col-md-12">
										<label><font color="#C0C0C0">Enter Full Name</font><span
											class="text-danger">*</span></label> <input type="text"
											name="fullname" class="form-control" placeholder="Full Name">
									</div>

									<div class="mb-3 col-md-12">
										<label><font color="#C0C0C0">Enter User Name</font><span
											class="text-danger">*</span></label> <input type="text"
											name="username" class="form-control" placeholder="User Name">
									</div>

									<div class="mb-3 col-md-12">
										<label><font color="#C0C0C0">Enter Email</font><span
											class="text-danger">*</span></label> <input type="email" name="email"
											class="form-control" placeholder="Email Address">
									</div>

									<div class="mb-3 col-md-12">
										<label><font color="#C0C0C0">Password</font><span
											class="text-danger">*</span></label> <input type="password"
											name="password" class="form-control"
											placeholder="Enter Password">
									</div>

									<div class="col-md-12">
										<button class="btn btn-primary float-center">
											<font color="black">Sign Up</font>
										</button>
									</div>
								</div>
							</form>

						</div>
					</div>
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