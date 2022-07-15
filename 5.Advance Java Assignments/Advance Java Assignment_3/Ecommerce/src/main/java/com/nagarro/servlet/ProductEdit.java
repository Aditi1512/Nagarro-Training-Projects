package com.nagarro.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.nagarro.hibernateUtils.HibernateUtils;

/**
 * This is use to edit user's product information. Servlet implementation class
 * ProductDelete.
 */

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, maxFileSize = 1024 * 1024 * 10)
public class ProductEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This method edits user's product information in database.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("editTitle");
		String quantity = request.getParameter("editQuantity");
		String size = request.getParameter("editSize");
		PrintWriter out = response.getWriter();
		String imageId = request.getParameter("id");
		System.out.println(imageId);
		int id = Integer.valueOf(imageId);

		Part part = null;
		try {
			part = request.getPart("editImageFile");

		} catch (Exception e) {

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Image size greater than 500 KB!!');");
			out.println("window.location = \"/Ecommerce/Product.jsp\";");
			out.println("</script>");
			return;
		}
		String fileName = part.getSubmittedFileName().toString();
		String directory = "Image";
		String appPath = request.getServletContext().getRealPath("");
		System.out.println(appPath);
		String savePath = appPath + File.separator + directory;
		String filePath = savePath + File.separator + fileName;
		InputStream ip = part.getInputStream();
		byte[] bFile = new byte[(int) part.getSize()];
		ip.read(bFile);

		try {
			part.write(filePath);
		} catch (Exception e) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please select an Image File before submission.');");
			out.println("window.location = \"/Ecommerce/Product.jsp\";");
			out.println("</script>");
			return;
		}
		HibernateUtils.editProductData(id, title, quantity, size, bFile, fileName, response);
		response.sendRedirect("Product.jsp");

	}
}