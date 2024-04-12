package com.WebServicesVendas.webServiceVendas.interfaces;
import java.util.List;

import com.WebServicesVendas.webServiceVendas.entities.Order;

public interface IOrderService {

	List<Order> findAll();
}
