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

<title>Reset Password</title>
</head>
<body>
	<div class="container">
		<div class="row py-5 mt-4">
			<div class="row">
				<div class="col-md-6 offset-md-3">
					<div class="forgotPass-form">
						<form id="forgotPassword" action="ResetPassword" method="post"
							class="mt-5 border p-4 bg-light shadow">
							<h4 class="mb-5 text-secondary">Reset Your Password</h4>
							<div class="row">

								<div class="mb-3 col-md-12">
									<label>New Password<span class="text-danger">*</span></label> <input
										type="Password" name="resetPassword" class="form-control"
										placeholder="Enter New Password">
								</div>

								<div class="col-md-12">
									<button class="btn btn-primary float-end">Reset Password</button>
								</div>
							</div>
						</form>
			
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