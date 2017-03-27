package com.epam.osmachko.entity;

import java.util.Date;

public class User {
	
	private Integer id;
	
	private String login;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Integer quantityWrongLoginAttemps;
	
	private Date banTime;
	
	private String role;
	
	
	

	public User(Integer id, String login, String password, String firstName, String lastName, String email) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	
	
	
	
	public User(Integer id, String login, String password, String firstName, String lastName, String email,
			Integer quantityWrongLoginAttemps, Date banTime) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.quantityWrongLoginAttemps = quantityWrongLoginAttemps;
		this.banTime = banTime;
	}

	




	public User(Integer id, String login, String password, String firstName, String lastName, String email,
			Integer quantityWrongLoginAttemps, Date banTime, String role) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.quantityWrongLoginAttemps = quantityWrongLoginAttemps;
		this.banTime = banTime;
		this.role = role;
	}






	public User() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	

	public Integer getQuantityWrongLoginAttemps() {
		return quantityWrongLoginAttemps;
	}


	public void setQuantityWrongLoginAttemps(Integer quantityWrongLoginAttemps) {
		this.quantityWrongLoginAttemps = quantityWrongLoginAttemps;
	}

	public Date getBanTime() {
		return banTime;
	}

	public void setBanTime(Date banTime) {
		this.banTime = banTime;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", quantityWrongLoginAttemps="
				+ quantityWrongLoginAttemps + ", banTime=" + banTime + "]";
	}







	
	
	

}
