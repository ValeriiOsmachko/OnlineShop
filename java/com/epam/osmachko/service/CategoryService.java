package com.epam.osmachko.service;

import java.util.List;

import com.epam.osmachko.DBConnection.TransactionManager;
import com.epam.osmachko.DBConnection.TransactionOperation;
import com.epam.osmachko.Dao.Impl.CategoryDaoImpl;
import com.epam.osmachko.entity.Category;

public class CategoryService {

	private CategoryDaoImpl categoryRepository;
	
	private TransactionManager manager;

	public CategoryService(CategoryDaoImpl categoryRepository, TransactionManager manager) {
		this.categoryRepository = categoryRepository;
		this.manager = manager;
	}
	
	
	public List<Category> getAllCategory() {
		return manager.doInTransaction(new TransactionOperation<List<Category>>() {
			public List<Category> doInTransaction() {
				return categoryRepository.getAllCategory();
			}
		});
	}
	
	
}
