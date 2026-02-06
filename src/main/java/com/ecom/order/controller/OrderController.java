package com.ecom.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.order.entity.OrderEntity;
import com.ecom.order.request.OrderRequest;
import com.ecom.order.service.impl.OrderServiceImpl;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderServiceImpl orderService;
	
	@PostMapping("/place-order")
	public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderReq) {
		
		System.out.println("OrderController.placeOrder()::::::::::::");
		
		orderService.placeOrder(orderReq);
		
		return ResponseEntity.ok(" The order has been placed successfully!!");
	}
	
	@GetMapping("/fetch-order/{id}")
	public String fetchOrder(@PathVariable int id) {
		
		System.out.println("OrderController.fetchOrder()");
		
		OrderEntity response = orderService.getOrderById(id);
		
		if(response != null) {
			return " Order ID: " + response.getOrderId() + " || Order Status : " + response.getOrderStatus();
		}
		
		return " Order with the mentioned id could not be found!!";
	}
}