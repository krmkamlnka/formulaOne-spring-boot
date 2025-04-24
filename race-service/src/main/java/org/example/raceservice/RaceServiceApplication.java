package org.example.raceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RaceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaceServiceApplication.class, args);
	}

}
