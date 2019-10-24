package com.batch2;

public class Loan {
    private Integer loan_id;
    private double loanamount;
    private Integer area_code;
    private double area_size;
    private double credit_score;
    private String legal_residence;
    
	public double getCredit_score() {
		return credit_score;
	}
	public void setCredit_score(double credit_score) {
		this.credit_score = credit_score;
	}
	public Integer getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(Integer loan_id) {
		this.loan_id = loan_id;
	}
	public double getLoanamount() {
		return loanamount;
	}
	public void setLoanamount(double loanamount) {
		this.loanamount = loanamount;
	}
	public Integer getArea_code() {
		return area_code;
	}
	public void setArea_code(Integer area_code) {
		this.area_code = area_code;
	}
	public double getArea_size() {
		return area_size;
	}
	public void setArea_size(double area_size) {
		this.area_size = area_size;
	}
	public String getLegal_residence() {
		return legal_residence;
	}
	public void setLegal_residence(String legal_residence) {
		this.legal_residence = legal_residence;
	}
	@Override
	public String toString() {
		return "Loan [loan_id=" + loan_id + ", loanamount=" + loanamount + ", area_code=" + area_code + ", area_size="
				+ area_size + ", credit_score=" + credit_score + ", legal_residence=" + legal_residence + "]";
	}
	  
}
