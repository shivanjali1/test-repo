package com.hcl.mortgageapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is entity to store mapping between pin code and property rate
 */
@Entity
@Table(name = "property_rate")
public class PropertyRate {

	@Id
	@Column(name = "property_rate_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "pinCode", nullable = false, unique = true)
	private String pinCode;

	@Column(name = "sq_ft_area_rate", nullable = false)
	private Double sqFtAreaRate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public Double getSqFtAreaRate() {
		return sqFtAreaRate;
	}

	public void setSqFtAreaRate(Double sqFtAreaRate) {
		this.sqFtAreaRate = sqFtAreaRate;
	}

}
