package com.example.rabbit;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

import com.example.rabbit.domain.Hashinator;
import org.springframework.stereotype.Component;


@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) throws NoSuchAlgorithmException {
        String hashed = Hashinator.md5(message);
        System.out.println(hashed);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}