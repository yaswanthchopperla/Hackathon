package com.batch2;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginRegisterService {

	@Autowired
	private LoginRegisterRepository loginRegisterRepository;
	String username;
	private static final Logger logger = Logger.getLogger(AddressController.class);
	
	
	Integer approveLogin(String username, String password) {
		this.username=username;
		logger.info("Approving Login Details...");
		return loginRegisterRepository.approveLogin(username, password);
		
	}

	public Integer save(Login login) {
		// System.out.println("WebClient : LoginRegisterService..Registration");
		logger.info(login.toString());
		Login result = loginRegisterRepository.save(login);
		logger.info(result.toString());
		if(result.getUsername().equals(login.getUsername())) {
			return result.getLogin_id();
		} else {
			return -1;
		}
	}
	
	
}
