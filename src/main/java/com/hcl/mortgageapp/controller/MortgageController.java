package com.hcl.mortgageapp.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mortgageapp.entity.Offer;
import com.hcl.mortgageapp.model.UserRequest;
import com.hcl.mortgageapp.repository.UserRepository;
import com.hcl.mortgageapp.service.MortgageService;
import com.hcl.mortgageapp.util.ApplicationException;

/*
 * This is the MortgageController for mortgage calculation
 */
@RestController
@RequestMapping("/mortgage")
public class MortgageController {

	@Autowired
	MortgageService mortgageService;
	
	@Autowired
	UserRepository userRepository;
	
	private static final String MANDETORY_ERR_MSG= "Mandetory element missing : "; 
	private static final String USER_NOT_ELIGIBLE_ERR_MSG= "User not eligible for loan. "; 
	/*
	 * This method is used for mortgage calculation
	 * @param gets user details request
	 * @return returns
	 */
	@PostMapping("/calculate")
	public ResponseEntity<?> calculateMortgage(@RequestBody UserRequest userRequest) {
		List<Offer> offer ;
		try {
			checkMandetoryElement(userRequest);
			validateUser(userRequest);
			offer = mortgageService.getOffers(userRequest);
			
		} catch (ApplicationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<Offer>>(offer, HttpStatus.OK);
	}
	
	/*
	 * This method is used to validate user request for mandatory element check
	 * @param userRequest user Request
	 * @throws ApplicationException
	 */
	private void checkMandetoryElement(UserRequest userRequest) throws ApplicationException{
		
		if(ObjectUtils.isEmpty(userRequest)) {
			throw new ApplicationException("Invalid Request");
		}
		if(StringUtils.isEmpty(userRequest.getDob())) {
			throw new ApplicationException(MANDETORY_ERR_MSG + "DOB");
		}
		if(StringUtils.isEmpty(userRequest.getGender())) {
			throw new ApplicationException(MANDETORY_ERR_MSG + "Gender");
		}
		if(StringUtils.isEmpty(userRequest.getMonthlySalary())) {
			throw new ApplicationException(MANDETORY_ERR_MSG + "Monthly Salary");
		}
		if(StringUtils.isEmpty(userRequest.getPan())) {
			throw new ApplicationException(MANDETORY_ERR_MSG + "Pan(");
		}
		if(StringUtils.isEmpty(userRequest.getPhoneNumber())) {
			throw new ApplicationException(MANDETORY_ERR_MSG + "PhoneNumber");
		}
		if(StringUtils.isEmpty(userRequest.getPropertyAddr())) {
			throw new ApplicationException(MANDETORY_ERR_MSG + "Property Address");
		}
		if(StringUtils.isEmpty(userRequest.getPropertyAreaSize())) {
			throw new ApplicationException(MANDETORY_ERR_MSG + "Property Area Size");
		} 
		if(StringUtils.isEmpty(userRequest.getPropertyPinCode())) {
			throw new ApplicationException(MANDETORY_ERR_MSG + "Property Pin Code");
		}
		if(StringUtils.isEmpty(userRequest.getPropertyType())) {
			throw new ApplicationException(MANDETORY_ERR_MSG + "Property Type");
		}
		if(StringUtils.isEmpty(userRequest.getUsername())) {
			throw new ApplicationException(MANDETORY_ERR_MSG + "Username");
		}
		
	}

	/*
	 * This method is used to validate user request
	 * @param userRequest user Request
	 * @throws ApplicationException
	 */
	private void validateUser(UserRequest userRequest) throws ApplicationException{
		Period diff = Period.between(userRequest.getDob(), LocalDate.now());
		if(diff.getYears() < 25) {
			throw new ApplicationException(USER_NOT_ELIGIBLE_ERR_MSG + "Age should be greater than 25.");
		}
		if(userRequest.getMonthlySalary() < 10000) {
			throw new ApplicationException(USER_NOT_ELIGIBLE_ERR_MSG + "Salary should be greater than 10000rs.");
		}
	}
	
}
