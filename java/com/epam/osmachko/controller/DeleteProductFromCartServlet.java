package com.epam.osmachko.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.osmachko.cart.Cart;
import com.epam.osmachko.constant.Constant;
import com.epam.osmachko.entity.Product;
import com.epam.osmachko.service.ProductService;
import com.google.gson.Gson;

/**
 * Servlet implementation class DeleteProductFromCartServlet
 */
@WebServlet("/DeleteProductFromCartServlet")
public class DeleteProductFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductService productService;
	
	@Override
	public void init() throws ServletException {
		productService = (ProductService) getServletContext().getAttribute(Constant.PRODUCT_SERVICE);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<String,String> map = (Map<String, String>) session.getAttribute("ResultMap");
		if(map == null) {
			map = new HashMap<>();
		}
		Integer totalAmount = 0;
		Double totalPrice = 0.0;
		Cart cart = (Cart) session.getAttribute("cart");
		Integer idProduct = Integer.parseInt(request.getParameter("idProduct"));
		Product product = productService.getProductById(idProduct);
		if(session.getAttribute("logUser") == null) {
			System.out.println("No rights");
		} else {
			if(cart != null) {
				cart.deleteProductFromCart(product);
				totalPrice = cart.countTotalPriceFromCart();
				totalAmount = cart.countAmountOfProductsInCart();
				session.setAttribute("cart", cart);
			} 
		}	
		System.out.println("Product = " + product.toString());	
		map.put("totalCost", totalPrice.toString());
		map.put("totalCount", totalAmount.toString());
		write(response,map);
	}
	
	private void write(HttpServletResponse response, Map<String, String> map) throws IOException {
		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(map));
		
	}
	

}
