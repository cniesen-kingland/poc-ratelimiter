package com.example.pocratelimiter;


import com.google.common.util.concurrent.RateLimiter;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ProcessorOne {
    final RateLimiter rateLimiter;

    public ProcessorOne(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    @JmsListener(destination = "test")
    public void process(String message) {
        rateLimiter.acquire();
        System.out.println( getCurrentTimeStamp() + " " + Thread.currentThread().getName() + " Processor-One " + message + " Completed..........");
    }

    private String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSS").format(new Date());
    }
}

