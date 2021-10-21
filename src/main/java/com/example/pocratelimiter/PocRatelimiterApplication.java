package com.example.pocratelimiter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocRatelimiterApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PocRatelimiterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i=0; i < 5; i++){
			ProcessOneThreadWrapper thread = new ProcessOneThreadWrapper();
			thread.start();
		}
	}
}
