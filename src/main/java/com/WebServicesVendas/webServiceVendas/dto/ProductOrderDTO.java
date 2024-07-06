package com.WebServicesVendas.webServiceVendas.dto;

public class ProductOrderDTO {
	private long idProduct;
	private String nameProduct;
	private int quantityOrder;
	
	public ProductOrderDTO() {
		
	}
	
	public ProductOrderDTO(long id, String name, int quantity) {
		this.idProduct = id;
		this.nameProduct = name;
		this.quantityOrder = quantity;
	}
	
	public long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}
	public String getNameProdcut() {
		return nameProduct;
	}
	public void setNameProdcut(String nameProdcut) {
		this.nameProduct = nameProdcut;
	}
	public int getQuantityOrder() {
		return quantityOrder;
	}
	public void setQuantityOrder(int quantityOrder) {
		this.quantityOrder = quantityOrder;
	}

}
