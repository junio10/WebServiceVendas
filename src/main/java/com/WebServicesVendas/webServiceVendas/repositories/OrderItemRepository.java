package com.WebServicesVendas.webServiceVendas.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WebServicesVendas.webServiceVendas.entities.OrderItem;
import com.WebServicesVendas.webServiceVendas.entities.pk.OrderItemPK;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
