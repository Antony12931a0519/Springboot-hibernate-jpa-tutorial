package com.java.training.messaging.standaloneactivemqexample.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "producer.consumer.example")
    public void consume1(String message) {
        System.out.println("Received Message fro the queue: " + message);
    }
}
