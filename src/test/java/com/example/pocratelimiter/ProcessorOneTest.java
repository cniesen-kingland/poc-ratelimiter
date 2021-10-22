package com.example.pocratelimiter;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class ProcessorOneTest {
    RateLimiter rateLimiter = RateLimiter.create(2);

    /**
     * Test the rate limiting of the processor.
     *
     * The rate limiter is set to allow 2 permits per second.
     * The test is requesting 4 permits, which means that processing time should be greater than 1 seconds but less or equals to 2 seconds.
     */
    @Test(timeout = 2000)
    public void process_test() throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i=0; i < 4; i++) {
            new ProcessorOne(rateLimiter).process("Message-" + 1);
        }
        long duration = System.currentTimeMillis() - start;
        assertTrue("Rate limiter fail: Duration is less than expected (" + duration + " milliseconds).", duration > 1000);
        System.out.println("DEBUG: Logic A took " + duration + " MilliSeconds");
    }

}