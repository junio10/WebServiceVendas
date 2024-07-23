package com.WebServicesVendas.webServiceVendas.service;





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
	
	public boolean create(Order order, OrderItemRequestDTO products){
		 for (ProductOrderDTO p : products.getProducts()) {
			 Product p1;
			 try {
				 p1 = serviceProduct.findByName(p.getNameProdcut());
			 }catch(Exception ex) {
				 return false;
			 }			 
             if(p1 != null) {
            	OrderItem o;
            	try {
            		o = new OrderItem(p1, order, p.getQuantityOrder(), p1.getPrice());
     	            orderItemRepository.save(o);	
            	}catch(Exception ex) {
            		
            		return false;
            	}	           
			   }else {
				   return false;
			   }
	        }
		return true;
	}

	
		

}