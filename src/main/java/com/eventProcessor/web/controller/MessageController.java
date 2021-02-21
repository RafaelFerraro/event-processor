package com.eventProcessor.web.controller;

import com.eventProcessor.web.request.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MessageController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/messages")
    public Message sendMessage() {
        kafkaTemplate.send("my-topic", "Hello my friend!");

        return new Message(
            counter.incrementAndGet(),
            String.format("Hello my friend. Your message has been sent")
        );
    }
}
