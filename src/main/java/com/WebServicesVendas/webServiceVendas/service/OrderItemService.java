package com.WebServicesVendas.webServiceVendas.service;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WebServicesVendas.webServiceVendas.entities.Order;
import com.WebServicesVendas.webServiceVendas.entities.OrderItem;
import com.WebServicesVendas.webServiceVendas.entities.Product;
import com.WebServicesVendas.webServiceVendas.interfaces.IOrderItemService;
import com.WebServicesVendas.webServiceVendas.repositories.OrderItemRepository;

import com.WebServicesVendas.webServiceVendas.dto.OrderItemRequestDTO;
@Service
public class OrderItemService implements IOrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private ProductService serviceProduct;
	
	public int create(Order order, OrderItemRequestDTO products) {
		 for (Map.Entry<String, Integer> entry : products.getProducts().entrySet()) {
			    Product p = serviceProduct.findByName(entry.getKey());
			    if(p != null) {
	            OrderItem o = new OrderItem(p, order, entry.getValue(), p.getPrice());
	            orderItemRepository.save(o);
			    }
	        }
		return 1;
	}

	
		

}