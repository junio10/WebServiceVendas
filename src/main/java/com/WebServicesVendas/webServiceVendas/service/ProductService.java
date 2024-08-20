package com.WebServicesVendas.webServiceVendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.WebServicesVendas.webServiceVendas.interfaces.IProductService;
import com.WebServicesVendas.webServiceVendas.repositories.CategoryRepository;
import com.WebServicesVendas.webServiceVendas.repositories.ProductRepository;
import com.WebServicesVendas.webServiceVendas.entities.Category;
import com.WebServicesVendas.webServiceVendas.entities.Product;
@Service
public class ProductService implements IProductService{
	@Autowired
	private ProductRepository product;
	
	@Autowired
	private CategoryRepository category;
	
	public Page<Product> findAll(Pageable page){
		return product.findAll(page);
	}
	
	
	
	public Product findByName(String name){
		Optional<Product> isProduct = product.findByName(name);
		if(isProduct.isPresent()) {
			return isProduct.get();
		}
		return null;	
	}
	//criar um produto, se a categoria não existe, ele irá criar 
	public HttpStatus create(Product productNew) {
		try {
			Category categoryCode;
			if(product.findByName(productNew.getName()).equals(null))
				return HttpStatus.BAD_GATEWAY;
			
			if (category.findByName(productNew.getName()).equals(null))
				categoryCode = category.save(productNew.getCategory());
			else
				return HttpStatus.BAD_GATEWAY;
			Product novo = null;
			if(!categoryCode.equals(null))
				novo = product.save(productNew);
			    HttpStatus isCode = (novo.equals(null) ? 
			                         HttpStatus.INTERNAL_SERVER_ERROR 
			                         : HttpStatus.ACCEPTED);
			    return isCode;
		}catch(Exception ex){
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}
	
	

}
