package com.WebServicesVendas.webServiceVendas.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WebServicesVendas.webServiceVendas.entities.User;
import com.WebServicesVendas.webServiceVendas.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResources {
	@Autowired
    private UserService user;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = user.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/ola")
	public ResponseEntity<String> ola(){
		return ResponseEntity.ok().body("ola");
	}
	
	@GetMapping(value="/totalUsers")
	public ResponseEntity<String> totalUsers(){
		return ResponseEntity.ok().body(user.quantityUser());
	}
	
}
