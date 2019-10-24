package com.batch2;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CustomerService customerService;
	@Autowired
	LoginRegisterService loginRegisterService;

	Integer cust_id;

	private static final Logger logger = Logger.getLogger(AddressController.class);

	/*
	 * @RequestMapping("/") public ModelAndView getEmployee() { ModelAndView mv =
	 * new ModelAndView(); mv.setViewName("SetProfile"); return mv; }
	 */

	@RequestMapping("/saveDetails")
	public ResponseEntity<String> saveAddress(@RequestBody Address address) {
		logger.info("Saving the address details to database");
		String name = address.getName();
		Integer login_id = address.getLogin_id();
		logger.info("Address Controller: saveDetails");
		Address a = addressService.save(address);

		Integer addr_id = addressService.getAddressId();
		logger.info("login_id is :" + login_id);
		// loginRegisterService.update(login_id);

		logger.info("Addr_ID : " + addr_id);
		logger.info("NAME : " + name);
		if (a.getAdd_id() == addr_id) {
			return new ResponseEntity<String>("addr_id", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("addr_id", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping("/getCust_id")
	public Integer getCust_id() {
		return cust_id;
	}

	public String saveCustomer(String name, Integer addr_id, Integer login_id) {
		System.out.println("Address Controller: Saving Customer");
		Customer customer = new Customer();
		customer.setName(name);
		customer.setAdd_id(addr_id);
		customer.setCredit_score(8);
		customer.setLogin_id(login_id);
		Customer c = customerRepository.save(customer);
		cust_id = c.getCust_id();
		return "home";
	}

}