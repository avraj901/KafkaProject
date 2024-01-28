package com.orderhistory.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.orderhistory.payload.User;

@Service
public class JsonKafkaConsuer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsuer.class);
	
	@KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId="myGroup")
	public void consume(User user) {
		LOGGER.info(String.format("Json message recieved -> %s", user.toString()));
	}
	

}
