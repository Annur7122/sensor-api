package com.example.sensor_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.sensor_api"})
public class SensorApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(SensorApiApplication.class, args);
	}
}
