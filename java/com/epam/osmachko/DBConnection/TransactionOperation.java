package com.epam.osmachko.DBConnection;

import java.sql.SQLException;


public abstract class TransactionOperation<T> {

	public abstract <T> T doInTransaction() throws SQLException ;
	
}
