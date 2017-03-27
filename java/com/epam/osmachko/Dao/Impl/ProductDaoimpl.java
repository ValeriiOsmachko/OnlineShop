package com.epam.osmachko.Dao.Impl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import com.epam.osmachko.DBConnection.JdbcConnectionHolder;
import com.epam.osmachko.constant.Constant;
import com.epam.osmachko.entity.Product;
import com.epam.osmachko.exception.DataBaseException;
import com.epam.osmachko.query.Query;
import com.epam.osmachko.sqlbuilder.FilterCriteria;


public class ProductDaoimpl {

	private static final Logger LOGGER = Logger.getLogger(ProductDaoimpl.class);
	

	public List<Product> selectProductsWithFilter(Integer numberOfLastIndex,Integer number,String query,Map<String,String[]> map) {
		Connection connection = JdbcConnectionHolder.getConnection();
		List<Product> products = new ArrayList<Product>();
		try(java.sql.PreparedStatement statement = connection.prepareStatement(query)) {
				fillStatement(numberOfLastIndex,number,map, statement);
				statement.executeQuery();
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				products.add(mapper(rs));
			}
		} catch (SQLException e) {
			DataBaseException e1 = new DataBaseException(Constant.ERROR_MESSAGE, e);
			LOGGER.error(Constant.ERROR_MESSAGE, e1);
			throw e1;
		}
		return products;
	}
		
	private Product mapper(ResultSet set) throws SQLException {
		Product product = new Product();
		product.setIdProduct(set.getInt("idProduct"));
		product.setCategory(set.getString("Category_idCategory"));
		product.setName(set.getString("Name"));
		product.setPrice(set.getDouble("price"));
		product.setManufacturer(set.getString("Manufacturer_idManufacturer"));
		product.setDescription(set.getString("description"));
		return product;
	}
	
	private void fillStatement(Integer numberOfLastIndex,Integer number,Map<String,String[]> map, java.sql.PreparedStatement statement) throws SQLException {
		int counter = 0;
		for(Map.Entry<String, String[]> entry : map.entrySet()) {
			String [] array = entry.getValue();
			if(array != null && array.length != 0) {
				for(String element : array) {
					if(!entry.getKey().equals("price") && !entry.getKey().equals("sort")) {
					++counter;
					statement.setObject(counter, "%" + element + "%");
					} else if(entry.getKey().equals("price")){
					++counter;
					statement.setObject(counter, Integer.parseInt(element));
					} else if(entry.getKey().equals("sort")) {
						
					}
					
				}
			}
		
		}
		statement.setInt(numberOfLastIndex, number);
	}
	
	private void fillStatement(Map<String,String[]> map, java.sql.PreparedStatement statement) throws SQLException {
		int counter = 0;
		for(Map.Entry<String, String[]> entry : map.entrySet()) {
			String [] array = entry.getValue();
			if(array != null && array.length != 0) {
				for(String element : array) {
					if(!entry.getKey().equals("price") && !entry.getKey().equals("sort")) {
					++counter;
					statement.setObject(counter, "%" + element + "%");
					} else if(entry.getKey().equals("price")){
					++counter;
					statement.setObject(counter, Integer.parseInt(element));
					} else if(entry.getKey().equals("sort")) {
						
					}
					
				}
			}
		
		}
	}
	
	public Integer countProdicts(String query,Map<String,String[]> map) {
		Connection connection = JdbcConnectionHolder.getConnection();
		Integer result = null;
		try(java.sql.PreparedStatement statement = connection.prepareStatement(query)) {
				fillStatement(map, statement);
				statement.executeQuery();
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			DataBaseException e1 = new DataBaseException(Constant.ERROR_MESSAGE, e);
			LOGGER.error(Constant.ERROR_MESSAGE, e1);
			throw e1;
		}
		return result;
	}
	
	
	public List<Product> selectAll(Integer currentPage,String query, FilterCriteria criteria) {
		Connection connection = JdbcConnectionHolder.getConnection();
		List<Product> list = new ArrayList<>();
		try(java.sql.PreparedStatement statement = connection.prepareStatement(query)) {
			fillStmnt(currentPage,statement, criteria);
			statement.executeQuery();
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				list.add(mapper(set));
			}
		}catch (SQLException e) {
			
		}
		return list;
	}
	
	
	private void fillStmnt(Integer currentPage,java.sql.PreparedStatement statement, FilterCriteria criteria) throws SQLException {
		int counter = 1;
		if(criteria.getCategories() != null) {
			for(int i = 0; i<= criteria.getCategories().size() - 1; i++) {
					statement.setObject(counter, i+1);
					++counter;
			}
		}
		if(criteria.getManufacturers() != null) {
			for(int i = 0; i<= criteria.getManufacturers().size() - 1; i++) {
				statement.setObject(counter, i+1);
				++counter;
			}
		}
		if(criteria.getName() != null && criteria.getName().length() != 0) {
			statement.setObject(counter, "%" + criteria.getName() + "%");
			++counter;
		}
		
		if(criteria.getPriceFrom() != null && criteria.getPriceTo() != null) {
			statement.setObject(counter, criteria.getPriceFrom());
			++counter;
			statement.setObject(counter, criteria.getPriceTo());
			++counter;
		}
		
		statement.setObject(counter, (currentPage-1) * 3);
	}
	
	
	public Integer getTotalAmount(String query, FilterCriteria criteria) throws SQLException {
		Connection connection = JdbcConnectionHolder.getConnection();
		Integer amount = null;
		java.sql.PreparedStatement statement = connection.prepareStatement(query); 
			fillStmntCount(statement, criteria);
			statement.executeQuery();
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				amount = set.getInt(1);
			}
		
		return amount;
	}
	
	private void fillStmntCount(java.sql.PreparedStatement statement, FilterCriteria criteria) throws SQLException {
		int counter = 1;
		if(criteria.getCategories() != null) {
			for(int i = 0; i<= criteria.getCategories().size() - 1; i++) {
					statement.setObject(counter, i+1);
					++counter;
			}
		}
		if(criteria.getManufacturers() != null) {
			for(int i = 0; i<= criteria.getManufacturers().size() - 1; i++) {
				statement.setObject(counter, i+1);
				++counter;
			}
		}
		if(criteria.getName() != null && criteria.getName().length() != 0) {
			statement.setObject(counter, "%" + criteria.getName() + "%");
			++counter;
		}
		
		if(criteria.getPriceFrom() != null && criteria.getPriceTo() != null) {
			statement.setObject(counter, criteria.getPriceFrom());
			++counter;
			statement.setObject(counter, criteria.getPriceTo());
			++counter;
		}
		
	}

	public Product getProductById(Integer idProduct) {
		Connection connection = JdbcConnectionHolder.getConnection();
		Product prodcut = new Product();
		try(java.sql.PreparedStatement statement = connection.prepareStatement(Query.SELECT_PRODUCT_BY_ID)) {
			statement.setInt(1, idProduct);
			statement.executeQuery();
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				prodcut = mapper(set);
			}
		}catch(SQLException ex) {
			throw new DataBaseException(Constant.ERROR_MESSAGE, ex);
		}
		return prodcut;
	}
	
	
	
}
