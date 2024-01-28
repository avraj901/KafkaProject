package com.orderhistory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderNumber;
	
	private String customerFirstName;

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}
	
	
	

	public OrderEntity() {
		
	}

	public OrderEntity(Long orderNumber, String customerFirstName) {
		
		this.orderNumber = orderNumber;
		this.customerFirstName = customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	
}
