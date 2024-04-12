package com.WebServicesVendas.webServiceVendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WebServicesVendas.webServiceVendas.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
