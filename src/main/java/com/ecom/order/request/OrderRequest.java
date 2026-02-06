package com.ecom.order.request;

import java.util.List;

public class OrderRequest {

	private String orderStatus;
	
	private List<OrderItemsRequest> items;

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<OrderItemsRequest> getItems() {
		return items;
	}

	public void setItems(List<OrderItemsRequest> items) {
		this.items = items;
	}
}