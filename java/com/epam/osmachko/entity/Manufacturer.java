package com.epam.osmachko.entity;

public class Manufacturer {

	private Integer id;
	
	private String manufacturer;

	public Manufacturer(Integer id, String manufacturer) {
		this.id = id;
		this.manufacturer = manufacturer;
	}
	
	public Manufacturer() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "Manufacturer : [id=" + id + ", manufacturer=" + manufacturer + "]";
	}
	
	
}
