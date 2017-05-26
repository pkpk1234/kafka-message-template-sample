package com.example.kafka.consumer.service;

import com.example.kafka.playload.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by pkpk1234 on 2017/5/26.
 */
@Component
public class EventConsumer {
    private static Logger logger = LoggerFactory.getLogger(EventConsumer.class);

    @KafkaListener(topics = "${evnet.topic}")
    public void consume(Event event) {
        logger.info("Consume event: {}", event);
    }
}
