package com.epam.osmachko.pagination;

public class Pagination {

	private Integer CurrentPage;
	
	private Integer totalNumberOfPages;
	
	private String query;
	
	private Integer totalPages;
	
	

	public Pagination(Integer page, String query) {
		this.CurrentPage = page;
		this.query = query;
	}
	
	public String resultQuery() {
		StringBuilder builder = new StringBuilder(query);
		builder.append(" LIMIT ?, 5");
		return builder.toString();
	}

	

	public Integer getTotalNumberOfPages() {
		return totalNumberOfPages;
	}

	public void setTotalNumberOfPages(Integer totalNumberOfPages) {
		this.totalNumberOfPages = totalNumberOfPages;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Integer getCurrentPage() {
		return CurrentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		CurrentPage = currentPage;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	
	
	
}
