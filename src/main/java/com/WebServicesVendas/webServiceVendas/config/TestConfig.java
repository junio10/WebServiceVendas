package com.WebServicesVendas.webServiceVendas.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.WebServicesVendas.webServiceVendas.entities.Category;
import com.WebServicesVendas.webServiceVendas.entities.Order;
import com.WebServicesVendas.webServiceVendas.entities.OrderItem;
import com.WebServicesVendas.webServiceVendas.entities.Product;
import com.WebServicesVendas.webServiceVendas.entities.User;
import com.WebServicesVendas.webServiceVendas.entities.enums.OrderStatus;
import com.WebServicesVendas.webServiceVendas.repositories.CategoryRepository;
import com.WebServicesVendas.webServiceVendas.repositories.OrderItemRepository;
import com.WebServicesVendas.webServiceVendas.repositories.OrderRepository;
import com.WebServicesVendas.webServiceVendas.repositories.ProductRepository;
import com.WebServicesVendas.webServiceVendas.repositories.UserRepository;

@Configuration
@Profile(value= "test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User u1 = new User(1, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(2, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		
		Order o1 = new Order(1, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.WAITING_PAYMENT); 
		Order o2 = new Order(2, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT); 
		Order o3 = new Order(3, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.WAITING_PAYMENT);
		
		Category cat1 = new Category(1, "Electronics"); 
		Category cat2 = new Category(2, "Books"); 
		Category cat3 = new Category(3, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
	
		OrderItem oi1 = new OrderItem(p1, o1, 2, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(p3, o1, 1, p3.getPrice()); 
		OrderItem oi3 = new OrderItem(p3, o2, 2, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(p5, o3, 2, p5.getPrice()); 

		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		productRepository.saveAllAndFlush(Arrays.asList(p1,p2,p3,p4,p5));
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
	}


}
