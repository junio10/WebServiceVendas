package com.WebServicesVendas.webServiceVendas.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
   public ResponseEntity<Page<Order>> findAll(@RequestParam int pagina, @RequestParam int size){
	   Pageable page = PageRequest.of(size, pagina);
	   try {
		   return ResponseEntity.ok().body(order.findAll(page));
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
			   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		   }
		   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	   }catch(Exception ex){
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	   }
	  
	   
   }
   
   public ResponseEntity<Page<Order>> findAllOrderByUser(@PathVariable int idUser, @RequestParam int pagina, @RequestParam int quantidade){
	   //fazendo paginacao da consulta de pedidos por id
	   Page<Order> pageOrder = null;
	   try {
		   Pageable page = PageRequest.of(pagina, quantidade);
		   pageOrder = order.findOrdersByUser(idUser, page);
	   }catch(Exception ex){
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	   }
	   return ResponseEntity.status(HttpStatus.OK).body(pageOrder);
   }
}
