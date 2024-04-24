package com.WebServicesVendas.webServiceVendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WebServicesVendas.webServiceVendas.service.CategoryService;
import com.WebServicesVendas.webServiceVendas.entities.Category;
@RestController
@RequestMapping(value="/category")
public class CategoryResource {
    @Autowired
	private CategoryService category;
    
    @GetMapping(value="/findAll")
    public ResponseEntity<List<Category>> findAll(){
    	return ResponseEntity.ok().body(category.findAll());
    }
    
    @PostMapping(value="/criar")
    public ResponseEntity<Category> create(@RequestBody Category cat){
    	return ResponseEntity.ok(category.create(cat));
    }
    	    
}
