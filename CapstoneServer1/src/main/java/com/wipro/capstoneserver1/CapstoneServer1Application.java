package com.wipro.capstoneserver1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CapstoneServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneServer1Application.class, args);
	}

}
