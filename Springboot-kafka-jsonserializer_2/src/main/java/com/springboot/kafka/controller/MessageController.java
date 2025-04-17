package com.springboot.kafka.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.springboot.kafka.kafkaproducer.KafkaProducer;
import com.springboot.kafka.payload.User;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {

	private KafkaProducer kafkaProducer;

	public MessageController(KafkaProducer kafkaProducer) {
		super();
		this.kafkaProducer = kafkaProducer;
	}

	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User user) {
		kafkaProducer.sendMessage(user);
		return new ResponseEntity<>("Message send to the Kafka topic javaguides", HttpStatus.OK);
	}

}
