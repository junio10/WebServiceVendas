package com.WebServicesVendas.webServiceVendas.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.WebServicesVendas.webServiceVendas.entities.Product;

public interface IProductService {
	Page<Product> findAll(Pageable page);
	Product findByName(String name);

}
