package com.WebServicesVendas.webServiceVendas.interfaces;


import java.util.Map;

import com.WebServicesVendas.webServiceVendas.entities.Order;
import com.WebServicesVendas.webServiceVendas.dto.OrderItemRequestDTO;



public interface IOrderItemService {
	int create(Order order, OrderItemRequestDTO products);
}
