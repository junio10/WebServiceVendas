package com.WebServicesVendas.webServiceVendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WebServicesVendas.webServiceVendas.entities.User;
import com.WebServicesVendas.webServiceVendas.interfaces.IUserService;
import com.WebServicesVendas.webServiceVendas.repositories.UserRepository;
@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public double quantityUser() {
		return repository.count();
	}
	
	public User getUserById(Long id) {
	    Optional<User> u = repository.findById(id);
		if(!u.isEmpty()) {
			return u.get();
		}
		return null;
		
	}
	
}
