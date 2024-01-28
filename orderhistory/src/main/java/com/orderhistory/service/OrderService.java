package com.orderhistory.service;

import java.util.Optional;

import com.orderhistory.entity.OrderEntity;

public interface OrderService {
	
	Optional<OrderEntity> getOrderByOrderNumber(Long number);

}
