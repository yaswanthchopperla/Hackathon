package com.batch2;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@RestController
public class LoanController {
	@Autowired
	LoanService loanService;
	@Autowired
	CustomerLoanService customerLoanService;
	private static final Logger logger = Logger.getLogger(LoanController.class);

	@PostMapping("/fetchOffers")
	public Items fetchOffers(@RequestBody Loan loan) {
		logger.info("LoanService : fectchOffers()");
		return loanService.save(loan);
	}

	@RequestMapping("/applyloan")
	public CustomerLoan save(@RequestBody CustomerLoan cl) {
		logger.info("CustomerLoanService:applyloan");
		logger.info(cl.toString());
		// customerLoanService.save(cl);
		return customerLoanService.save(cl);
	}
	
	@RequestMapping("/existingLoan")
	public List<CustomerLoan> getMyLoans(@RequestParam("cust_id") int cust_id) {
		return customerLoanService.getMyLoans(cust_id);
	}
    
	@RequestMapping("/getApprovedAmountByItemId/{item_id}")
	public double getApprovedAmountByItemId(@PathVariable("item_id") int item_id) {
		logger.info("/getApprovedAmountByItemId/"+item_id);
		return loanService.getApprovedAmountByItemId(item_id);
	}
	@RequestMapping("/getAppliedAmountByLoanId/{loan_id}")
	public double getAppliedAmountByLoanId(@PathVariable("loan_id") int loan_id) {
		logger.info("/getAppliedAmountByLoanId/"+loan_id);
		return loanService.getAppliedAmountByLoanId(loan_id);
	}
}
