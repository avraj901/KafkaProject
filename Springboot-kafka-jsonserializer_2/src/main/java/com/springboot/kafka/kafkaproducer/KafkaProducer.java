package com.springboot.kafka.kafkaproducer;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.springboot.kafka.payload.User;

@Service
public class KafkaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
	
	private KafkaTemplate<String, User> kafkaTemplate;

	public KafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(User user) {
		
		LOGGER.info("Messge sent User Object  : {}" , user.toString());
		
		Message<User> message = MessageBuilder.withPayload(user)
		.setHeader(KafkaHeaders.TOPIC, "javaguides_json")
		.build();
		
		kafkaTemplate.send(message);
	}
}
