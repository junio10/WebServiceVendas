package com.WebServicesVendas.webServiceVendas.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

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
    
    public Order create(Long id) {
    	Instant momento = Instant.now();  
    	Optional<User> userOptional = Optional.ofNullable(user.getUserById(id));
    	User user;
        if(userOptional.isPresent()) {
        	user = userOptional.get();
        }else {
        	return null;
        }

    	Order o = new Order(momento, user, OrderStatus.WAITING_PAYMENT);
    	repository.save(o);
    	return o;
    }
    
    public Optional<Order> update(Order o) {
    	Optional<Order> update= null;
    	try {
    		update = repository.findById(o.getId());
    		repository.save(o);
    	}catch(Exception ex) {
    		return null;
    	}
    	return update;
    }
    
    public List<Order> findOrdersByUser(int id){
    	List<Order> orders;
    	try {
    		orders = repository.findOrderByUser(id);
    	}catch(Exception ex){
    		return null;
    	}
    	return orders;
    }
}
