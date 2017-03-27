package com.epam.osmachko.service;

import java.util.List;

import com.epam.osmachko.DBConnection.TransactionManager;
import com.epam.osmachko.DBConnection.TransactionOperation;
import com.epam.osmachko.Dao.Impl.PriceDaoImpl;
import com.epam.osmachko.entity.Category;
import com.epam.osmachko.entity.Product;

public class PriceSevice {
	
	private PriceDaoImpl categoryRepository;
	
	private TransactionManager manager;

	public PriceSevice(PriceDaoImpl categoryRepository, TransactionManager manager) {
		this.categoryRepository = categoryRepository;
		this.manager = manager;
	}
	
	
	public List<Product> getAllProducts() {
		return manager.doInTransaction(new TransactionOperation<List<Product>>() {
			public List<Product> doInTransaction() {
				return categoryRepository.getAllManufacturers();
			}
		});
	}
	
	
	
}
