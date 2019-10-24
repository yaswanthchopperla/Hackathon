package com.batch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface LoanService {
	public Items save(Loan loan);	
	public double getApprovedAmountByItemId(int id);
	public double getAppliedAmountByLoanId(int id);
}
