package com.epam.osmachko.bean;

import javax.servlet.http.HttpServletRequest;

public class LoginFormBean {

	private String password;

	private String login;

	public LoginFormBean(String password, String login) {
		this.password = password;
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "LoginFormBean [password=" + password + ", login=" + login + "]";
	}
	
	public static LoginFormBean createFormBean(HttpServletRequest request) {
		String password = request.getParameter("password");
		String login = request.getParameter("login");
		LoginFormBean form = new LoginFormBean(password,login);
		return form;	
	}
	
	
}
