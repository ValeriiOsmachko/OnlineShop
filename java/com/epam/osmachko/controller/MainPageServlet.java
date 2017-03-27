package com.epam.osmachko.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.osmachko.constant.Constant;
import com.epam.osmachko.entity.Category;
import com.epam.osmachko.entity.Manufacturer;
import com.epam.osmachko.entity.Product;
import com.epam.osmachko.service.CategoryService;
import com.epam.osmachko.service.FilterService;
import com.epam.osmachko.service.ManufacturerService;
import com.epam.osmachko.sqlbuilder.BuildSQLQuery;
import com.epam.osmachko.sqlbuilder.FilterCriteria;

/**
 * Servlet implementation class MainPageServlet
 */
@WebServlet("/MainPageServlet")
public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CategoryService categoryService;
	
	private ManufacturerService manufacturerService;
	
	private FilterService filterService;
	
	private List<Category> categories;
	
	private List<Manufacturer> manufacturers;


	
	@Override
	public void init() throws ServletException {
		categoryService = (CategoryService) getServletContext().getAttribute(Constant.CATEGORY_SERVICE);
		manufacturerService = (ManufacturerService) getServletContext().getAttribute(Constant.MANUFACTURER_SERVICE);
		filterService = (FilterService) getServletContext().getAttribute(Constant.FILTER_SERVICE);
		categories = categoryService.getAllCategory();
		manufacturers = manufacturerService.getAllManufacturers();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("categories", categories);
		request.setAttribute("manufacturers", manufacturers);
		Integer currentPage = null;
		String curPage = request.getParameter("page");
		if(curPage != null) {
			if(curPage.matches("(?<=\\s|^)\\d+(?=\\s|$)")) {
			currentPage = Integer.parseInt(curPage);
			} else {
				currentPage = 1;
			}
		} else {
			currentPage = 1;
		}
		FilterCriteria criteria = new FilterCriteria();
		crateFilterCriteria(criteria,request);
		BuildSQLQuery buildSQLQuery = new BuildSQLQuery(criteria);
		String query = buildSQLQuery.buildQuery();
		String countProducts = buildSQLQuery.buildCountQuery();
		Integer totalAmount = filterService.getTotalAmount(countProducts, criteria);
		int numberOfPages = (int) Math.ceil(totalAmount * 1.0 / 3);
		List<Product> filteredProd = filterService.selectAll(currentPage,query,criteria);
		criteria.setTotalPages(numberOfPages);
		request.setAttribute("filteredProducts", filteredProd);
		request.setAttribute("pageCount", numberOfPages);
		request.setAttribute("currentPage", currentPage);
		request.getRequestDispatcher("products.jsp").forward(request, response);
		
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
		String[] sortFiler = new String[1];
		sortFiler[0] = sortParametr;
		String[] manufacturers = request.getParameterValues("manufacturer");
		String[] brands = request.getParameterValues("brand");
		String priceFrom = request.getParameter("priceFrom");
		String priceTo = request.getParameter("priceTo");
		String[] priceDiapazon = null;
		if(priceFrom != null && priceTo != null) {
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
	
	
	private Integer countTheIndexOfLastQuestionMark(String string) {
		int counter = 0;
		for( int i=0; i<string.length(); i++ ) {
		    if( string.charAt(i) == '?' ) {
		        counter++;
		    } 
		}
		return counter;
	}
	
	private void crateFilterCriteria(FilterCriteria filterCriteria,HttpServletRequest request) {
		String from = request.getParameter("priceFrom");
		String to = request.getParameter("priceTo");
		Integer priceFrom = null;
		Integer priceTo = null;
		if(from != null) {
			if(from.matches("(?<=\\s|^)\\d+(?=\\s|$)")) {
			priceFrom = Integer.parseInt(from);
			}
		}
		if(to != null) {
			if(to.matches("(?<=\\s|^)\\d+(?=\\s|$)")) {
			priceTo = Integer.parseInt(to);
			}
		}
		String[] man = request.getParameterValues("manufacturer");
		List<Integer> manufacturers = null;
		if(man != null) {
			manufacturers = new ArrayList<>();
		for(String element : man) {
			if(element.matches("(?<=\\s|^)\\d+(?=\\s|$)")) {
			manufacturers.add(Integer.parseInt(element));
			}
		}
		}
		String[] bra = request.getParameterValues("name");
		List<Integer> categories = null;
		if(bra != null) {
			categories = new ArrayList<>();
		for(String element : bra) {
			if(element.matches("(?<=\\s|^)\\d+(?=\\s|$)")) {
			categories.add(Integer.parseInt(element));
			}
		}
		}
		String name = request.getParameter("name1");
		filterCriteria.setCategories(categories);
		filterCriteria.setManufacturers(manufacturers);
		filterCriteria.setPriceFrom(priceFrom);
		filterCriteria.setPriceTo(priceTo);
		filterCriteria.setName(name);
		filterCriteria.setSortBy(request.getParameter("sort"));
	}
	
}
