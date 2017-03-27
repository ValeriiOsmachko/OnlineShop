package com.epam.osmachko.service;

import java.sql.SQLException;
import java.util.List;

import java.util.Map;

import com.epam.osmachko.DBConnection.TransactionManager;
import com.epam.osmachko.DBConnection.TransactionOperation;
import com.epam.osmachko.Dao.Impl.ProductDaoimpl;
import com.epam.osmachko.entity.Product;
import com.epam.osmachko.sqlbuilder.FilterCriteria;

public class FilterService {

	private ProductDaoimpl productRepository;

	private TransactionManager manager;

	public FilterService(ProductDaoimpl productRepository, TransactionManager manager) {
		this.productRepository = productRepository;
		this.manager = manager;
	}
	

	public List<Product> selectProductsByFilters(Integer numberOfLastIndex,Integer number,String query,Map<String,String[]> map) {
		return manager.doInTransaction(new TransactionOperation<List<Product>>() {
			public List<Product> doInTransaction() {
				return productRepository.selectProductsWithFilter(numberOfLastIndex,number,query,map);
			}
		});
	}
	
	
	public Integer countProductsByFilters(String query,Map<String,String[]> map) {
		return manager.doInTransaction(new TransactionOperation<Integer>() {
			public Integer doInTransaction() {
				return productRepository.countProdicts(query, map);
			}
		});
	}
	
	
	public List<Product> selectAll(Integer currentPage,String query,FilterCriteria criteria) {
		return manager.doInTransaction(new TransactionOperation<List<Product>>() {
			public List<Product> doInTransaction() {
				return productRepository.selectAll(currentPage,query,criteria);
			}
		});
	}
	
	
	public Integer getTotalAmount(String query,FilterCriteria criteria) {
		return manager.doInTransaction(new TransactionOperation<Integer>() {
			public Integer doInTransaction() throws SQLException {
				return productRepository.getTotalAmount(query, criteria);
			}
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}










