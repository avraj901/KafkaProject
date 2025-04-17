package com.springboot.kafka.kafkaproducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springboot.kafka.payload.User;

@Service
public class KafkaConsumer {

	private static final Logger LOGGER= LoggerFactory.getLogger(KafkaConsumer.class);
	
	
	@KafkaListener(topics = "javaguides_json", groupId = "myGroup")
	public void consume(User user) {
		
		LOGGER.info("message received : {}", user);
	}
}
