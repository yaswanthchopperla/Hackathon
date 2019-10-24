package com.batch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RemoteAddressRepository implements AddressService  {

	@Autowired
	protected RestTemplate restTemplate;  
	
	String serviceUrl;
	
	

	public RemoteAddressRepository() {
		super();
	}

	public RemoteAddressRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://"+serviceUrl;
	}

	@Override
	public void save(Address address) {
		String url = serviceUrl + "/address/saveDetails/";
		System.out.println(url);
		System.out.println(address.toString());
		 ResponseEntity<String> result=restTemplate.postForEntity(url, address, String.class);
	    System.out.println(result);
	}

	@Override
	public Integer getCustId() {
		String url = serviceUrl + "/address/getCust_id";
		System.out.println(url);
		 Integer result= restTemplate.getForObject(url,Integer.class);
	    System.out.println(result);
	    return result;
	}

	
	
}