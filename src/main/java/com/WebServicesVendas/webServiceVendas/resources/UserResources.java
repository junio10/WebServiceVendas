package com.WebServicesVendas.webServiceVendas.resources;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WebServicesVendas.webServiceVendas.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserResources {

	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1,"Moises", "moises@email.com", "1111-1111", "123");
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping(value="/ola")
	public ResponseEntity<String> ola(){
		return ResponseEntity.ok().body("ola");
	}
	
}
