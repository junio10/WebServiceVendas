package com.WebServicesVendas.webServiceVendas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WebServicesVendas.webServiceVendas.entities.Product;
@Repository
public interface ProductRepository extends  JpaRepository<Product,Long>{

	Optional<Product> findByName(String name);
}
