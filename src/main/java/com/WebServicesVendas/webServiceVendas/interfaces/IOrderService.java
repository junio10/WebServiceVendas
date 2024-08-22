package com.WebServicesVendas.webServiceVendas.interfaces;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.WebServicesVendas.webServiceVendas.entities.Order;

public interface IOrderService {

	Page<Order> findAll(Pageable page);
	double quantityOrder();
	Order create(Long id);
	Optional<Order> update(Order o);
}
