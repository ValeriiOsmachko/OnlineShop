package com.epam.osmachko.service;

import java.sql.SQLException;

import com.epam.osmachko.DBConnection.TransactionManager;
import com.epam.osmachko.DBConnection.TransactionOperation;
import com.epam.osmachko.Dao.Impl.ProductDaoimpl;
import com.epam.osmachko.entity.Product;

public class ProductService {
	
	private ProductDaoimpl productDaoImpl;
	
	private TransactionManager manager;

	public ProductService(ProductDaoimpl daoImpl, TransactionManager manager) {
		this.productDaoImpl = daoImpl;
		this.manager = manager;
	}

	public Product getProductById(Integer idProduct) {
		return manager.doInTransaction(new TransactionOperation<Product>() {
			public Product doInTransaction() throws SQLException {
				return productDaoImpl.getProductById(idProduct);
			}
		});
	}
	
	
	
}
