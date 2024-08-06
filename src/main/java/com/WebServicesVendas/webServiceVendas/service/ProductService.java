package com.WebServicesVendas.webServiceVendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public HttpStatus create(Product productNew) {
		try {
			Category code;
			
			code = (productNew.equals(null) ? 
					category.save(productNew.getCategory()) :  
				    category.findByName(productNew.getName()));
			Product novo = null;
			if(!code.equals(null))
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
