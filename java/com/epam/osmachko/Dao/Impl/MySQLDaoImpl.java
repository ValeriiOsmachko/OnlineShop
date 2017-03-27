package com.epam.osmachko.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import com.epam.osmachko.DBConnection.JdbcConnectionHolder;
import com.epam.osmachko.Dao.UserDao;
import com.epam.osmachko.constant.Constant;
import com.epam.osmachko.entity.User;
import com.epam.osmachko.exception.DataBaseException;
import com.epam.osmachko.query.Query;


public class MySQLDaoImpl implements UserDao {
	
	
	private static final Logger LOGGER = Logger.getLogger(MySQLDaoImpl.class);

	public void addUser(User user)  {
		Connection connection = JdbcConnectionHolder.getConnection();
		try(java.sql.PreparedStatement statement =  connection.prepareStatement(Query.INSERT_USER)) {
			unmapper(statement, user);
		} catch (SQLException e) {
			LOGGER.error(Constant.ERROR_MESSAGE, e);
			throw new DataBaseException(Constant.ERROR_MESSAGE, e);
		}
	}

	public void removeUser(User user) throws DataBaseException {
		Connection connection = JdbcConnectionHolder.getConnection();
		try(PreparedStatement statement =  connection.prepareStatement(Query.DELETE_USER)) {
			statement.setInt(1, user.getId());
			statement.executeUpdate();
		}catch(SQLException e) {
			LOGGER.error(Constant.ERROR_MESSAGE, e);
			throw new DataBaseException(Constant.ERROR_MESSAGE, e);
		}                                               
		
	}

	public void updateUser(Integer id, User user) {
		Connection connection = JdbcConnectionHolder.getConnection();
		try(PreparedStatement statement = (PreparedStatement) connection.prepareStatement(Query.UPDATE_USER)) {
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getLogin());
			statement.setInt(6, id);
			statement.executeUpdate();
		}catch(SQLException e) {
			LOGGER.error(Constant.ERROR_MESSAGE, e);
			throw new DataBaseException(Constant.ERROR_MESSAGE, e);
		}
		
	}

	public List<User> getAllUsers()  {
		Connection connection = JdbcConnectionHolder.getConnection();
		List<User> users = new ArrayList<User>();
		try(java.sql.Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(Query.GET_ALL_USERS)) {
			while(rs.next()) {
				users.add(mapper(rs));
			}
		} catch (SQLException e) {
			LOGGER.error(Constant.ERROR_MESSAGE, e);
			throw new DataBaseException(Constant.ERROR_MESSAGE, e);
		}
		return users;
	}
	
	
	
	@Override
	public User getUserByLogin(String login) {
		Connection connection = JdbcConnectionHolder.getConnection();
		User user = null;
		try(java.sql.PreparedStatement statement = connection.prepareStatement(Query.GET_USER_BY_LOGIN)) {
			statement.setString(1, login);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
			user = mapper(rs);	
			}
		} catch (SQLException e) {
			LOGGER.error(Constant.ERROR_MESSAGE, e);
			throw new DataBaseException(Constant.ERROR_MESSAGE, e);
		}
		return user;
		
		
	}
	
	/**
	 * Method builds User form ResultSet.
	 * @param set
	 * @return
	 */
	private User mapper(ResultSet set)  {
		User user  = new User();
		try {
		user.setId(set.getInt("id"));
		user.setFirstName(set.getString("first_name"));
		user.setLastName(set.getString("last_name"));
		user.setEmail(set.getString("email"));
		user.setPassword(set.getString("password"));
		user.setLogin(set.getString("login"));
		user.setQuantityWrongLoginAttemps(set.getInt("amountOfWrongLoginAttemps"));
		Timestamp stamp = set.getTimestamp("banTime");
		if(stamp != null) {
			Date date = new Date(stamp.getTime());
			user.setBanTime(date);
		} else {
			user.setBanTime(null);
		}
		user.setRole(set.getString("role"));
		} catch (SQLException e) {
			LOGGER.error(Constant.ERROR_MESSAGE, e);
			throw new DataBaseException(Constant.ERROR_MESSAGE, e);
		}
		return user;
	}
	
	/**
	 * Method parse User into ResultSet.
	 * @param statement
	 * @param user
	 * @throws SQLException 
	 */
	private void unmapper(java.sql.PreparedStatement statement ,User user)  {
		try {
		statement.setString(1, user.getFirstName());
		statement.setString(2, user.getLastName());
		statement.setString(3, user.getEmail());
		statement.setString(4, user.getPassword());
		statement.setString(5, user.getLogin());
		statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(Constant.ERROR_MESSAGE, e);
			throw new DataBaseException(Constant.ERROR_MESSAGE, e);
		}
	}
	
	public void insertIncorrectInput(User user) {
		Connection connection = JdbcConnectionHolder.getConnection();
		try(PreparedStatement statement =  connection.prepareStatement(Query.INSERT_INCORRECT_LOGIN_INPUT)) {
			unmapperIncorrectInput(statement, user);
		} catch (SQLException e) {
			LOGGER.error(Constant.ERROR_MESSAGE, e);
			throw new DataBaseException(Constant.ERROR_MESSAGE, e);
		}
	}
	
	private void unmapperIncorrectInput(java.sql.PreparedStatement statement ,User user)  {
		try {
		statement.setInt(1, user.getQuantityWrongLoginAttemps());
		statement.setString(2, user.getLogin());
		statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(Constant.ERROR_MESSAGE, e);
			throw new DataBaseException(Constant.ERROR_MESSAGE, e);
		}
	}

	public void banUser(User user) {
		Connection connection = JdbcConnectionHolder.getConnection();
		try(java.sql.PreparedStatement statement =  connection.prepareStatement(Query.BAN_USER)) {
			unmapperBanUser(statement, user);
		} catch (SQLException e) {
			LOGGER.error(Constant.ERROR_MESSAGE, e);
			throw new DataBaseException(Constant.ERROR_MESSAGE, e);
		}
		
	}
	
	private void unmapperBanUser(java.sql.PreparedStatement statement ,User user)  {
		try {
		statement.setTimestamp(1, new Timestamp(new Date().getTime()));
		statement.setString(2, user.getLogin());
		statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(Constant.ERROR_MESSAGE, e);
			throw new DataBaseException(Constant.ERROR_MESSAGE, e);
		}
	}
	
	public void unBanUser(User user) {
		Connection connection = JdbcConnectionHolder.getConnection();
		try(java.sql.PreparedStatement statement =  connection.prepareStatement(Query.BAN_USER)) {
			unmapperUnBanUser(statement, user);
		} catch (SQLException e) {
			LOGGER.error(Constant.ERROR_MESSAGE, e);
			throw new DataBaseException(Constant.ERROR_MESSAGE, e);
		}
	}
	
	private void unmapperUnBanUser(java.sql.PreparedStatement statement ,User user)  {
		try {
		statement.setTimestamp(1, null);
		statement.setString(2, user.getLogin());
		statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(Constant.ERROR_MESSAGE, e);
			throw new DataBaseException(Constant.ERROR_MESSAGE, e);
		}
	}
	
	public void setAmountOfWrongLoginAttemps(User user) {
		Connection connection = JdbcConnectionHolder.getConnection();
		try(java.sql.PreparedStatement statement =  connection.prepareStatement(Query.SET_BLOCK_AMOUNT)) {
			unmapperBlockingAmount(statement, user);
		} catch (SQLException e) {
			LOGGER.error(Constant.ERROR_MESSAGE, e);
			throw new DataBaseException(Constant.ERROR_MESSAGE, e);
		}
	}
	
	private void unmapperBlockingAmount(java.sql.PreparedStatement statement ,User user)  {
		try {
		statement.setInt(1, 0);
		statement.setString(2, user.getLogin());
		statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(Constant.ERROR_MESSAGE, e);
			throw new DataBaseException(Constant.ERROR_MESSAGE, e);
		}
	}
}
