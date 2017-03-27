package com.epam.osmachko.sqlbuilder;

import java.util.HashMap;
import java.util.Map;

public class BuildCriteria {

	private Map<String,String> map = new HashMap<>();;
	
	public BuildCriteria() {
		initMap(map);
	}

	public String executeCommands(Map<String, String[]> map) {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT * FROM PRODUCTS ");
		int counter = 0;
		int nullCounter = 0;
		for (Map.Entry<String, String[]> entry : map.entrySet()) {
			if(entry.getValue() == null) {
				++nullCounter;
			}
		}
		
		if(nullCounter < 4) {
			builder.append(" WHERE ");
		for (Map.Entry<String, String[]> entry : map.entrySet()) {
				if(entry.getKey().equals("price")) {
					createPriceSubRequest("price", entry.getValue(), builder);
				}
				if(entry.getKey().equals("Name")) {
					createSubRequest("Name", entry.getValue(), builder);
				}
				if(entry.getKey().equals("Category_idCategory")) {
					createSubRequest("Category_idCategory", entry.getValue(), builder);
				}
				if(entry.getKey().equals("Manufacturer_idManufacturer")) {
					createSubRequest("Manufacturer_idManufacturer", entry.getValue(), builder);
				}
			++counter;
			if (counter < map.size() && !entry.getKey().equals("sort") && entry.getValue() != null && !(nullCounter >= 3)) {
				builder.append(" AND ");
			}
			
		}
		}
		createSortSubRequest(map.get("sort"), builder);
		return builder.toString();
	}

	private void initMap(Map<String, String> map) {
		map.put("Category_idCategory", "LIKE");
		map.put("Name", "LIKE");
		map.put("Manufacturer_idManufacturer", "LIKE");
		map.put("price", "BETWEEN");
	}

	private String executeCondition(String string) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().equals(string)) {
				return entry.getValue();
			}
		}
		return null;
	}
	
	
	private void createSubRequest(String key, String[] array, StringBuilder builder) {
		int counter = 0;
		if(array != null) {
		for(String element : array) {
			ItemFilter filer = new ItemFilter();
			filer.setFilterName(key);
			filer.setCondition(executeCondition(key));
			filer.setFilterValue("?");
			builder.append(filer.toString());
			counter++;
			if(counter < array.length) {
				builder.append(" OR ");
			}
		}
		}
	}
	
	private void createPriceSubRequest(String key, String[] array, StringBuilder builder) {
		if(array != null) {
		builder.append(key);
		builder.append(" BETWEEN ");
		builder.append(" ? ");
		builder.append(" AND ");
		builder.append(" ? ");
		}
	}
	
	private void createSortSubRequest(String[] array, StringBuilder builder) {
		for(String element : array) {
			if(element != null) {
			if(element.equals("pDESC")) {
				builder.append(" ORDER BY price DESC");
			}if(element.equals("pASC")) {
				builder.append(" ORDER BY price ASC");
			}if(element.equals("nDESC")) {
				builder.append(" ORDER BY Name DESC");
			}if(element.equals("nASC")) {
				builder.append(" ORDER BY Name ASC");
			}
			}
		}
	}

	private void createSubRequestForiegnKey(String key, String[] array, StringBuilder builder) {
		int counter = 0;
		if(array != null) {
		for(String element : array) {
			ItemFilter filer = new ItemFilter();
			filer.setFilterName(key);
			filer.setCondition(executeCondition(key));
			filer.setFilterValue("?");
			builder.append(filer.toString());
			counter++;
			if(counter < array.length) {
				builder.append(" OR ");
			}
		}
		}
	}
	
	
	public String countItems(Map<String, String[]> map) {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT COUNT(*) FROM PRODUCTS ");
		int counter = 0;
		int nullCounter = 0;
		for (Map.Entry<String, String[]> entry : map.entrySet()) {
			if(entry.getValue() == null) {
				++nullCounter;
			}
		}
		
		if(nullCounter < 4) {
			builder.append(" WHERE ");
		for (Map.Entry<String, String[]> entry : map.entrySet()) {
				if(entry.getKey().equals("price")) {
					createPriceSubRequest("price", entry.getValue(), builder);
				}
				if(entry.getKey().equals("Name")) {
					createSubRequest("Name", entry.getValue(), builder);
				}
				if(entry.getKey().equals("Category_idCategory")) {
					createSubRequest("Category_idCategory", entry.getValue(), builder);
				}
				if(entry.getKey().equals("Manufacturer_idManufacturer")) {
					createSubRequest("Manufacturer_idManufacturer", entry.getValue(), builder);
				}
//				if(entry.getKey().equals("sort")) {
//					
//				}
//			}
			++counter;
			if (counter < map.size() && !entry.getKey().equals("sort") && entry.getValue() != null && !(nullCounter >= 3)) {
				builder.append(" AND ");
			}
			
		}
		}
		createSortSubRequest(map.get("sort"), builder);
		return builder.toString();
	}
	
}