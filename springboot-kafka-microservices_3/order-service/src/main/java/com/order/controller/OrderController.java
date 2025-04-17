package com.order.controller;

import org.apache.kafka.common.Uuid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.dto.Order;
import com.base.dto.OrderEvent;
import com.order.kafka.OrderProducer;

@RestController
@RequestMapping("api/v1")
public class OrderController {

	OrderProducer orderProducer;

	public OrderController(OrderProducer orderProducer) {
		super();
		this.orderProducer = orderProducer;
	}

	@PostMapping("/orders")
	public String placeOrder(@RequestBody Order order) {

		order.setOrderId(Uuid.randomUuid().toString());

		OrderEvent orderEvent = new OrderEvent();
		orderEvent.setStatus("PENDING");
		orderEvent.setOrder(order);
		orderProducer.sendMessage(orderEvent);

		return "Order PLaced Successfully";

	}
}
