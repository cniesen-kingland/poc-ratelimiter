package com.example.pocratelimiter;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcessorOne {
    RateLimiter rateLimiter = RateLimiter.create(2);

    public void process() {
        rateLimiter.acquire();
        System.out.println( getCurrentTimeStamp() + " " + Thread.currentThread().getName() + " Completed..........");
    }

    private String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSS").format(new Date());
    }
}

