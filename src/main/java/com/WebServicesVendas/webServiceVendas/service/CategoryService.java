package com.WebServicesVendas.webServiceVendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WebServicesVendas.webServiceVendas.entities.Category;
import com.WebServicesVendas.webServiceVendas.interfaces.ICategoryService;
import com.WebServicesVendas.webServiceVendas.repositories.CategoryRepository;
@Service
public class CategoryService implements ICategoryService {
	  @Autowired
      private CategoryRepository category;
      
      public List<Category> findAll(){
    	  return category.findAll();
      }
      
      public Category create(Category c) {
    	  	  return category.save(c);
      }
      
}
