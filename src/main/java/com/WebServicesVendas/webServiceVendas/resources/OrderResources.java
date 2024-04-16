package com.WebServicesVendas.webServiceVendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.WebServicesVendas.webServiceVendas.entities.Order;
import com.WebServicesVendas.webServiceVendas.service.OrderService;

@RestController
@RequestMapping(value="/orders")
public class OrderResources {
   @Autowired
   private OrderService order;
   
   @GetMapping(value="/findAll")
   public ResponseEntity<List<Order>> findAll(){
	   return ResponseEntity.ok().body(order.findAll());
   }
	
   @GetMapping(value="/quantity")
   public ResponseEntity<Double> quantityOrder(){
	   return ResponseEntity.ok().body(order.quantityOrder());
   }
}
