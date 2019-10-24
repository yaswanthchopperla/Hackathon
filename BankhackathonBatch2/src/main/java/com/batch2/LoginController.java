package com.batch2;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	private LoginRegisterService loginRegisterService;
	
	@Autowired
	private CustomerService customerService;
	
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	  
	  @RequestMapping("/validateRegistrationForm/{username}/{password}") 
	  public ResponseEntity<Integer> validateRegistrationForm(@PathVariable("username")String username,@PathVariable("password") String password) {
		  Login login = new Login();
		  ModelAndView mv = new ModelAndView();
		  login.setUsername(username);
		  login.setPassword(password);
		// System.out.prIntegerln("LoginController : Registration ....."+login.getUsername()+"/"+login.getPassword());
		  Integer login_id  = loginRegisterService.save(login);
		  if(login_id == null) {
			  return new ResponseEntity<Integer>(login_id,HttpStatus.BAD_REQUEST);
		  }
		  return new ResponseEntity<Integer>(login_id,HttpStatus.OK);
		  
	  }
	 

	  
	  @RequestMapping(value="/approveLogin/{username}/{password}")
	  public ResponseEntity<Integer[]> approveLogin(@PathVariable("username")String username,@PathVariable("password") String password ) {
		  
		  logger.info("Authentication in LoginController : " + username + " : " +password);
		  ModelAndView mv = new ModelAndView();
		  logger.info("Authenticating Username and Password");
		  Integer login_id = loginRegisterService.approveLogin(username, password);
		  Integer cust_id = 0;
		  if(login_id != null) {
			  cust_id =  getCustId(login_id);
		  }
		 
		  logger.info("LoginId : "+ login_id);
		  logger.info("CustId : "+ cust_id);
		  
		  Integer[] ids = new Integer[2];
		  ids[0] = login_id;
		  ids[1] = cust_id;
		  if(login_id != null) {
			  return new ResponseEntity<Integer[]>(ids,HttpStatus.OK);
		  } else {
			  return new ResponseEntity<Integer[]>(ids,HttpStatus.BAD_REQUEST);
		  }
		 
	  }
	  
	  public Integer getCustId(Integer login_id) {
		  return customerService.getCust_idByLogin_id(login_id);
	  }
	  
    
}
