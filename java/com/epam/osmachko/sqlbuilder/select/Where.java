package com.epam.osmachko.sqlbuilder.select;

import com.epam.osmachko.sqlbuilder.Context;

public class Where extends Condition {

	Where(Context context) {
		super(context);
		add("1 = 1");
	}

	Where(Context context, String condition) {
		super(context);
		add(condition);
	}


	@Override
	protected String getPrefix() {
		return "WHERE";
	}

	@Override
	public String toString() {
		return context.toString();
	}
}
