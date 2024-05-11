package com.WebServicesVendas.webServiceVendas.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.WebServicesVendas.webServiceVendas.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    //retorna se tiver o nome da categoria
	Category findByName(String name);
}
