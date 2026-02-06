package com.ecom.order.service;

import com.ecom.order.entity.OrderEntity;
import com.ecom.order.request.OrderRequest;

public interface OrderService {
	
	void placeOrder(OrderRequest orderRequest);
	
	OrderEntity getOrderById(int orderId);
}