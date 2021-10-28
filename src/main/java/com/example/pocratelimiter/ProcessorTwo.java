package com.example.pocratelimiter;


import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ProcessorTwo {
    final RateLimiter rateLimiter;

    public ProcessorTwo(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    @JmsListener(destination = "test", concurrency = "2-2")
    public void process(String message) {
        rateLimiter.acquire();
        System.out.println( getCurrentTimeStamp() + " " + Thread.currentThread().getName() + " Processor-Two " + message + " Completed..........");
    }

    private String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSS").format(new Date());
    }
}

