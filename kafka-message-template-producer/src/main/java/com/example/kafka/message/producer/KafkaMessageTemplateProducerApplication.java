package com.example.kafka.message.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * curl -d '{"message":"test1"}' -H "Content-Type:application/json" http://localhost:8080/send
 */
@SpringBootApplication
public class KafkaMessageTemplateProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaMessageTemplateProducerApplication.class, args);
	}
}
