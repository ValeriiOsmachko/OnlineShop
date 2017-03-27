package com.epam.osmachko.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import com.epam.osmachko.ValidatorUtil.InputFormValidator;
import com.epam.osmachko.bean.RegistrationFormBean;
import com.epam.osmachko.capture_manager.CaptchaManager;
import com.epam.osmachko.constant.Constant;
import com.epam.osmachko.domain.UserDomain;
import com.epam.osmachko.entity.Category;
import com.epam.osmachko.entity.User;
import com.epam.osmachko.service.CategoryService;
import com.epam.osmachko.service.MySQLUserService;

/**
 * Servlet implementation class LoginServlet
 */

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public static final Logger LOGGER = Logger.getLogger(LoginServlet.class);
	
	private CaptchaManager manager;
	
	private MySQLUserService service;
	
	private CategoryService categoryService;
	
	@Override
	public void init() throws ServletException {
		manager = (CaptchaManager) getServletContext().getAttribute("manager");
		service = (MySQLUserService) getServletContext().getAttribute(Constant.USER_SERVICE);
		categoryService = (CategoryService) getServletContext().getAttribute(Constant.CATEGORY_SERVICE);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.getRequestDispatcher(Constant.FORWARD_START_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegistrationFormBean bean = RegistrationFormBean.createFormBean(request);
		InputFormValidator validator = new InputFormValidator();
		Map<String,String> errors = validator.validateInputForm(bean);
//		UserService service = new UserService();
		User user = null;
		List<Category> categories = categoryService.getAllCategory();
		boolean reuslt = manager.validate(request, response);
		if(errors.size() == 0 && reuslt == true) {
			if(service.isUserExists(bean.getLogin())){
				errors.put("login", "User with this login is already exists!");
			} else {
				user = UserDomain.transfirtToDomain(bean);
				service.create(user);
			}
		}
		if(errors.size() == 0 && reuslt == true) {
			request.getSession().setAttribute("regUser", user);
//			response.sendRedirect("MainPageServlet");
			response.sendRedirect("index2version.jsp");
		} else {
			bean.setPassword("");
			request.setAttribute("user", bean);
			request.setAttribute("errors", errors);
			doGet(request, response);
		}
		
		
	}
	
	

}
