package com.batch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
	@Autowired
	LoanRepository loanRepository;

	public Items save(Loan loan) {
		System.out.println(loan.toString());
		Loan l = loanRepository.save(loan);
		loanRepository.flush();
		// System.out.println("LoanService : Loan_id : "+l.getLoan_id());
		
		System.out.println("Loan service: Save Info");
		System.out.println(l.toString());
		double score = calculateScore(loan);
		System.out.println("Loanservice:" + score);
		Items item = loanRepository.getItem(score);
		item.setLoan_id(l.getId());
		return item;
	}

	public double getPropertyPrice(int area_code, double area_size) {

		double price;
		if (area_code >= 10 && area_code < 99) {
			price = area_size * 1000;
		} else if (area_code >= 100 && area_code < 1000) {
			price = area_size * 1100;
		} else {
			price = area_size * 1200;
		}
		System.out.println(" Loan Service:getPropertyPrice" + price);
		return price;
	}

	public double calculateScore(Loan loan) {
		System.out.println(" Loan Service:CalculateLoanScore");
		int areacode = loan.getArea_code();
		double size = loan.getArea_size();
		double price = getPropertyPrice(areacode, size);
		double cs = loan.getCredit_score();
		String residence = loan.getLegal_residence();
		double score;
		score = ((price % 100) + 5) * cs;
		double temp = Math.round(score);

		if ((temp % 10) != 0) {
			score += 5;
		}
		return score;
	}
	public double getApprovedAmountByItemId(int id) {
		return loanRepository.getApprovedAmountByItemId(id);
	}
	public double getAppliedAmountByLoanId(int id) {
		return loanRepository.getAppliedAmountByLoanId(id);
	}

}
