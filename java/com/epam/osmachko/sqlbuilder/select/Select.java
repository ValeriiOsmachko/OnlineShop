package com.epam.osmachko.sqlbuilder.select;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.epam.osmachko.sqlbuilder.Context;

public class Select {
	
	private Context context;

	private final List<String> columns;

	public Select(Context context) {
		this.context = context;
		this.context.appendLine("SELECT");
		columns = new LinkedList<>();
	}

	public From from() {
		this.context.appendLine(StringUtils.join(columns, ",\n"));
		return new From(context);
	}

	public Select all() {
		append("*");
		return this;
	}

	public Select column(String column) {
		append(column);
		return this;
	}

	public Select columns(String... columns) {
		for (String column : columns) {
			append(column);
		}

		return this;
	}

	public Select count(String column) {
		append("COUNT(" + column + ")");
		return this;
	}

	private void append(String expression) {
		columns.add(expression);
	}

	@Override
	public String toString() {
		return context.toString();
	}
}
