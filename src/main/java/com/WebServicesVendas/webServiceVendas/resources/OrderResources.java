package com.WebServicesVendas.webServiceVendas.resources;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WebServicesVendas.webServiceVendas.entities.Order;
import com.WebServicesVendas.webServiceVendas.service.OrderItemService;
import com.WebServicesVendas.webServiceVendas.service.OrderService;

@RestController
@RequestMapping(value="/orders")
public class OrderResources {
   @Autowired
   private OrderService order;
   
   private OrderItemService orderItem;
   
   @GetMapping(value="/findAll")
   public ResponseEntity<List<Order>> findAll(){
	   return ResponseEntity.ok().body(order.findAll());
   }
	
   @GetMapping(value="/quantity")
   public ResponseEntity<Double> quantityOrder(){
	   return ResponseEntity.ok().body(order.quantityOrder());
   }
   
   @PostMapping(value="/create")
   public ResponseEntity<Integer> createOrder(@RequestBody Long id, @RequestBody Map<String, Integer> products){
	   Order o = order.create(id);
	   if(o.getId() > 0) {
		   int isCreate = orderItem.create(o, products);
		   if(isCreate == 1) {
			   ResponseEntity.ok().body(1);
		   }
	   }
	   return ResponseEntity.ok().body(0);
   }
}
