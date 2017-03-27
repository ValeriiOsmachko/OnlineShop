package com.epam.osmachko.order;

import java.util.Date;
import java.util.List;

import com.epam.osmachko.car_type_container.StatusOfOrfer;
import com.epam.osmachko.cart.OrderInfo;
import com.epam.osmachko.entity.User;

public class Order {

	
	private String id;
	
	private StatusOfOrfer statusOfOrfer;
	
	private Date date;
	
	private User user;
	
	private String state;
	
	private List<OrderInfo> list;
	
	private String uuid;
	
	private String address;
	
	private String cardNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public StatusOfOrfer getStatusOfOrfer() {
		return statusOfOrfer;
	}

	public void setStatusOfOrfer(StatusOfOrfer statusOfOrfer) {
		this.statusOfOrfer = statusOfOrfer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<OrderInfo> getList() {
		return list;
	}

	public void setList(List<OrderInfo> list) {
		this.list = list;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	
	
	
	
	
	
	
	 
	
}
