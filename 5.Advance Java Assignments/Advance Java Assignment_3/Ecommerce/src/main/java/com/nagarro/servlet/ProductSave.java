package com.nagarro.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.nagarro.hibernateUtils.HibernateUtils;
import com.nagarro.model.Product;

/**
 * This class is use to save user's product information in database. Servlet
 * implementation class ProductSave
 */
@WebServlet("/productSave")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 10)
public class ProductSave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * This method saves user's product information into an database if user exist.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = null;
		String title = request.getParameter("title");
		String quantity = request.getParameter("quantity");
		String size = request.getParameter("size");
		PrintWriter out = response.getWriter();

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("username")) {
					username = c.getValue();
				}
			}
		}
		if (username == null) {

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Login First!!');");
			out.println("</script>");
			response.sendRedirect("Login.jsp");
			return;
		}

		String path;
		Part part = null;
		try {
			part = request.getPart("img_File");
			path = request.getServletContext().getRealPath("img_File");

		} catch (Exception e) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Image size greater than 1 MB!!');");
			out.println("window.location = \"/Ecommerce/Product.jsp\";");
			out.println("</script>");
			return;
		}

		String imageName = part.getSubmittedFileName().toString();
		String directory = "Image";
		String appPath = request.getServletContext().getRealPath("");
		String savePath = appPath + File.separator + directory;
		String filePath = savePath + File.separator + imageName;
		InputStream inputStream = part.getInputStream();
		byte[] image = new byte[(int) part.getSize()];
		inputStream.read(image);
		part.write(filePath);

		Product product = new Product();
		product.setImage(image);
		product.setTitle(title);
		product.setQuantity(quantity);
		product.setSize(size);
		product.setImgName(imageName);

		HibernateUtils.saveProductData(product, username, response);

		response.sendRedirect("Product.jsp");

	}
}
