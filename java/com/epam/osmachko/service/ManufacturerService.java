package com.epam.osmachko.service;

import java.util.List;

import com.epam.osmachko.DBConnection.TransactionManager;
import com.epam.osmachko.DBConnection.TransactionOperation;
import com.epam.osmachko.Dao.Impl.ManufacturerDaoOImpl;
import com.epam.osmachko.entity.Category;
import com.epam.osmachko.entity.Manufacturer;

public class ManufacturerService {

	private ManufacturerDaoOImpl manufacturerRepository;
	
	private TransactionManager manager;

	public ManufacturerService(ManufacturerDaoOImpl categoryRepository, TransactionManager manager) {
		this.manufacturerRepository = categoryRepository;
		this.manager = manager;
	}
	
	public List<Manufacturer> getAllManufacturers() {
		return manager.doInTransaction(new TransactionOperation<List<Manufacturer>>() {
			public List<Manufacturer> doInTransaction() {
				return manufacturerRepository.getAllManufacturers();
			}
		});
	}
	
	
	
}
