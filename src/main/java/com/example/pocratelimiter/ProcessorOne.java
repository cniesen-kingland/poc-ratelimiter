package com.example.pocratelimiter;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ProcessorOne {

    @JmsListener(destination = "test")
    public void process(String message) {
        System.out.println( getCurrentTimeStamp() + " " + Thread.currentThread().getName() + " " + message + " Completed..........");
    }

    private String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSS").format(new Date());
    }
}

