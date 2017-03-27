package com.epam.osmachko.entity;

public class Category {

	private Integer id;
	
	private String category;
	
	public Category() {
		
	}

	public Category(Integer id, String category) {
		this.id = id;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Category : [id=" + id + ", category=" + category + "]";
	}
	
	
	
	
	
	
	
}
