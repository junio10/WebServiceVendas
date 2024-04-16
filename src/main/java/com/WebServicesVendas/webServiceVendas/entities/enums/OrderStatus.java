package com.WebServicesVendas.webServiceVendas.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);

	private int orderStatus;
	private OrderStatus(int i) {
		// TODO Auto-generated constructor stub
		this.orderStatus = i;
	}
	
	public int getOrderStatus() {
		return this.orderStatus;
	}
	
	public static OrderStatus valueOf(int cod) {
		for(OrderStatus i : OrderStatus.values()) {
			if(i.getOrderStatus() == cod) {
				return i;
			}
		}
        throw new IllegalArgumentException("Argumento invalido");
	}
}
