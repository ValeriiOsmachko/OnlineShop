package com.epam.osmachko.bean;

import javax.servlet.http.HttpServletRequest;

public class RegistrationFormBean {
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String login;

	public RegistrationFormBean(String firstName, String lastName, String email, String password, String login) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "RegistrationFormBean is = [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", login=" + login + "]";
	}
	
	
	public static RegistrationFormBean createFormBean(HttpServletRequest request) {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String login = request.getParameter("login");
		RegistrationFormBean form = new RegistrationFormBean(firstName, lastName, email, password, login);
		return form;	
	}
	
	
	
	
	
}
