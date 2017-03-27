package com.epam.osmachko.service;

import java.sql.Connection;
import java.util.List;

import com.epam.osmachko.Dao.Impl.UserDaoImpl;
import com.epam.osmachko.entity.User;

public class UserService implements Service {
	
	private UserDaoImpl userDaoImpl;

	public UserService() {
		userDaoImpl = new UserDaoImpl(); 
	}

	public UserDaoImpl getUserDaoImpl() {
		return userDaoImpl;
	}
	
	
	public boolean isUserExists(String login) {
		for(User user : userDaoImpl.getAllUsers()) {
			if(user.getLogin().equals(login)) {
				return true;
			}
		}
		return false;
	}
	
	
	public void create(User user) {
		userDaoImpl.getAllUsers().add(user);
	}

	public void removeUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void updateUser(Integer id, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
