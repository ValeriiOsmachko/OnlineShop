package com.epam.osmachko.sqlbuilder.select;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.epam.osmachko.sqlbuilder.Context;

public class From {

	private Context context;

	private boolean terminated = false;

	private final List<String> tables = new ArrayList<>();

	From(Context context) {
		this.context = context;
		this.context.appendLine("FROM");
	}

	public From table(String table) {
		tables.add(table);
		return this;
	}

	public From tables(String... tables) {
		this.tables.addAll(Arrays.asList(tables));
		return this;
	}

	public From select(String selectQuery, String alias) {
		this.tables.add("(" + selectQuery + ") " + alias);
		return this;
	}

	public Where where() {
		terminate();
		return new Where(context);
	}

	public Where where(String condition) {
		terminate();
		return new Where(context, condition);
	}


	public <E> List<E> list(RowMapper<E> rowMapper) throws SQLException {
		terminate();
		return context.list(rowMapper);
	}

	public <E> E single(RowMapper<E> rowMapper) throws SQLException {
		terminate();
		return context.single(rowMapper);
	}

	@Override
	public String toString() {
		terminate();
		return context.toString();
	}

	private void terminate() {
		if (!terminated) {
			final String newLine = System.getProperty("line.separator");
			this.context.appendLine(StringUtils.join(tables, "," + newLine));
			this.context.appendLine(newLine);
			terminated = true;
		}
	}
}
