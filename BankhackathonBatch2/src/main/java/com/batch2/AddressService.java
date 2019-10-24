package com.batch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;

	void saveCustomer(String name, Integer addr_id) {
	}

	public Address save(Address address) {
		System.out.println(address.toString());
		return addressRepository.save(address);
	}

	public Integer getAddressId() {

		return addressRepository.getAddressId();
	}
}
