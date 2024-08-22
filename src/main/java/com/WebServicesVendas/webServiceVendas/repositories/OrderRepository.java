package com.WebServicesVendas.webServiceVendas.repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.WebServicesVendas.webServiceVendas.entities.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	@Query("SELECT o FROM Order o WHERE o.user.id = :id")
	Page<Order> findOrderByUser(@Param("id") int id, Pageable page);
}
