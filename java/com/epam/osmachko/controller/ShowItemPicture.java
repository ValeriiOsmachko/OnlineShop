package com.epam.osmachko.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.osmachko.entity.User;
import com.epam.osmachko.property.PropertyPathHandler;

/**
 * Servlet implementation class ShowItemPicture
 */
@WebServlet("/ShowItemPicture")
public class ShowItemPicture extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/*");
		User user = (User)request.getSession().getAttribute("logUser");
		String idPicture = request.getParameter("imageId");
		PropertyPathHandler handler = new PropertyPathHandler();
		String pictureDirPath = handler.getCarPicturePath();
		String pictureName = idPicture + ".jpg"; 
		OutputStream outputStream = response.getOutputStream();
		File file = new File(pictureDirPath + pictureName);
		if(!file.exists()) {
			byte[] array = Files.readAllBytes(new File(pictureDirPath + "default.jpg").toPath());
			outputStream.write(array);
		} else {
			byte[] array = Files.readAllBytes(file.toPath());
			outputStream.write(array);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
