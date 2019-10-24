package com.batch2;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WebClientController {

	String message = " ";
	@Autowired
	LoginRegisterService loginRegisterService;

	@Autowired
	AddressService addressService;
	@Autowired
	CustomerService customerService;
	@Autowired
	LoanService loanService;
	@Autowired
	CustomerLoanService customerLoanService;
	
	int result;
	
	private static final Logger logger = Logger.getLogger(WebClientController.class);

	Integer cust_id;
	Integer login_id;
	int loan_id;
	int item_id;

	@RequestMapping("/")
	public ModelAndView displayLoginPage() {
		logger.info("display login page");
		ModelAndView mv = new ModelAndView();
		mv.addObject("error", " ");
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping("/home")
	public ModelAndView displayHomePage() {
		ModelAndView mv = new ModelAndView();
		logger.info("WebClientController:DisplayHomepage"+cust_id);
		mv.addObject("cust_id",cust_id);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/fetchOffers")
	public ModelAndView fetchOffers(Loan loan) {
		logger.info("WebClientController : fectchOffers()");
		ModelAndView mv = new ModelAndView();
		if ((!(loan.getLegal_residence().equals("indian")))&&((loan.getCredit_score()>1)&&(loan.getCredit_score()<10))) {
			message = "You are not eligible for loan";
			mv.addObject("message", message);
			mv.setViewName("loan");
			return mv;
		}
		Items items = loanService.save(loan);
		item_id = items.getItem_id();
		loan_id = items.getLoan_id();
		
		logger.info("webClientController:"+loan_id);
		mv.addObject("Item", items);
		mv.addObject("cust_id", cust_id);
		mv.setViewName("offers");
		return mv;

	}
	@RequestMapping("/martgageCalc")
	public ModelAndView displayMortgageCalcPage() {
		// logger.info("display login page");
		ModelAndView mv = new ModelAndView();
		// mv.addObject("error"," ");
		mv.setViewName("mortgageCalc");
		return mv;
	}

	@RequestMapping("/loan")
	public ModelAndView displayLoanPage() {
		logger.info("display loan page");
		// int cust_id= customerService.getCust_idByLogin_id(result);
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", " ");
		mv.setViewName("loan");
		return mv;
	}

	@RequestMapping("/register")
	public ModelAndView displayRegisterForm() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("error", "Password and Confirm Password Should Be Same");
		mv.setViewName("register");
		return mv;
	}

	@RequestMapping("/validateRegistrationForm")
	public ModelAndView validateRegistrationForm(String username, String password, String confirmPassword) {
		ModelAndView mv = new ModelAndView();
		logger.info("WebClient :Controller :  Registration ....." + username + "/" + password);
		if (password.equals(confirmPassword)) {

			login_id = loginRegisterService.save(username, password);
			// handle username already exist error
			// if registration is successfull the go to SetProfile page
			if (result != -1) {
				mv.addObject("login_id", login_id);
				mv.setViewName("setProfile");
			} else {
				mv.addObject("error", result);
				mv.setViewName("login");
			}

		} else {
			mv.addObject("error", "Password and Confirm Password Dosn't Match ");
			mv.setViewName("register");
		}
		return mv;
	}

	@RequestMapping("/user/authenticate")
	public ModelAndView loginAuthentication(String username, String password) {
		logger.info("authentication in web controller");
		// String name = loginRegisterService.authentication(username, password);
		Integer[] ids = loginRegisterService.approveLogin(username, password);
		cust_id =ids[1];
		logger.info("WebClientController:LoginAuthentication "+cust_id);
		ModelAndView mv = new ModelAndView();
		if(cust_id == null) {
			mv.addObject("login_id", ids[0]);
			mv.setViewName("setProfile");
		}
		else if (cust_id == 0) {
			mv.addObject("error", "Username or Password incorrect");
			mv.setViewName("login");
			
			logger.info("WebClientController : CustomerId " + cust_id);
		} else {
			mv.addObject("cust_id",cust_id);
			mv.setViewName("home");
			logger.info("WebClientController : CustomerId " + cust_id);
		}
		return mv;
	}

	@RequestMapping("/setProfile")
	public ModelAndView getEmployee() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("setProfile");
		return mv;
	}

	@RequestMapping("/saveDetails")
	public ModelAndView user(Address address) {
		addressService.save(address);
		ModelAndView mv = new ModelAndView();
		mv.addObject("cust_id",cust_id);
		mv.setViewName("home");
		
		cust_id = addressService.getCustId();
		logger.info("WebClientController : CustomerId " + cust_id);
		return mv;

	}
	
	
	@RequestMapping("/applyloan")
	public ModelAndView applyLoan() {
		CustomerLoan cl=new CustomerLoan();
		cl.setCust_id(cust_id);
		cl.setItem_id(item_id);
		cl.setLoan_id(loan_id);
		cl.setStatus("pending");
		cl.setApplied_on(new Date());
		logger.info(cl.toString());
		customerLoanService.save(cl);
		ModelAndView mv = new ModelAndView();
		mv.addObject("cust_id",cust_id);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/existingLoan")
	public ModelAndView getMyLoans(@RequestParam("cust_id") int cust_id) {
		List<CustomerLoan> csl = customerLoanService.getMyLoans(cust_id);
		logger.info("existingLoan : cust_id " + cust_id);
		for (CustomerLoan cl : csl) {
			
			int itemid=cl.getItem_id();
			double approvedAmount=loanService.getApprovedAmountByItemId(itemid);
			logger.info("existingLoan : item_id "+itemid + " ApprovedAmount " + approvedAmount);
			cl.setApprovedAmount(approvedAmount);
			
			int id=cl.getItem_id();
			double appliedAmount=loanService.getAppliedAmountByLoanId(id);
			logger.info("existingLoan : laon_id "+ id + " AppliedAmount " + appliedAmount);
			cl.setAppliedAmount(appliedAmount);
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("csl",csl);
		mv.setViewName("existingLoanPage");
		return mv;
		
	}
	 
	
}
