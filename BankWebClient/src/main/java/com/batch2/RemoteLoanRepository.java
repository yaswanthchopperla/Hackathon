package com.batch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RemoteLoanRepository implements LoanService {
   
	
	@Autowired
	protected RestTemplate restTemplate;  
	
	String serviceUrl;
	
	

	public RemoteLoanRepository() {
		super();
	}

	public RemoteLoanRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://"+serviceUrl;
	}

	@Override
	public Items save(Loan loan) {
		String url = serviceUrl + "/fetchOffers";
		System.out.println(url);
		ResponseEntity<Items> result=restTemplate.postForEntity(url, loan,Items.class);
		return result.getBody();
	}

	@Override
	public double getApprovedAmountByItemId(int id) {
		String url = serviceUrl + "/getApprovedAmountByItemId/"+id;
		System.out.println(url);
		ResponseEntity<Double> result=restTemplate.postForEntity(url, id,double.class);
		return result.getBody();
	}
	@Override
	public double getAppliedAmountByLoanId(int id) {
		String url = serviceUrl + "/getAppliedAmountByLoanId/"+id;
		System.out.println(url);
		ResponseEntity<Double> result=restTemplate.postForEntity(url, id,double.class);
		return result.getBody();
	}

}
