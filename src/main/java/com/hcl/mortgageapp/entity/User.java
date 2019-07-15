package com.hcl.mortgageapp.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is user entity to store user details
 */
@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;

	@Column(name = "dob", nullable = false)
	private LocalDate dob;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "pan", nullable = false)
	private String pan;

	@Column(name = "monthly_salary", nullable = false)
	private double monthlySalary;

	@Column(name = "property_type", nullable = false)
	private String propertyType;

	@Column(name = "property_addr", nullable = false)
	private String propertyAddr;

	@Column(name = "property_pinCode", nullable = false)
	private String propertyPinCode;

	@Column(name = "property_area_size", nullable = false)
	private Double propertyAreaSize;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyAddr() {
		return propertyAddr;
	}

	public void setPropertyAddr(String propertyAddr) {
		this.propertyAddr = propertyAddr;
	}

	public String getPropertyPinCode() {
		return propertyPinCode;
	}

	public void setPropertyPinCode(String propertyPinCode) {
		this.propertyPinCode = propertyPinCode;
	}

	public Double getPropertyAreaSize() {
		return propertyAreaSize;
	}

	public void setPropertyAreaSize(Double propertyAreaSize) {
		this.propertyAreaSize = propertyAreaSize;
	}

}
