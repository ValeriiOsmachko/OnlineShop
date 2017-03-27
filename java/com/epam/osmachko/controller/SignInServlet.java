package com.epam.osmachko.controller;

import java.io.IOException;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.osmachko.ValidatorUtil.InputFormValidator;
import com.epam.osmachko.bean.LoginFormBean;
import com.epam.osmachko.constant.Constant;
import com.epam.osmachko.entity.User;
import com.epam.osmachko.password_hash_algorithm.PasswordHash;
import com.epam.osmachko.service.MySQLUserService;
import com.epam.osmachko.util.UserStatusChecker;

/**
 * Servlet implementation class SignInServlet
 */
//@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
	
	public static final Logger LOGGER = Logger.getLogger(SignInServlet.class);
	
	private static final long serialVersionUID = 1L;
	
	
	private MySQLUserService service;
	@Override
	public void init() throws ServletException {
		service = (MySQLUserService) getServletContext().getAttribute(Constant.USER_SERVICE);
	}

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
		LoginFormBean bean = LoginFormBean.createFormBean(request);
		InputFormValidator validator = new InputFormValidator();
		Map<String,String> errors = validator.validateInputForm(bean);
		User user = null;
		if(errors.size() == 0) {
			user = service.getUserByLogin(bean.getLogin());
			System.out.println("USER = " + user.toString());
			PasswordHash passwordHash = new PasswordHash();
			String hashPass = passwordHash.md5Apache(bean.getPassword());
			UserStatusChecker userStatusChecker = new UserStatusChecker(service);
			if(user != null  && userStatusChecker.checkUserStatus(user) && hashPass.equals(user.getPassword())) {
			request.getSession().setAttribute("logUser", user);
			service.unBanUser(user);
			service.setAmountOfWrongLoginAttemps(user);
			} else {
				Integer newAmount = user.getQuantityWrongLoginAttemps() + 1;
				user.setQuantityWrongLoginAttemps(newAmount);
				if(newAmount > Constant.AMOUNT_OF_WRONG_INPUT) {
					if(user.getBanTime() == null) {
					service.banUser(user);
					}
					request.getSession().setAttribute("ban", "You were baned for " + Constant.TIME_OF_BAN + " minutes");
				}
				service.insertIncorrectInput(user);
			}
			response.sendRedirect("index2version.jsp");
		} else {
			response.sendRedirect("index2version.jsp");
		}
	}

}
