package com.epam.osmachko.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.osmachko.constant.Constant;
import com.epam.osmachko.entity.User;
import com.epam.osmachko.property.PropertyPathHandler;

/**
 * Servlet implementation class ShowAvatarServlet
 */
@WebServlet("/ShowAvatarServlet")
public class ShowAvatarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/*");
		User user = (User)request.getSession().getAttribute("logUser");
		PropertyPathHandler handler = new PropertyPathHandler();
		String avatarDirPath = handler.getAvatarPath();
		String userAvatarName = user.getId().toString() + ".jpg"; 
		OutputStream outputStream = response.getOutputStream();
		File file = new File(avatarDirPath + userAvatarName);
		if(!file.exists()) {
			byte[] array = Files.readAllBytes(new File(avatarDirPath + "default.jpg").toPath());
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
		doGet(request, response);
	}

}
