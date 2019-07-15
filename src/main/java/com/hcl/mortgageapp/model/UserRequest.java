package com.hcl.mortgageapp.model;

import java.time.LocalDate;

/*
 * This is user request POJO
 */
public class UserRequest {

	private String username;

	private String phoneNumber;

	private LocalDate dob;

	private String gender;

	private String pan;

	private double monthlySalary;

	private String propertyType;

	private String propertyAddr;

	private String propertyPinCode;

	private Double propertyAreaSize;

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

	@Override
	public String toString() {
		return "UserRequest [username=" + username + ", phoneNumber=" + phoneNumber + ", dob=" + dob
				+ ", gender=" + gender + ", pan=" + pan + ", monthlySalary=" + monthlySalary + ", propertyType="
				+ propertyType + ", propertyAddr=" + propertyAddr + ", propertyPinCode=" + propertyPinCode
				+ ", propertyAreaSize=" + propertyAreaSize + "]";
	}

	
}
