package com.example.pocratelimiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class PocRatelimiterApplication implements CommandLineRunner {

	@Autowired
	JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PocRatelimiterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i=0; i < 5; i++){
			jmsTemplate.convertAndSend("test", "Message-" + i);
		}
	}
}
