package com.example.kafka.message.producer.service;

import com.example.kafka.playload.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by pkpk1234 on 2017/5/26.
 */
@Service
public class EventSender {

    @Value("${evnet.topic}")
    private String topic;

    private KafkaTemplate<String, Event> template;

    @Autowired
    public EventSender( KafkaTemplate<String, Event> template) {
        this.template = template;
    }

    public SendResult<String, Event> sendEvent(Event event) throws ExecutionException, InterruptedException, TimeoutException {
        ListenableFuture<SendResult<String, Event>> result = this.template.send(topic, event);
        return result.get(1, TimeUnit.MINUTES);
    }
}
