package com.epam.osmachko.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.osmachko.car_type_container.StatusOfOrfer;
import com.epam.osmachko.cart.Cart;
import com.epam.osmachko.cart.OrderInfo;
import com.epam.osmachko.constant.Constant;
import com.epam.osmachko.entity.Product;
import com.epam.osmachko.entity.User;
import com.epam.osmachko.order.Order;
import com.epam.osmachko.service.OrderService;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private OrderService service;
	
	@Override
	public void init() throws ServletException {
		service = (OrderService) getServletContext().getAttribute(Constant.ORDER_SERVICE);
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		User user = (User) session.getAttribute("logUser");
		Order order = new Order();
		order.setDate(new Date());
		order.setUser(user);
		order.setStatusOfOrfer(StatusOfOrfer.ACCEPTED);
		order.setState("OK");
		List<OrderInfo> list = convertCart(cart.getCart());
		order.setList(list);
		UUID uuid = UUID.randomUUID();
		order.setUuid(uuid.toString());
		order.setId(uuid.toString());
		String address = request.getParameter("address");
		String cardNumber = request.getParameter("cardNumber");
		order.setAddress(address);
		order.setCardNumber(cardNumber);
		service.addOrder(order);
		session.setAttribute(Constant.ORDER, order);
		response.sendRedirect("showResult.jsp");
	}

	
	
	private List<OrderInfo> convertCart(Map<Product,Integer> map) {
		List<OrderInfo> list = new ArrayList<>();
		for(Map.Entry<Product, Integer> element : map.entrySet()) {
			Product product = element.getKey();
			Integer amount = element.getValue();
			Double priceOnTheMomentOfPurchase = element.getKey().getPrice();
			OrderInfo orderInfo = new OrderInfo(product,amount,priceOnTheMomentOfPurchase);
			list.add(orderInfo);
		}
		return list;
	}
}
