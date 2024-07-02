package com.WebServicesVendas.webServiceVendas.dto;

import java.util.Map;

public class OrderItemRequestDTO {
	private long idCliente;
	private Map<String, Integer> products;
	
	public OrderItemRequestDTO() {
		
	}
	public OrderItemRequestDTO(long id, Map<String, Integer> products) {
		this.idCliente = id;
		this.products = products;
	}
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long id) {
		this.idCliente = id;
	}
	public Map<String, Integer> getProducts() {
		return products;
	}
	public void setProducts(Map<String, Integer> products) {
		this.products = products;
	}

}
