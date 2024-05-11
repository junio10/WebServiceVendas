package com.WebServicesVendas.webServiceVendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.WebServicesVendas.webServiceVendas.entities.Category;
import com.WebServicesVendas.webServiceVendas.service.CategoryService;
@RestController
@RequestMapping(value="/category")
public class CategoryResource {
    @Autowired
	private CategoryService category;
    
    @GetMapping(value="/findAll")
    public ResponseEntity<List<Category>> findAll(){
    	return ResponseEntity.ok().body(category.findAll());
    }
    
    @PostMapping(value="/create")
    public ResponseEntity<Category> create(@RequestBody Category cat){
    	return ResponseEntity.ok(category.create(cat));
    }
    
    @DeleteMapping(value="/deleteByName")
    public ResponseEntity<Integer> deleteByName(@RequestParam String name){
    	Integer isSucess = category.deleteByName(name);
        return ResponseEntity.ok(isSucess);
    }
    	    
}
