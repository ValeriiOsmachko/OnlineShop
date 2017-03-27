package com.epam.osmachko.Dao;

import java.sql.Connection;
import java.util.List;

import com.epam.osmachko.entity.User;
import com.epam.osmachko.exception.DataBaseException;

public interface UserDao {

	/**
	 * Create and user into DataBase.
	 * @param user
	 */
	void addUser(User user) throws DataBaseException;
	
	/**
	 * Remove user.
	 * @param user
	 */
	void removeUser(User user) throws DataBaseException;
	
	/**
	 * Update user.
	 * @param id
	 * @param user
	 */
	void updateUser(Integer id, User user) throws DataBaseException;
	
	/**
	 * Get Add users from DataBase.
	 * @return
	 */
	List<User> getAllUsers() throws DataBaseException;
	
	User getUserByLogin(String login) throws DataBaseException;
	
	
	
}
