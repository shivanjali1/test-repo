package com.hcl.mortgageapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.mortgageapp.entity.Offer;
import com.hcl.mortgageapp.entity.PropertyRate;
import com.hcl.mortgageapp.entity.User;
import com.hcl.mortgageapp.model.UserRequest;
import com.hcl.mortgageapp.repository.OfferRepository;
import com.hcl.mortgageapp.repository.PropertyRateRepository;
import com.hcl.mortgageapp.repository.UserRepository;
import com.hcl.mortgageapp.util.ApplicationException;


@Service
public class MortgageService {
	
	@Autowired
	PropertyRateRepository propertyRateRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OfferRepository offerRepository;
	
	private static final String USER_NOT_ELIGIBLE_ERR_MSG= "User not eligible for loan."; 
	/*
	 * This method is used to calculate ProprtyValue based on pin code
	 * @param userRequest userRequest
	 * @returns propertyValue
	 * @throws ApplicationException
	 */
	public Double calculateProprtyValue(UserRequest userRequest) throws ApplicationException {
		Optional<PropertyRate> optionalPropertyRate = propertyRateRepository.findByPinCode(userRequest.getPropertyPinCode());
		
		if(optionalPropertyRate.isPresent()) {
			PropertyRate propertyRate = optionalPropertyRate.get();
			
			Double sqFtAreaRate = propertyRate.getSqFtAreaRate();
			Double propertyAreaSize = userRequest.getPropertyAreaSize() ;
			Double propertyValue = sqFtAreaRate * propertyAreaSize;
			return propertyValue;
		}else {
			throw new ApplicationException("Invalid pin code");
		}
	}
	
	/*
	 * This method is used to persist user details
	 * @param userRequest userRequest
	 */
	public void persistUser(UserRequest userRequest) {
		User user = new User();
		BeanUtils.copyProperties(userRequest, user);
		userRepository.save(user);
	}
	
	/*
	 * This method is used to get Offers based on property value
	 * @param propertyValue
	 */
	public List<Offer> getOffers(UserRequest userRequest) throws ApplicationException{
		
		Double propertyValue = calculateProprtyValue(userRequest);
		System.out.println("Property value is : " +propertyValue.toString());
		if(propertyValue < 500000) {
			throw new ApplicationException(USER_NOT_ELIGIBLE_ERR_MSG + "Current property value is :"+propertyValue+". To get loan property value should be greather than 500000.");
		}
		persistUser(userRequest);
		Double eligibleLoanAmt = (propertyValue / 100)* 80;
		
		Optional<List<Offer>> offer = offerRepository.findByLoanAmtLessThan(eligibleLoanAmt);
		
		if(offer.isPresent()) {
			 List<Offer> offerList = offer.get();
			 return offerList;
		}else {
			throw new ApplicationException("No offers found.");
		}
		
	}

}
