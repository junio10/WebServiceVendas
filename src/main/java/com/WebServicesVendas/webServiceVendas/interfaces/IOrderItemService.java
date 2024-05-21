package com.WebServicesVendas.webServiceVendas.interfaces;


import java.util.Map;

import com.WebServicesVendas.webServiceVendas.entities.Order;


public interface IOrderItemService {
	int create(Order order, Map<String, Integer> products);
}
