package com.WebServicesVendas.webServiceVendas.dto;

import java.util.List;
import java.util.Map;

public class OrderItemRequestDTO {
	private long idCliente;
	private List<ProductOrderDTO> products;
	
	
	public OrderItemRequestDTO() {
		
	}
	public OrderItemRequestDTO(long id, List<ProductOrderDTO> products) {
		this.idCliente = id;
		this.products = products;
	}
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long id) {
		this.idCliente = id;
	}
	public List<ProductOrderDTO> getProducts() {
		return products;
	}
	public void setProducts(List<ProductOrderDTO> products) {
		this.products = products;
	}

}
