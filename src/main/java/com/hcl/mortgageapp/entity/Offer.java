package com.hcl.mortgageapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is offer entity to store offer details
 */
@Entity
@Table(name = "offer")
public class Offer {

	@Id
	@Column(name = "offer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "loan_amt", nullable = false)
	private Double loanAmt;

	@Column(name = "tenure", nullable = false)
	private Integer tenure;

	@Column(name = "rate_Of_interest", nullable = false)
	private Double rateOfInterest;

	@Column(name = "emi", nullable = false)
	private Double emi;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLoanAmt() {
		return loanAmt;
	}

	public void setLoanAmt(Double loanAmt) {
		this.loanAmt = loanAmt;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public Double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(Double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public Double getEmi() {
		return emi;
	}

	public void setEmi(Double emi) {
		this.emi = emi;
	}

}
