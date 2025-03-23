package com.civilink.main_management_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MainManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainManagementApiApplication.class, args);
	}

}
