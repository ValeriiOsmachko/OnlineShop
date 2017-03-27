package com.epam.osmachko.Dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.osmachko.DBConnection.JdbcConnectionHolder;
import com.epam.osmachko.constant.Constant;
import com.epam.osmachko.entity.Product;
import com.epam.osmachko.exception.DataBaseException;
import com.epam.osmachko.query.Query;

public class PriceDaoImpl {

	public static final Logger LOGGER = Logger.getLogger(PriceDaoImpl.class);
	
	public List<Product> getAllManufacturers() {
		Connection connection = JdbcConnectionHolder.getConnection();
		List<Product> manufacturers = new ArrayList<Product>();
		try(java.sql.Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(Query.SELECT_ALL_PRODUCTS)) {
			while(rs.next()) {
				manufacturers.add(mapper(rs));
			}
		} catch (SQLException e) {
			DataBaseException e1 = new DataBaseException(Constant.ERROR_MESSAGE, e);
			LOGGER.error(Constant.ERROR_MESSAGE, e1);
			throw e1;
		}
		return manufacturers;
	}
	
	
	private Product mapper(ResultSet set) throws SQLException {
		Product product = new Product();
		product.setIdProduct(set.getInt("idProduct"));
		product.setName(set.getString("Name"));
		product.setPrice(set.getDouble("price"));
		product.setManufacturer(set.getString("Manufacturer_idManufacturer"));
		product.setCategory(set.getString("Category_idCategory"));
		product.setDescription(set.getString("description"));
		return product;
	}
	
}
