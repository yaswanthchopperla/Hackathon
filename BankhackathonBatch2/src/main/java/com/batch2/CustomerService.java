package com.batch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public Integer getCustomerId() {

		return customerRepository.getCust_id();
	}
	public Integer getCust_idByLogin_id(Integer login_id) {
		Integer custId = customerRepository.getCust_idByLogin_id(login_id);
		
		return custId;
	}
}
