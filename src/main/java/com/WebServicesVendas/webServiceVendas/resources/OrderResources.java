package com.WebServicesVendas.webServiceVendas.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WebServicesVendas.webServiceVendas.entities.Order;
import com.WebServicesVendas.webServiceVendas.service.OrderItemService;
import com.WebServicesVendas.webServiceVendas.service.OrderService;

import jakarta.transaction.Transactional;

import com.WebServicesVendas.webServiceVendas.dto.OrderItemRequestDTO;

@RestController
@RequestMapping(value="/orders")
public class OrderResources {
   @Autowired
   private OrderService order;
   @Autowired
   private OrderItemService orderItem;
   
   @GetMapping(value="/findAll")
   public ResponseEntity<List<Order>> findAll(){
	   try {
		   return ResponseEntity.ok().body(order.findAll());
	   }catch(Exception ex) {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	   }
	  
   }
	
   @GetMapping(value="/quantity")
   public ResponseEntity<Double> quantityOrder(){
	   try {
		   return ResponseEntity.ok().body(order.quantityOrder());
	   }catch(Exception ex) {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	   }
	   
   }
   
   @PostMapping(value="/create")
   @Transactional
   public ResponseEntity<HttpStatus> createOrder(@RequestBody OrderItemRequestDTO orderItemProducts){
	   try {
	   Order o = order.create(orderItemProducts.getIdCliente());
	   
		   if(o.getId() > 0) {
			   boolean isCreate = orderItem.create(o, orderItemProducts);
			   if(isCreate == true) {
				   return ResponseEntity.ok().body(HttpStatus.CREATED);
			   }
			   return ResponseEntity.ok().body(HttpStatus.INTERNAL_SERVER_ERROR);
		   }
		   return ResponseEntity.ok().body(HttpStatus.BAD_REQUEST);
	   }catch(Exception ex){
		   return ResponseEntity.ok().body(HttpStatus.BAD_REQUEST);
	   }
	  
	   
   }
   
   public ResponseEntity<Order> findAllOrderByUser(@PathVariable int idUser){
	   
	   try {
		   
	   }catch(Exception ex){
		   return null;
	   }
	   
   }
}
