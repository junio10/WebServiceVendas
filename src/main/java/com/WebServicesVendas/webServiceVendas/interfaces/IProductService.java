package com.WebServicesVendas.webServiceVendas.interfaces;
import java.util.List;

import com.WebServicesVendas.webServiceVendas.entities.Product;

public interface IProductService {
	List<Product> findAll();
	Product findByName(String name);

}
