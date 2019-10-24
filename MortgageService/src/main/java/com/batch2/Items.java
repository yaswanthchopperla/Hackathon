package com.batch2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="items")
public class Items {
	@Id
	private int item_id;
	@Column
	private String item_name;
	@Column
	private double amount;
	@Column
	private double score;
	@Transient
	private int loan_id;
	
	public int getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Items [item_id=" + item_id + ", item_name=" + item_name + ", amount=" + amount + ", score=" + score
				+ ", loan_id=" + loan_id + "]";
	}	
}
