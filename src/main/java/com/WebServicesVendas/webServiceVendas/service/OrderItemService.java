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
import com.WebServicesVendas.webServiceVendas.dto.ProductOrderDTO;
@Service
public class OrderItemService implements IOrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private ProductService serviceProduct;
	
	public int create(Order order, OrderItemRequestDTO products) {
		 for (ProductOrderDTO p : products.getProducts()) {
			    Product p1 = serviceProduct.findByName(p.getNameProdcut());
			    if(p1 != null) {			    
	            OrderItem o = new OrderItem(p1, order, p.getQuantityOrder(), p1.getPrice());
	            orderItemRepository.save(o);
			    }
	        }
		return 1;
	}

	
		

}