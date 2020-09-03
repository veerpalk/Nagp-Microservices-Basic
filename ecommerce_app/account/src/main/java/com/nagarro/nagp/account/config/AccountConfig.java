package com.nagarro.nagp.account.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.nagarro.nagp.account.restclients.errorhandler.RestClientErrorHandler;


@Configuration
public class AccountConfig {
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.setErrorHandler(new RestClientErrorHandler());
		return restTemplate;
		//return new RestTemplate();	
	}	
	
	
}
