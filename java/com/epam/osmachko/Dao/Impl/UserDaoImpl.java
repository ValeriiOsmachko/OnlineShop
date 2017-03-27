package com.epam.osmachko.Dao.Impl;

import java.sql.Connection;
import java.util.List;

import com.epam.osmachko.Dao.UserDao;
import com.epam.osmachko.entity.User;
import com.epam.osmachko.storage.Strorage;

public class UserDaoImpl implements UserDao {

	public void addUser(User user) {
		Strorage.STORAGE.add(user);
	}

	public void removeUser(User user) {
		Strorage.STORAGE.remove(user);
	}

	public void updateUser(Integer id,User user) {
		Strorage.STORAGE.set(id, user);
	}

	public List<User> getAllUsers() {
		return Strorage.STORAGE;
	}

	@Override
	public User getUserByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
