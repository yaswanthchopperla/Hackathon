package com.batch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RemoteCustomerRepository implements CustomerService{

	@Autowired
	protected RestTemplate restTemplate;  
	
	String serviceUrl;
	
	

	public RemoteCustomerRepository() {
		super();
	}

	public RemoteCustomerRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://"+serviceUrl;
	}
	@Override
	public Integer getCust_idByLogin_id(Integer login_id) {
			String url = serviceUrl + "/getCust_id/"+login_id;
			System.out.println(url);
			int result=restTemplate.getForObject(url, Integer.class);
		    System.out.println(result);
			return result;
		}
	}
        
