package com.salereport;

import com.salereport.observer.FileObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SaleReportApplication implements CommandLineRunner {

	@Autowired
	private FileObserver fileObserver;

	public static void main(String[] args) {
		SpringApplication.run(SaleReportApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fileObserver.startObserver();
	}
}
