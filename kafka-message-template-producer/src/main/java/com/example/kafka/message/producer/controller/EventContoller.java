package com.example.kafka.message.producer.controller;

import com.example.kafka.message.producer.service.EventSender;
import com.example.kafka.playload.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * Created by pkpk1234 on 2017/5/25.
 */

@RestController
public class EventContoller {

    private EventSender eventSender;

    @Autowired
    public EventContoller(EventSender eventSender) {
        this.eventSender = eventSender;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEvent(@RequestBody Event event) throws InterruptedException, ExecutionException, TimeoutException {
        this.eventSender.sendEvent(event);
        return ResponseEntity.ok("Send Event to Kafka");
    }
}
