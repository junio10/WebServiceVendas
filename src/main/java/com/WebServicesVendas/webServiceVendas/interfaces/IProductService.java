package com.WebServicesVendas.webServiceVendas.interfaces;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.WebServicesVendas.webServiceVendas.entities.Product;

public interface IProductService {
	List<Pageable> findAll();
	Product findByName(String name);

}
