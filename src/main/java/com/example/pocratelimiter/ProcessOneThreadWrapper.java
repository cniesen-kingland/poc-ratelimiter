package com.example.pocratelimiter;

public class ProcessOneThreadWrapper extends Thread {
    @Override
    public void run() {
        ProcessorOne processor = new ProcessorOne();
        processor.process();
    }
}
