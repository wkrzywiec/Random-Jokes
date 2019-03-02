package com.wkrzywiec.medium.periodicquotes;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;


@SpringBootApplication
public class PeriodicQuotesApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory
			.getLogger(PeriodicQuotesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PeriodicQuotesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		LOG.info("\n\n\n\n\t\t\t ---------  PeriodicQuotesApplication is up and running --------- \n\n");


		Observable.interval(2, TimeUnit.SECONDS, Schedulers.io())
				.observeOn(Schedulers.newThread())
				.subscribe(s -> LOG.info("\n\n\t\t\t Task \n\n"));

		Thread.sleep(10000);

        LOG.info("\n\n\t\t\t ---------  PeriodicQuotesApplication ends its work --------- ");
	}
}
