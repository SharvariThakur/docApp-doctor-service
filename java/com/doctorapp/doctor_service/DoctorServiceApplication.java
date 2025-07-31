package com.doctorapp.doctor_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableCaching
@EnableKafka
public class DoctorServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(DoctorServiceApplication.class, args);
	}


	@GetMapping("/info")
	public String getInfo()
	{
		return "Hello";
	}
}
