package com.epam.osmachko.sqlbuilder.delete;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.commons.lang3.StringUtils;

import com.epam.osmachko.exception.IllegalQueryException;
import com.epam.osmachko.sqlbuilder.Context;

public class Delete {

	private String table;
	private final Context context;
	private final Collection<String> conditions;
	private boolean terminated = false;

	public Delete(Context context) {
		this.context = context;
		this.context.append("DELETE FROM ");
		conditions = new LinkedList<>();
	}

	public Delete(Context context, String table) {
		this(context);
		this.table = table;
	}

	public Delete where(String condition) {
		conditions.add(condition);
		return this;
	}

	public Delete and(String condition) {
		conditions.add(condition);
		return this;
	}

	private void terminate() {
		if (StringUtils.isBlank(table))
			throw new IllegalQueryException("No table specified!");

		if (!terminated) {
			context.append(table);

			if (!conditions.isEmpty()) {
				context.newLine().append("WHERE ");

				Iterator<String> conditionIter = conditions.iterator();

				while (conditionIter.hasNext()) {
					String condition = conditionIter.next();
					context.append(condition);

					if (conditionIter.hasNext()) {
						context.newLine().append("AND ");
					}
				}
			}

			terminated = true;
		}
	}

	@Override
	public String toString() {
		terminate();
		return context.toString();
	}
}
