package com.ecom.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* 
 * This is child table entity, a Column with Foreign Key (FK) named orderid will be auto created
 * by JPA, and the orderid row of this table will be pointing the the Primary Key (PK) orderid
 * of the Orders table. This one to many relationship will be auto created by JPA
 */


@Entity
@Table(name = "order_items")
public class OrderItemsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemsId;

	private String itemName;
	private int quantity;
	private int price;

	public int getOrderItemsId() {
		return orderItemsId;
	}

	public void setOrderItemsId(int orderItemsId) {
		this.orderItemsId = orderItemsId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}