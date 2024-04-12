package com.WebServicesVendas.webServiceVendas.service;

import java.util.List;

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
	
	public String quantityUser() {
		Integer num = repository.findAll().size();
		return num.toString();
	}

}
