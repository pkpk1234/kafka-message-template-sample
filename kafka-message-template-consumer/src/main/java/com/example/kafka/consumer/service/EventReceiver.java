package com.example.kafka.consumer.service;

import com.example.kafka.playload.Event;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created by pkpk1234 on 2017/5/26.
 */

@Service
public class EventReceiver {

    private EventConsumer eventConsumer;

    @Autowired
    public EventReceiver(EventConsumer eventConsumer) {
        this.eventConsumer = eventConsumer;
    }

    @KafkaListener(topics = {"${evnet.topic}"})
    public void receive(ConsumerRecord<String, Event> consumerRecord) {
        Event event = consumerRecord.value();

    }
}
