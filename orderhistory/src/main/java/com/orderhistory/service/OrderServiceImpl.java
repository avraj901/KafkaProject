package com.orderhistory.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderhistory.entity.OrderEntity;
import com.orderhistory.repository.OrdrRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrdrRepository orderRepository;
	
	@Override
	public Optional<OrderEntity> getOrderByOrderNumber(Long number) {
		
		return orderRepository.findById(number);
	}
	

}
