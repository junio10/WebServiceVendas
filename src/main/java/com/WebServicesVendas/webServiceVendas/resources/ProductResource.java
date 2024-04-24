package com.WebServicesVendas.webServiceVendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.WebServicesVendas.webServiceVendas.entities.Product;

import com.WebServicesVendas.webServiceVendas.service.ProductService;
@RestController
@RequestMapping(value="/products")
public class ProductResource {
	@Autowired
	private ProductService product;

	@GetMapping(value="findAll")
	public ResponseEntity<List<Product>> findAll(){
		return ResponseEntity.ok().body(product.findAll());
	}
}
