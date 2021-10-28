package com.example.pocratelimiter;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Component;

@Component
public class RateLimitUpdater {
    final RateLimiter rateLimiter;

    public RateLimitUpdater(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    public void update(double permitsPerSecond) {
        System.out.println("=== Updating rate limit from " + rateLimiter.getRate() + " to " + permitsPerSecond + " ===");
        rateLimiter.setRate(permitsPerSecond);
    }
}
