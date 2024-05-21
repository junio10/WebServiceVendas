package com.WebServicesVendas.webServiceVendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WebServicesVendas.webServiceVendas.interfaces.IProductService;
import com.WebServicesVendas.webServiceVendas.repositories.ProductRepository;
import com.WebServicesVendas.webServiceVendas.entities.Product;
@Service
public class ProductService implements IProductService{
	@Autowired
	private ProductRepository product;
	
	public List<Product> findAll(){
		return product.findAll();
	}
	
	public Product findByName(String name){
		Optional<Product> isProduct = product.findByName(name);
		if(isProduct.isPresent()) {
			return isProduct.get();
		}
		return null;
		
	}

}
