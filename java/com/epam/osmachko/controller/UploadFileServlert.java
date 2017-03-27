package com.epam.osmachko.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.epam.osmachko.constant.Constant;
import com.epam.osmachko.entity.User;
import com.epam.osmachko.property.PropertyPathHandler;

/**
 * Servlet implementation class UploadFile
 */

@MultipartConfig(fileSizeThreshold=1024*1024*2, 
                 maxFileSize=1024*1024*10,     
                 maxRequestSize=1024*1024*50)
//@WebServlet("/UploadFile")
public class UploadFileServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String appPath = request.getServletContext().getRealPath("");
//		String savePath = "D:" + File.separator + Constant.SAVE_AVATAR_DIR;
		PropertyPathHandler handler = new PropertyPathHandler();
		String avatarDirPath = handler.getAvatarPath();
		String fileName = null;
		System.out.println("!!!!!" + avatarDirPath);
		File fileSaveDir = new File(avatarDirPath);
		if(!fileSaveDir.exists()) {
			fileSaveDir.mkdirs();
		}
		for(Part part : request.getParts()) {
			fileName = extractFileName(part);
			fileName = new File(fileName).getName();
			User user = (User)request.getSession().getAttribute("logUser");
			fileName = user.getId().toString();
			part.write(avatarDirPath  + fileName +".jpg");
		}
//		request.getSession().setAttribute(Constant.USER_AVATAR_SAVE_PATH, savePath + File.separator);
//		request.getSession().setAttribute(Constant.AVA,true);
//		response.sendRedirect(Constant.REDIREC_ITEMS);
		response.sendRedirect("index2version.jsp");
	}
	
	 private String extractFileName(Part part) {
	        String contentDisp = part.getHeader("content-disposition");
	        String[] items = contentDisp.split(";");
	        for (String s : items) {
	            if (s.trim().startsWith("filename")) {
	                return s.substring(s.indexOf("=") + 2, s.length()-1);
	            }
	        }
	        return "";
	    }

}
