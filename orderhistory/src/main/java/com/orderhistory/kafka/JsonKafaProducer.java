package com.orderhistory.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.orderhistory.payload.User;

@Service
public class JsonKafaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafaProducer.class);
	
	@Value("${spring.kafka.topic-json.name}")
	private String jsonTopicName;

	private KafkaTemplate<String, User> kafkaTemplate;

	public JsonKafaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(User data) {
		LOGGER.info(String.format("Messge sent to %s", data.toString()));
		Message<User> message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, jsonTopicName).build();

		kafkaTemplate.send(message);

	}

}
