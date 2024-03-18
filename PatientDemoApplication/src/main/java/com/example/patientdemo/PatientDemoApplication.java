package com.example.patientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PatientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientDemoApplication.class, args);
	}

}
