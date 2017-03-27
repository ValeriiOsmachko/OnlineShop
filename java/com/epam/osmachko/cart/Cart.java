package com.epam.osmachko.cart;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import com.epam.osmachko.entity.Product;

public class Cart {

	private Map<Product,Integer> cart;
	
	public Cart() {
		cart = new LinkedHashMap<>();
	}
	
	public void addProductToCart(Product product) {
		Integer currentAmountOfProduct = null;
		for(Map.Entry<Product, Integer> entry : cart.entrySet()) {
			if(entry.getKey().equals(product)) {
				currentAmountOfProduct = entry.getValue();
			}
		}
		if(currentAmountOfProduct == null) {
			currentAmountOfProduct = 1;
		} else {
			currentAmountOfProduct += 1;
		}
		cart.put(product, currentAmountOfProduct);
	}
	
	public boolean deleteProductFromCart(Product product) {
		if(cart.containsKey(product)) {
			cart.remove(product);
			return true;
		} else {
			return false;
		}
	}
	
	public Integer countAmountOfProductsInCart() {
		Integer totalAmount = 0;
		for(Map.Entry<Product, Integer> entry : cart.entrySet()) {
			totalAmount += entry.getValue();
		}
		return totalAmount;
	}
	
	public Double countTotalPriceFromCart() {
		Double totalPrice = 0.0;
		for(Map.Entry<Product, Integer> entry : cart.entrySet()) {
			totalPrice += entry.getKey().getPrice() * entry.getValue();
		}
		return totalPrice;
	}
	
	
	public boolean changeAmountOfProduct(Product product, Integer amount) {
		return cart.containsKey(product) ? func(product,amount) : false;
	}
	
	
	
	private boolean func(Product product, Integer amount){
		cart.put(product, amount);
		return true;
	}
	
	public Map<Product,Integer> getCart() {
		return Collections.unmodifiableMap(cart);
	}
	
	public Integer countAmountOfSpecifiedCar(Product product) {
		if(cart.containsKey(product)) {
			return cart.get(product);
		} else {
			return 0;
		}
	}
	
}
