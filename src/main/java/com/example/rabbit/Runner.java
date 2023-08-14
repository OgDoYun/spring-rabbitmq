package com.example.rabbit;

import java.util.concurrent.TimeUnit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Runner {
    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(RabbitApplication.topicExchangeName,"foo.bar.baz", "Hello rabbit");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }
}
