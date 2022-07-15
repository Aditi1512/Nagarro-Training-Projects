<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="com.nagarro.model.User"%>
<%@page import="com.nagarro.model.Product"%>
<%@page import="java.util.List"%>

<%
	Cookie cookies[] = request.getCookies();
	if (cookies == null) {
		System.out.println("You should login first");
		response.sendRedirect("Login.jsp");
		return;
	}
	String userName = null;
	for (Cookie c : cookies) {
		if (c.getName().equals("username"))
			userName = c.getValue();
	}
	if (userName == null) {
		response.sendRedirect("Login.jsp");
		return;
	}
%>
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





<style>
td, th {
	text-align: center
}

#usernameDiv {
	float: right;
	margin-right: 10px;
}

#logoutDiv {
	float: right;
	margin-right: 40px;
}

#hiddenDiv {
	position: fixed;
	display: block;
	top: 25%;
	left: 30%;
	background-color: grey;
}

#overlay {
	width: 100%;
	height: 100%;
	background-color: grey;
	opacity: 0.7;
	position: fixed;
	display: block;
}

.hidden {
	display: none;
}

.visible {
	display: block;
}
</style>





</head>
<body>

	<div class="hidden" id="editDiv">
		<div id="overlay"></div>
		<div id="hiddenDiv"  style="border: 5px solid black">
			<form id="editProduct" method="post" action="ProductEdit"
				enctype="multipart/form-data" name="editForm">
				<br>
					<h5 class="text-light px-3">Edit Product Details</h5>
				<div class="form-group px-4">
					<label for="title">Title</label>
					<div class="col-xs-2">
						<input type="text" name="editTitle"
							class="form-input px-3 rounded border-1" id="edit_title" required>
					</div>
				</div>
				<div class="form-group px-4">
					<label for="quantity">Quantity</label>
					<div class="col-xs-2">
						<input type="text" class="form-input px-3 rounded border-1"
							name="editQuantity" id="edit_quantity" required>
					</div>
				</div>
				<div class="form-group px-4">
					<label for="size">Size</label>
					<div class="col-xs-2">
						<input type="text" name="editSize"
							class="form-input px-3 rounded border-1" id="edit_size" required>
					</div>
				</div>
				<br>
				<div class="form-group px-4">
					<label for="image">Image</label> <input type="file"
						name="editImageFile" accept="image/*" id="edit_image" required>

					<input type="submit" name="saveEdit" id="save_Edit"> <span></span><input
						type="button" value="Cancel" name="cancel" id="cancelBtn">
				</div>
				<br>
			</form>
		</div>
	</div>






	<div id="logoutDiv">

		<a href="Login.jsp"> <input type="button" value="Logout">
			<!-- style="float: right; margin-right: 40px;"> -->
		</a>

	</div>

	<div id="usernameDiv">

		<%
			out.println("Hi " + userName + " ");
		%>
	</div>
	<div style="margin-left: 450px">
		<h2>Product Management Tool</h2>
	</div>
	<div class="visible" id="productDiv">
		<div>
			<form method="post" action="productSave"
				enctype="multipart/form-data" id="saveForm" name="saveForm">

				<div class="form-group px-5">
					<h5>Please Enter Product details to add to Stock</h5>
				</div>

				<div class="form-group px-5">

					<label for="title">Title</label> <input type="text" name="title"
						style="margin-left: 40px" class="form-input px-3 rounded border-1"
						id="title" required>
				</div>
				<br>

				<div class="form-group px-5">
					<label for="quantity">Quantity</label> <input type="text"
						class="form-input px-3 rounded border-1" name="quantity"
						style="margin-left: 10px" id="quantity" required>
				</div>
				<br>
				<div class="form-group px-5">
					<label for="size">Size</label> <input type="text" name="size"
						style="margin-left: 40px" class="form-input px-3 rounded border-1"
						id="size" required>
				</div>
				<br>
				<div class="form-group px-5">
					<label for="image">Image</label> <input type="file" name="img_File"
						style="margin-left: 25px" accept="image/*" id="image" required>
					<input type="submit" name="browse">
				</div>

			</form>
		</div>
	</div>

	<div class="col py-2"></div>

	<div>

		<table
			class="table table-striped table-hover table-bordered align-middle"
			align="center" style="width: 90%">
			<thead>
				<tr>
					<th>S.NO</th>
					<th>Title</th>
					<th>Quantity</th>
					<th>Size</th>
					<th>Image</th>
					<th>Action</th>
				</tr>
			</thead>
			<%
				List<Product> productList = User.getProductList(userName);
				if (productList == null) {
					Cookie c = new Cookie("userName", "");
					c.setMaxAge(0);
					response.addCookie(c);
					response.sendRedirect("Login.jsp");
				}

				String id, title, size, quantity, action_delete, action_edit, imgName, filepath, image;

				String directory = "Image";
				String appPath = request.getServletContext().getRealPath("");
				String savePath = appPath + "\\" + directory;
				int count = 0;

				FileOutputStream fos;
				action_delete = "<img src = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQ9vM3X17yNl0Pk5EKAjf5BE6GVYiHa276Vg&usqp=CAU' width=20px height=20px class = 'delete'>";
				action_edit = "<img src = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ81Qh39mq91JKcNI2-Aozyw3SNnBgyHbD5yQ&usqp=CAU' width=20px height=20px class = 'edit'>";
				for (Product product : productList) {
					id = product.getId() + "";
					title = product.getTitle();
					size = product.getSize();
					quantity = product.getQuantity();
					imgName = product.getImgName();
					filepath = savePath + "\\" + imgName + "_" + id;
					fos = new FileOutputStream(filepath);
					fos.write(product.getImage());
					image = "Image\\" + imgName + "_" + id;
			%>

			<tr>
				<td width="10px">
					<%
						out.println(++count);
					%>
				</td>
				<td>
					<%
						out.println(title);
					%>
				</td>
				<td>
					<%
						out.println(quantity);
					%>
				</td>
				<td>
					<%
						out.println(size);
					%>
				</td>

				<%
					out.println("<td><img width='150px' height='150px' src='" + image + "'></td>");
				%>

				<td>
					<button class='btn btn-default' id="delete"
						onclick="deleteRowFunction(<%=product.getId() + ""%>);">
						<%
							out.println(action_delete);
						%>
					</button>
					<button class='btn btn-default' id='edit'
						onclick="editRowFunction(<%=product.getId() + ""%>);">
						<%
							out.println(action_edit);
						%>
					</button>



				</td>
			</tr>
			<%
				}
			%>
		</table>
		<script>	
		
		var idd=null;
		
		function preventBack() {
			window.history.forward();
		}
		setTimeout("preventBack()", 0);
		window.onunload = function() {
			null
		};
			
		function deleteRowFunction(id) {
			// event.target will be the input element.
			var td = event.target.parentNode;
			var tr = td.parentNode; // the row to be removed
			tr.parentNode.removeChild(tr);
			var f=document.saveForm;
			f.method="post";
			f.action='ProductDelete?id='+id;
			f.submit();
		
		};
		
		var editProductDiv = document.getElementById('editDiv');
	    var productDiv = document.getElementById('productDiv');

	    var editDivButton = document.getElementById('edit');
	    var productDivButton = document.getElementById('save_Edit');

	    /* editDivButton.onclick = function() {
	    	productDiv.setAttribute('class', 'hidden');
	    	editProductDiv.setAttribute('class', 'visible');
	    }; */

	    productDivButton.onclick = function() {
	    	editProductDiv.setAttribute('class', 'hidden');
	        productDiv.setAttribute('class', 'visible');
	        var id=idd;
	        updateProductFunction(id);
	        
	        
	    };
	    
	    function updateProductFunction(id){
	    	var f = document.editForm;
			f.method = "post";
			f.action = 'ProductEdit?id='+id;
			f.submit();
	    } 
	    
	    function editRowFunction(id){
			 productDiv.setAttribute('class', 'hidden');
		    	editProductDiv.setAttribute('class', 'visible');
			idd=id;
			
		}
	    
	    var cancelButton = document.getElementById("cancelBtn");
	    cancelButton.onclick = function(){
	    	window.location.replace("Product.jsp");
	    };
		</script>

	</div>


</body>
</html>