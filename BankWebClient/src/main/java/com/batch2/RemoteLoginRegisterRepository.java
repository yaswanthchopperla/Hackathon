package com.batch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class RemoteLoginRegisterRepository implements LoginRegisterService{

	@Autowired
	protected RestTemplate restTemplate;  
	
	String serviceUrl;

	
	public RemoteLoginRegisterRepository() {
		super();
	}

	public RemoteLoginRegisterRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://"+serviceUrl;
	}

	@Override
	public String authentication(String username, String password) {
		// System.out.println("authentication in RemoteLoginRegisterRepository");
		String url = serviceUrl + "/user/authenticate/"+username+"/"+password;
		// System.out.println(url);
		String name = restTemplate.getForObject(url, String.class);
		if(username.equals(name)) {
			 return "success";
		  } else {
			  return "error";
		  }
	}

	@Override
	public Integer save(String username,String password) {
		// System.out.println("authentication in RemoteLoginRegisterRepository");
		String url = serviceUrl + "/user/validateRegistrationForm"+"/"+username+"/"+password;
		// System.out.println(url);
		Integer result = restTemplate.getForObject(url, Integer.class);
		return result;
	}

	@Override
	public Integer[] approveLogin(String username, String password) {
		String url = serviceUrl + "/user/approveLogin/"+username+"/"+password;
		// System.out.println(url);
		return restTemplate.getForObject(url, Integer[].class);
		
	}
	
	

	
	

}
