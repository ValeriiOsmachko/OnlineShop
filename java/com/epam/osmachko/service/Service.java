package com.epam.osmachko.service;

import java.util.List;

import com.epam.osmachko.entity.User;

public interface Service {

	 boolean isUserExists(String login);
	 
	 void create(User user);
	 
	 void removeUser(User user);
	 
	 void updateUser(Integer id, User user);

	 List<User> getAll();
	
}
