package com.epam.osmachko.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import com.epam.osmachko.constant.Constant;
import com.epam.osmachko.exception.BusinessLogicException;

public class TransactionManager {
	
	private static final Logger LOGGER = Logger.getLogger(TransactionManager.class);

	private DataSource dataSource;

	public TransactionManager(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public <T> T doInTransaction(TransactionOperation op) {
		T result = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			JdbcConnectionHolder.setConnection(connection);
			result = (T) op.doInTransaction();
			connection.commit();
		} catch(Throwable thr) {
			try {
				connection.rollback();
			} catch(SQLException ex) {
				ex.printStackTrace();
				LOGGER.error(Constant.ROLLBACK_ERROR, ex);
			}
			throw new BusinessLogicException(Constant.TRANSACTION_ERROR, thr);
			
			
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JdbcConnectionHolder.setConnection(null);
		}
		return result;
		
	}
	
}
