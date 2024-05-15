package com.WebServicesVendas.webServiceVendas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.WebServicesVendas.webServiceVendas.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findById(Long id);
}
