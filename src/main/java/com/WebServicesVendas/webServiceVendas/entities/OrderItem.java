package com.WebServicesVendas.webServiceVendas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_order_item")
public class OrderItem {
	
	@ManyToMany
	@JoinColumn(name="product_id")
	private Product product;
	@ManyToMany
	@JoinColumn(name="order_id")
	private Order order;
	private int quantity;
	private Double price;
	
	public OrderItem() {
		
	}
	
	
	public OrderItem(Product product, Order order,int quantity, Double price) {
		super();
		this.product = product;
		this.order = order;
		this.quantity = quantity;
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	

}
