package com.wkrzywiec.medium.periodicquotes;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PeriodicQuotesApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory
			.getLogger(PeriodicQuotesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PeriodicQuotesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		LOG.info("Test");

		Flowable.just("Hello world").subscribe(System.out::println);
	}
}
