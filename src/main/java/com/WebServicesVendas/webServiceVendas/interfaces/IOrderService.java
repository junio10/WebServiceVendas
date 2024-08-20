package com.WebServicesVendas.webServiceVendas.interfaces;
import java.util.List;
import java.util.Optional;

import com.WebServicesVendas.webServiceVendas.entities.Order;

public interface IOrderService {

	List<Order> findAll();
	double quantityOrder();
	Order create(Long id);
	Optional<Order> update(Order o);
}
