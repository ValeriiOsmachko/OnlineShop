package com.epam.osmachko.Dao.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import com.epam.osmachko.DBConnection.JdbcConnectionHolder;
import com.epam.osmachko.cart.OrderInfo;
import com.epam.osmachko.constant.Constant;
import com.epam.osmachko.exception.DataBaseException;
import com.epam.osmachko.order.Order;
import com.epam.osmachko.query.Query;

public class OrderDaoImpl {
	
	
	public void addOrder(Order order)  {
		Connection connection = JdbcConnectionHolder.getConnection();
		try(java.sql.PreparedStatement statement =  connection.prepareStatement(Query.INSERT_ORDER)) {
			unmapper(statement, order);
			insertCartInfo(order.getId(), order.getList());
		} catch (SQLException e) {
			DataBaseException e1 = new DataBaseException(Constant.ERROR_MESSAGE, e);
			throw e1;
		}
	}
	
	
	private void unmapper(java.sql.PreparedStatement statement ,Order order)  {
		try {
		statement.setString(1, order.getId());
		statement.setString(2, order.getStatusOfOrfer().toString());
		Timestamp timestamp = new Timestamp(order.getDate().getTime());
		statement.setTimestamp(3, timestamp);
		statement.setInt(4, order.getUser().getId());
		statement.setString(5, order.getState());
		statement.setString(6, order.getUuid());
		statement.setString(7, order.getAddress());
		statement.setString(8, order.getCardNumber());
		statement.executeUpdate();
		} catch (SQLException e) {
			throw new DataBaseException(Constant.ERROR_MESSAGE, e);
		}
	}
	
	
	private void insertCartInfo(String id, List<OrderInfo> list) {
		Connection connection = JdbcConnectionHolder.getConnection();
		try(java.sql.PreparedStatement statement =  connection.prepareStatement(Query.INSERT_CART_INFO)) {
			unmapperOrderInfo(statement,id, list);
		} catch (SQLException e) {
			DataBaseException e1 = new DataBaseException(Constant.ERROR_MESSAGE, e);
			throw e1;
		}
	}
	
	
	private void unmapperOrderInfo(java.sql.PreparedStatement statement,String id, List<OrderInfo> list)  {
		try {
		for(OrderInfo element : list) {	
		statement.setString(1, id);
		statement.setInt(2, element.getProduct().getIdProduct());
		statement.setInt(3, element.getAmount());
		statement.setDouble(4, element.getPriceAtTheMomentOfPurchase());
		statement.executeUpdate();
		}
		} catch (SQLException e) {
			throw new DataBaseException(Constant.ERROR_MESSAGE, e);
		}
	}
	
}
