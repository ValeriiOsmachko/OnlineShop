package com.epam.osmachko.controller;

import java.io.IOException;


import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.osmachko.bean.Captcha;
import com.epam.osmachko.capture_manager.CaptchaManager;
import com.github.cage.Cage;
import com.github.cage.GCage;

/**
 * Servlet implementation class CaptchaServlet
 */
public class CaptchaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final Logger LOGGER = Logger.getLogger(CaptchaServlet.class);
	
	private CaptchaManager manager;
	
	@Override
	public void init() throws ServletException {
		manager = (CaptchaManager) getServletContext().getAttribute("manager");
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		Captcha captcha = new Captcha();
		Random random = new Random();
		String captchaValue = Integer.toString(100000 + random.nextInt(900000));
		captcha.setValue(captchaValue);
		request.setAttribute("Capthca", captcha);
		manager.save(request, response);
		Cage cage = new GCage();
		OutputStream outPut = response.getOutputStream();
		cage.draw(captchaValue.toString(), outPut);
		
	}



}
