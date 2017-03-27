package com.epam.osmachko.sqlbuilder;

import java.util.List;

public class FilterCriteria {

	private Integer currentPage;
	
	private Integer maxProductsOnPage;
	
	private Integer totalPages;
	
	private Integer priceFrom;
	
	private Integer priceTo;
	
	private List<Integer> categories;
	
	private List<Integer> manufacturers;
	
	private String name;
	
	private String sortBy;
	
	 
	public FilterCriteria(Integer priceFrom, Integer priceTo, List<Integer> categories, List<Integer> manufacturers,
			String name, String sortBy) {
		this.priceFrom = priceFrom;
		this.priceTo = priceTo;
		this.categories = categories;
		this.manufacturers = manufacturers;
		this.name = name;
		this.sortBy = sortBy;
	}
	
	public FilterCriteria() {
		
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPriceFrom() {
		return priceFrom;
	}

	public void setPriceFrom(Integer priceFrom) {
		this.priceFrom = priceFrom;
	}

	public Integer getPriceTo() {
		return priceTo;
	}

	public void setPriceTo(Integer priceTo) {
		this.priceTo = priceTo;
	}

	public List<Integer> getCategories() {
		return categories;
	}

	public void setCategories(List<Integer> categories) {
		this.categories = categories;
	}

	public List<Integer> getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(List<Integer> manufacturers) {
		this.manufacturers = manufacturers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public Integer getMaxProductsOnPage() {
		return maxProductsOnPage;
	}

	public void setMaxProductsOnPage(Integer maxProductsOnPage) {
		this.maxProductsOnPage = maxProductsOnPage;
	}

	
	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	@Override
	public String toString() {
		return "FilterCriteria [currentPage=" + currentPage + ", maxProductsOnPage=" + maxProductsOnPage
				+ ", priceFrom=" + priceFrom + ", priceTo=" + priceTo + ", categories=" + categories
				+ ", manufacturers=" + manufacturers + ", name=" + name + ", sortBy=" + sortBy + "]";
	}
	
	
	
	
	
}
