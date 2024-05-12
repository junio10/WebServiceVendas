package com.WebServicesVendas.webServiceVendas.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WebServicesVendas.webServiceVendas.entities.Order;
import com.WebServicesVendas.webServiceVendas.entities.User;
import com.WebServicesVendas.webServiceVendas.entities.enums.OrderStatus;
import com.WebServicesVendas.webServiceVendas.interfaces.IOrderService;
import com.WebServicesVendas.webServiceVendas.repositories.OrderRepository;
@Service
public class OrderService implements IOrderService {
    @Autowired
	private OrderRepository repository;
    
    @Autowired
    private UserService user;
    
    public List<Order> findAll(){
    	return repository.findAll();
    }
    
    public double quantityOrder() {
    	return repository.count();
    }
    
    public String create(Long i) {
    	Instant momento = Instant.now();  
    	User u= user.getUserById(i);
    	if(u == null) {
    		return "User is not found in database";
    	}

    	Order o = new Order(momento, u, OrderStatus.WAITING_PAYMENT);
    	repository.save(o);
    	return "Order create";
    }
}
