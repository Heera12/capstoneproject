package com.wipro.capstonechatapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CapstoneChatApplicationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneChatApplicationsApplication.class, args);
	}

}
