package com.epam.osmachko.sqlbuilder;

public class ItemFilter {
	
	private String filterName;
	
	private String condition;
	
	private String filterValue;
	
	public ItemFilter() {
		
	}
	
	public ItemFilter(String filterName, String condition, String filterValue) {
		this.filterName = filterName;
		this.condition = condition;
		this.filterValue = filterValue;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getFilterValue() {
		return filterValue;
	}

	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}

	@Override
	public String toString() {
		return   filterName + " " + condition + " " + filterValue + " ";
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
