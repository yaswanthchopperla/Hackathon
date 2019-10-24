package com.batch2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableEurekaClient
public class BankWebClientApplication implements WebMvcConfigurer{
	public static final String LOGIN_SERVICE_URL = "http://BankLoginRegisterService";
	public static final String LOAN_SERVICE_URL = "http://LoanService";

	
	public static void main(String[] args) {
		SpringApplication.run(BankWebClientApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public LoginRegisterService loginRegisterService() {
		return new RemoteLoginRegisterRepository(LOGIN_SERVICE_URL);
	} 
	
	@Bean
	public AddressService addressService() {
		return new RemoteAddressRepository(LOGIN_SERVICE_URL);
	} 
	@Bean
	public CustomerService customerService() {
		return new RemoteCustomerRepository(LOGIN_SERVICE_URL);
	} 
	
	@Bean
	public LoanService loanService() {
		return new RemoteLoanRepository(LOAN_SERVICE_URL);
	} 
	@Bean
	public CustomerLoanService customerloanService() {
		return new RemoteCustomerLoanRepository(LOAN_SERVICE_URL);
	} 
	
	

}
