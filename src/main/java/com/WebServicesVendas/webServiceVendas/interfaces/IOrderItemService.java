package com.WebServicesVendas.webServiceVendas.interfaces;

import java.util.List;

import com.WebServicesVendas.webServiceVendas.entities.Product;

public interface IOrderItemService {
     Long create(Long idOrderService, List<Product> products);
}
