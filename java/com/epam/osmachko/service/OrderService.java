package com.epam.osmachko.service;

import com.epam.osmachko.DBConnection.TransactionManager;
import com.epam.osmachko.DBConnection.TransactionOperation;
import com.epam.osmachko.Dao.Impl.OrderDaoImpl;
import com.epam.osmachko.order.Order;

public class OrderService {
	
	private OrderDaoImpl orderDao;
	
	private TransactionManager manager;

	public OrderService(OrderDaoImpl productDaoImpl, TransactionManager manager) {
		this.orderDao = productDaoImpl;
		this.manager = manager;
	}
	
	
	public void addOrder(Order order) {
		manager.doInTransaction(new TransactionOperation<Void>() {
			public Void doInTransaction() {
				orderDao.addOrder(order);
				return null;
			}
		});
	}
	
	
	
	
}
