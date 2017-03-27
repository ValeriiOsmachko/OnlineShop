package com.epam.osmachko.DBConnection;

import java.sql.Connection;

public class JdbcConnectionHolder {

	private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<>();
	
	public static Connection getConnection() {
		return connectionHolder.get();
	}
	
	public static void setConnection(Connection connection) {
		connectionHolder.set(connection);
	}
}
