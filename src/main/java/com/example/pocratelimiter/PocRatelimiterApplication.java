package com.example.pocratelimiter;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class PocRatelimiterApplication implements CommandLineRunner {

	@Autowired
	JmsTemplate jmsTemplate;

	@Autowired
	RateLimitUpdater rateLimitUpdater;

	@Bean
	public RateLimiter jmsRateLimiter() {
		return RateLimiter.create(2);
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PocRatelimiterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i=0; i < 30; i++){
			jmsTemplate.convertAndSend("test", "Message-" + i);
		}
		rateLimitUpdater.update(4);
		for (int i=0; i < 30; i++){
			jmsTemplate.convertAndSend("test", "Message-" + i);
		}

	}
}
