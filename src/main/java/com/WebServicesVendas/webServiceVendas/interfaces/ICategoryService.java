package com.WebServicesVendas.webServiceVendas.interfaces;
import java.util.List;

import com.WebServicesVendas.webServiceVendas.entities.Category;
public interface ICategoryService {
    List<Category> findAll();
    Category create(Category c);
}
