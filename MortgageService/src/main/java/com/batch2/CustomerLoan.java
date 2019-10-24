package com.batch2;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "customer_loan")
public class CustomerLoan {

	@Id
	private int loan_id;
	private int cust_id;
	private int item_id;
	private Date applied_on;
	private String status;
	@Transient
	private double appliedAmount;
	@Transient
	private double approvedAmount;

	public double getAppliedAmount() {
		return appliedAmount;
	}

	public void setAppliedAmount(double appliedAmount) {
		this.appliedAmount = appliedAmount;
	}

	public double getApprovedAmount() {
		return approvedAmount;
	}

	public void setApprovedAmount(double approvedAmount) {
		this.approvedAmount = approvedAmount;
	}

	public int getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public Date getApplied_on() {
		return applied_on;
	}

	public void setApplied_on(Date applied_on) {
		this.applied_on = applied_on;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CustomerLoan [loan_id=" + loan_id + ", cust_id=" + cust_id + ", item_id=" + item_id + ", applied_on="
				+ applied_on + ", status=" + status + ", appliedAmount=" + appliedAmount + ", approvedAmount="
				+ approvedAmount + "]";
	}

}
