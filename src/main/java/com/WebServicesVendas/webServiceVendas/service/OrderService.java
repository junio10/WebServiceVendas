package com.WebServicesVendas.webServiceVendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.WebServicesVendas.webServiceVendas.entities.Order;
import com.WebServicesVendas.webServiceVendas.interfaces.IOrderService;
import com.WebServicesVendas.webServiceVendas.repositories.OrderRepository;
@Service
public class OrderService implements IOrderService {
    @Autowired
	private OrderRepository repository;
    
    public List<Order> findAll(){
    	return repository.findAll();
    }
    
    public double quantityOrder() {
    	return repository.count();
    }
}
