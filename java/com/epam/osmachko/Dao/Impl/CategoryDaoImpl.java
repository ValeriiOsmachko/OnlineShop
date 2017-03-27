package com.epam.osmachko.Dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.osmachko.DBConnection.JdbcConnectionHolder;
import com.epam.osmachko.constant.Constant;
import com.epam.osmachko.entity.Category;
import com.epam.osmachko.exception.DataBaseException;
import com.epam.osmachko.query.Query;

public class CategoryDaoImpl {

	public static final Logger LOGGER = Logger.getLogger(CategoryDaoImpl.class);
	
	public List<Category> getAllCategory() {
		Connection connection = JdbcConnectionHolder.getConnection();
		List<Category> categories = new ArrayList<Category>();
		try(java.sql.Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(Query.SELECT_ALL_CATEGORIES)) {
			while(rs.next()) {
				categories.add(mapper(rs));
			}
		} catch (SQLException e) {
			DataBaseException e1 = new DataBaseException(Constant.ERROR_MESSAGE, e);
			LOGGER.error(Constant.ERROR_MESSAGE, e1);
			throw e1;
		}
		return categories;
	}
	
	
	private Category mapper(ResultSet set) throws SQLException {
		Category category = new Category();
		category.setId(set.getInt("idCategory"));
		category.setCategory(set.getString("category"));
		return category;
	}
	
}
