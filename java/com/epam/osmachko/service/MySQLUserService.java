package com.epam.osmachko.service;


import java.util.List;

import javax.sql.DataSource;

import com.epam.osmachko.DBConnection.TransactionManager;
import com.epam.osmachko.DBConnection.TransactionOperation;
import com.epam.osmachko.Dao.Impl.MySQLDaoImpl;
import com.epam.osmachko.entity.User;

public class MySQLUserService implements Service {
	
	private MySQLDaoImpl userRepository;
		
	private TransactionManager manager;
	
	public MySQLUserService(MySQLDaoImpl dao, TransactionManager manager) {
		this.userRepository = dao;
		this.manager = manager;
	}

	public boolean isUserExists(String login) {
		return false;
	}

	public void create(User user) {
		manager.doInTransaction(new TransactionOperation<Void>() {
			public Void doInTransaction() {
				userRepository.addUser(user);
				return null;
			}
		});
	}

	public void removeUser(User user) {
		manager.doInTransaction(new TransactionOperation<Void>() {
			public Void doInTransaction() {
				userRepository.removeUser(user);
				return null;
			}
		});
	}

	public void updateUser(Integer id, User user) {
		manager.doInTransaction(new TransactionOperation<Void>() {
			public Void doInTransaction() {
				userRepository.updateUser(id, user);
				return null;
			}
		});
	}

	@Override
	public List<User> getAll() {
		return manager.doInTransaction(new TransactionOperation<List<User>>() {
			public List<User> doInTransaction() {
				return userRepository.getAllUsers();
			}
		});
	}
	
	
	public User getUserByLogin(String login) {
		return manager.doInTransaction(new TransactionOperation<User>() {
			public User doInTransaction()  {
				return userRepository.getUserByLogin(login);
			}
		});
	}
	
	public void insertIncorrectInput(User user) {
		manager.doInTransaction(new TransactionOperation<Void>() {
			public Void doInTransaction() {
				userRepository.insertIncorrectInput(user);
				return null;
			}
		});
	}
	
	public void banUser(User user) {
		manager.doInTransaction(new TransactionOperation<Void>() {
			public Void doInTransaction() {
				userRepository.banUser(user);
				return null;
			}
		});
	}
	
	public void unBanUser(User user) {
		manager.doInTransaction(new TransactionOperation<Void>() {
			public Void doInTransaction() {
				userRepository.unBanUser(user);
				return null;
			}
		});
	}
	
	public void setAmountOfWrongLoginAttemps(User user) {
		manager.doInTransaction(new TransactionOperation<Void>() {
			public Void doInTransaction() {
				userRepository.setAmountOfWrongLoginAttemps(user);
				return null;
			}
		});
	}
	
	
	
	
	
	
	

}
