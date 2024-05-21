package com.dashboardaf.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DashboardAfBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardAfBackendApplication.class, args);
	}
}