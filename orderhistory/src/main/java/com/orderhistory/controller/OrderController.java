package com.orderhistory.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orderhistory.entity.OrderEntity;
import com.orderhistory.kafka.JsonKafaProducer;
import com.orderhistory.kafka.KafkaProducer;
import com.orderhistory.payload.User;
import com.orderhistory.service.OrderService;

@RestController
@RequestMapping("/")
public class OrderController {
	
	
	private static Logger LOGERR=LoggerFactory.getLogger(OrderController.class);

	@Autowired
	OrderService orderService;
	
	@Autowired
	KafkaProducer kafkaProducer;
	
	@Autowired
	JsonKafaProducer jsonKafaProducer;
	
	@GetMapping("publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message) {
		LOGERR.info("Inside the publish method message" +message);
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("message sent to topic");
	}
	
	@PostMapping("jsonpublish")
	public ResponseEntity<String> publishJsonMessage(@RequestBody User user) {
		LOGERR.info("Inside the publish method message" +user);
		jsonKafaProducer.sendMessage(user);
		return ResponseEntity.ok("Json message sent to topic");
	}
	
	
	public Optional<OrderEntity> getOrderByOrderNumber(Long number) {
		return orderService.getOrderByOrderNumber(number);
	}
}
