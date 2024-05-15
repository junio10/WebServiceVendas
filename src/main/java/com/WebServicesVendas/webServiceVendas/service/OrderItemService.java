package com.WebServicesVendas.webServiceVendas.service;

import java.util.List;

import com.WebServicesVendas.webServiceVendas.entities.Product;
import com.WebServicesVendas.webServiceVendas.entities.OrderItem;
import com.WebServicesVendas.webServiceVendas.interfaces.IOrderItemService;
import com.WebServicesVendas.webServiceVendas.repositories.OrderItemRepository;

public class OrderItemService implements IOrderItemService {

	private OrderItemRepository orderItemRepository;
	
	public Long create(Long idOrder, List<Product> products) {
		for(Product p : products) 
			
			OrderItem orderItem = new OrderItem(p, idOrder,1 ,p.getPrice());
		
			
		}
	}
	
}
