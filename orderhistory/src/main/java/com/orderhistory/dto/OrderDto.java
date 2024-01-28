package com.orderhistory.dto;

import org.springframework.stereotype.Component;

@Component
public class OrderDto {

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

	public OrderDto(Long orderNumber, String customerFirstName) {
		super();
		this.orderNumber = orderNumber;
		this.customerFirstName = customerFirstName;
	}

	public OrderDto() {
		super();
	}
	
	

}
