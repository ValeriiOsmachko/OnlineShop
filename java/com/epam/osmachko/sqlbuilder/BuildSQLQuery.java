package com.epam.osmachko.sqlbuilder;

public class BuildSQLQuery {

	private FilterCriteria criteria;

	public BuildSQLQuery(FilterCriteria criteria) {
		this.criteria = criteria;
	}
	
	public String buildQuery() {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT * FROM PRODUCTS ");
		Integer amountOfNull = countNull(criteria);
		if(amountOfNull != 4) {
			builder.append(" WHERE ");
		}
		if(criteria.getCategories() != null) {
			for(int i = 0; i<= criteria.getCategories().size() - 1; i++) {
				builder.append(" Category_idCategory ");
				builder.append(" = ");
				builder.append("?");
				if(i < criteria.getCategories().size() - 1) {
					builder.append(" OR ");
				}
			}
		}
		if(criteria.getManufacturers() != null) {
			if(criteria.getCategories() != null) {
			builder.append(" AND ");
			}
			for(int i = 0; i<= criteria.getManufacturers().size() - 1; i++) {
				builder.append(" Manufacturer_idManufacturer ");
				builder.append(" = ");
				builder.append("?");
				if(i < criteria.getManufacturers().size() - 1) {
					builder.append(" OR ");
				}
			}
		}
		if(criteria.getName() != null && criteria.getName().length() != 0) {
			if(criteria.getManufacturers() != null || criteria.getCategories() != null) {
			builder.append(" AND ");
			}
			builder.append(" Name");
			builder.append(" LIKE ");
			builder.append(" ? ");
		}
		
		if(criteria.getPriceFrom() != null && criteria.getPriceTo() != null) {
			if(criteria.getName() != null && criteria.getName().length() != 0 || criteria.getManufacturers() != null || criteria.getCategories() != null) {
			builder.append(" AND ");
			}
			builder.append("price BETWEEN ");
			builder.append(" ? ");
			builder.append(" AND ");
			builder.append(" ? ");
		}
		
		if(criteria.getSortBy() != null) {
		if(criteria.getSortBy().equals("pDESC")) {
			builder.append(" ORDER BY price DESC");
		}if(criteria.getSortBy().equals("pASC")) {
			builder.append(" ORDER BY price ASC");
		}if(criteria.getSortBy().equals("nDESC")) {
			builder.append(" ORDER BY Name DESC");
		}if(criteria.getSortBy().equals("nASC")) {
			builder.append(" ORDER BY Name ASC");
		}
		}
		
		builder.append(" LIMIT ?,3");
		
		
		return builder.toString();
	}
	
	
	public String buildCountQuery() {
		StringBuilder builder = new StringBuilder();
		Integer amountOfNull = countNull(criteria);
		builder.append("SELECT COUNT(*) FROM PRODUCTS ");
		if(amountOfNull != 4) {
			builder.append(" WHERE ");
		}
		if(criteria.getCategories() != null) {
			for(int i = 0; i<= criteria.getCategories().size() - 1; i++) {
				builder.append(" Category_idCategory ");
				builder.append(" = ");
				builder.append("?");
				if(i < criteria.getCategories().size() - 1) {
					builder.append(" OR ");
				}
			}
		}
		if(criteria.getManufacturers() != null) {
			if(criteria.getCategories() != null) {
			builder.append(" AND ");
			}
			for(int i = 0; i<= criteria.getManufacturers().size() - 1; i++) {
				builder.append(" Manufacturer_idManufacturer ");
				builder.append(" = ");
				builder.append("?");
				if(i < criteria.getManufacturers().size() - 1) {
					builder.append(" OR ");
				}
			}
		}
		if(criteria.getName() != null && criteria.getName().length() != 0) {
			if(criteria.getManufacturers() != null || criteria.getCategories() != null) {
			builder.append(" AND ");
			}
			builder.append("Name");
			builder.append(" LIKE ");
			builder.append(" ? ");
		}
		
		if(criteria.getPriceFrom() != null && criteria.getPriceTo() != null) {
			if(criteria.getName() != null && criteria.getName().length() != 0 || criteria.getManufacturers() != null || criteria.getCategories() != null) {
			builder.append(" AND ");
			}
			builder.append("price BETWEEN ");
			builder.append(" ? ");
			builder.append(" AND ");
			builder.append(" ? ");
		}
		
		if(criteria.getSortBy() != null) {
		if(criteria.getSortBy().equals("pDESC")) {
			builder.append(" ORDER BY price DESC");
		}if(criteria.getSortBy().equals("pASC")) {
			builder.append(" ORDER BY price ASC");
		}if(criteria.getSortBy().equals("nDESC")) {
			builder.append(" ORDER BY Name DESC");
		}if(criteria.getSortBy().equals("nASC")) {
			builder.append(" ORDER BY Name ASC");
		}
		}
		
//		builder.append(" LIMIT ?,3");
		
		
		return builder.toString();
	}
	
	
	
	private Integer countNull(FilterCriteria criteria) {
		Integer counter = 0;
		if(criteria.getCategories() == null) {
			++counter;
		}
		if(criteria.getManufacturers() == null) {
			++counter;
		}
		if(criteria.getName() == null || criteria.getName().length() == 0 ) {
			++counter;
		}
		if(criteria.getPriceFrom() == null || criteria.getPriceTo() == null) {
			++counter;
		}
		return counter;
	}
	
	
	
	
	
}
