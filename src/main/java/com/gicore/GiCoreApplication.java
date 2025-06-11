package com.gicore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class GiCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(GiCoreApplication.class, args);
	}

}
