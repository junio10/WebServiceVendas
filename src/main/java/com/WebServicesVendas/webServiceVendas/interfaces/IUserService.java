package com.WebServicesVendas.webServiceVendas.interfaces;

import java.util.List;

import com.WebServicesVendas.webServiceVendas.entities.User;

public interface IUserService {
	List<User> findAll();
	String quantityUser();
}
