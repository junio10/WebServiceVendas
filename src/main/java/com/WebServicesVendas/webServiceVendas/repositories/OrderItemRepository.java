package com.WebServicesVendas.webServiceVendas.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.WebServicesVendas.webServiceVendas.entities.OrderItem;
import com.WebServicesVendas.webServiceVendas.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
