package com.epam.osmachko.cart;

import com.epam.osmachko.entity.Product;

public final class OrderInfo {

	private final Product product;
	
	private final Integer amount;
	
	private final Double priceAtTheMomentOfPurchase;
	
	public OrderInfo(Product product, Integer amount, Double priceAtTheMomentOfPurchase) {
		this.product = product;
		this.amount = amount;
		this.priceAtTheMomentOfPurchase = priceAtTheMomentOfPurchase;
	}
	

	public Product getProduct() {
		return product;
	}

	public Integer getAmount() {
		return amount;
	}

	public Double getPriceAtTheMomentOfPurchase() {
		return priceAtTheMomentOfPurchase;
	}


	
	

	

	
	
	
	
}
