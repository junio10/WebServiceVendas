package com.WebServicesVendas.webServiceVendas.service;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WebServicesVendas.webServiceVendas.entities.Order;
import com.WebServicesVendas.webServiceVendas.entities.OrderItem;
import com.WebServicesVendas.webServiceVendas.entities.Product;
import com.WebServicesVendas.webServiceVendas.interfaces.IOrderItemService;
import com.WebServicesVendas.webServiceVendas.repositories.OrderItemRepository;
import com.WebServicesVendas.webServiceVendas.repositories.OrderRepository;

import jakarta.transaction.Transactional;

import com.WebServicesVendas.webServiceVendas.dto.OrderItemRequestDTO;
import com.WebServicesVendas.webServiceVendas.dto.ProductOrderDTO;
@Service
public class OrderItemService implements IOrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private ProductService serviceProduct;
    @Autowired
	private OrderService orderService;
	
	 @Transactional
	    public boolean create(Order order, OrderItemRequestDTO products) {
	        double priceOrder = 0.0;
	        
	        try {
	            for (ProductOrderDTO p : products.getProducts()) {
	                Product product = serviceProduct.findByName(p.getNameProdcut());
	                
	                OrderItem orderItem = new OrderItem(product, order, p.getQuantityOrder(), product.getPrice());
	                orderItemRepository.save(orderItem);
	                
	                priceOrder += p.getQuantityOrder() * product.getPrice();
	            }
	            
	            order.setPriceOrder(priceOrder);
	            orderService.update(order);
	            // Salvar o pedido aqui, se necessário: orderRepository.save(order);

	            return true;
	        } catch (Exception ex) {
	           
	            return false;
	        }
	    }

	
		

}