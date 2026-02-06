package com.ecom.order.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.order.entity.OrderEntity;
import com.ecom.order.entity.OrderItemsEntity;
import com.ecom.order.repo.OrderRepo;
import com.ecom.order.request.OrderItemsRequest;
import com.ecom.order.request.OrderRequest;
import com.ecom.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepo repo;

	@Override
	public void placeOrder(OrderRequest orderRequest) {
		
		OrderEntity entity = new OrderEntity();
		
		entity.setOrderStatus(orderRequest.getOrderStatus());
		
		List<OrderItemsEntity> orderItemsEntity = new ArrayList<>();
		
		for(OrderItemsRequest itemsRequested : orderRequest.getItems()) {
			
			OrderItemsEntity items = new OrderItemsEntity();
			
			items.setItemName(itemsRequested.getItemName());
			items.setQuantity(itemsRequested.getQuantity());
			items.setPrice(itemsRequested.getPrice());
			
			orderItemsEntity.add(items);
		}
		
		entity.setItems(orderItemsEntity);
		
		repo.save(entity);
	}

	@Override
	public OrderEntity getOrderById(int orderId) {
		
		Optional<OrderEntity> response = repo.findById(orderId);
		
		if(response.isPresent()) return response.get();
		
		else return null;
		
		/* We can also use : return repo.findById(orderId).orElse(null); */
	}
}