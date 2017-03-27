package com.epam.osmachko.sqlbuilder.builder;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.epam.osmachko.sqlbuilder.Context;
import com.epam.osmachko.sqlbuilder.Database;
import com.epam.osmachko.sqlbuilder.builder.insert.Insert;
import com.epam.osmachko.sqlbuilder.delete.Delete;
import com.epam.osmachko.sqlbuilder.select.Select;
import com.epam.osmachko.sqlbuilder.update.Update;

public class QueryBuilder {

	private final Context context;

//	public QueryBuilder(Database database, DataSource dataSource) throws SQLException {
//		this(database, dataSource.getConnection());
//	}

	public QueryBuilder( Connection connection) {
		this.context = new Context(connection);
	}

	
	public Select select() {
		return new Select(context);
	}

	public Update update() {
		return new Update(context);
	}

	public Update update(String table) {
		return new Update(context, table);
	}

	public Delete delete() {
		return new Delete(context);
	}

	public Delete delete(String table) {
		return new Delete(context, table);
	}

	public Insert insert() {
		return new Insert(context);
	}

	public Insert insert(String table) {
		return new Insert(context, table);
	}

	@Override
	public String toString() {
		return context.toString();
	}
	
}
