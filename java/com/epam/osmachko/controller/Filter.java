package com.epam.osmachko.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.epam.osmachko.constant.Constant;
import com.epam.osmachko.entity.Product;
import com.epam.osmachko.pagination.Pagination;
import com.epam.osmachko.service.FilterService;
import com.epam.osmachko.sqlbuilder.BuildCriteria;
import com.epam.osmachko.sqlbuilder.FilterCriteria;

/**
 * Servlet implementation class Filter
 */
//@WebServlet("/Filter")
public class Filter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FilterService filterService;

	
	@Override
	public void init() throws ServletException {
		filterService = (FilterService) getServletContext().getAttribute(Constant.FILTER_SERVICE);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String[]> filtersContainer = createMapFromRequest(request);
		BuildCriteria criteria = new BuildCriteria();
		int recordsPerPage = 2;
		String currentPage = request.getParameter("currentPage"); 
		System.out.println("CurrentPage = " + currentPage);
		String queryCountAllProduct = criteria.countItems(filtersContainer);
		System.out.println(queryCountAllProduct);
		String querySelectProducts = criteria.executeCommands(filtersContainer);
		System.out.println(querySelectProducts);
		Integer count = filterService.countProductsByFilters(queryCountAllProduct, filtersContainer);
		Pagination pagination = new Pagination(Integer.parseInt(currentPage), querySelectProducts);
		String result = pagination.resultQuery();
		System.out.println(result);
		Integer numberOfLastIndex = countTheIndexOfLastQuestionMark(result);
		System.out.println("NUMBER OF LAST INDEX = " + numberOfLastIndex);
		List<Product> products = filterService.selectProductsByFilters(numberOfLastIndex,(Integer.parseInt(currentPage) - 1) * 5,result,filtersContainer);
		int noOfRecords = count;
	    int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
	    request.getSession().setAttribute("noOfRecords", noOfRecords);
	    request.getSession().setAttribute("noOfPages", noOfPages);
		request.setAttribute("filteredProducts", products);
		request.getRequestDispatcher("ListItems.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private Map<String,String[]> createMapFromRequest(HttpServletRequest request) {
		String[] names = request.getParameterValues("name");
		String sortParametr = request.getParameter("sort");
		System.out.println(sortParametr);
		String[] sortFiler = new String[1];
		sortFiler[0] = sortParametr;
		String[] manufacturers = request.getParameterValues("manufacturer");
		String[] brands = request.getParameterValues("brand");
		String priceFrom = request.getParameter("priceFrom");
		String priceTo = request.getParameter("priceTo");
		String[] priceDiapazon = null;
		if(priceFrom.length() != 0 && priceTo.length() != 0) {
			priceDiapazon = new String[2];
		priceDiapazon[0] = priceFrom;
		priceDiapazon[1] = priceTo;
		}
		Map<String,String[]> filtersContainer = new HashMap<String,String[]>();
		filtersContainer.put("Category_idCategory", names);
		filtersContainer.put("Manufacturer_idManufacturer", manufacturers);
		filtersContainer.put("Name", brands);
		filtersContainer.put("price", priceDiapazon);
		filtersContainer.put("sort", sortFiler);
		return filtersContainer;
	}
	
	private FilterCriteria crateFilterCriteria(HttpServletRequest request) {
		FilterCriteria filterCriteria = new FilterCriteria();
		Integer priceFrom = Integer.parseInt(request.getParameter("priceFrom"));
		Integer priceTo = Integer.parseInt(request.getParameter("priceTo"));
		List<String> manufact = Arrays.asList(request.getParameterValues("manufacturer"));
		List<Integer> manufacturers = new ArrayList<Integer>();
		for(String element : manufact) {
			manufacturers.add(Integer.parseInt(element));
		}
		List<String> brand = Arrays.asList(request.getParameterValues("name"));
		List<Integer> categories = new ArrayList<Integer>();
		for(String element : brand) {
			categories.add(Integer.parseInt(element));
		}
		String name = request.getParameter("name1");
		filterCriteria.setCategories(categories);
		filterCriteria.setManufacturers(manufacturers);
		filterCriteria.setPriceFrom(priceFrom);
		filterCriteria.setPriceTo(priceTo);
		filterCriteria.setName(name);
		filterCriteria.setSortBy(request.getParameter("sort"));
		filterCriteria.setMaxProductsOnPage(3);
		return filterCriteria;
	}
	
	private Integer countTheIndexOfLastQuestionMark(String string) {
		int counter = 0;
		for( int i=0; i<string.length(); i++ ) {
		    if( string.charAt(i) == '?' ) {
		        counter++;
		    } 
		}
		return counter;
	}
	
	
}
