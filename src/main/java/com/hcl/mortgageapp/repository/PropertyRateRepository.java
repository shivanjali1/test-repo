package com.hcl.mortgageapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mortgageapp.entity.PropertyRate;

/*
 * This is PropertyRate Repository to persist PropertyRate details
 */
@Repository
public interface PropertyRateRepository extends JpaRepository<PropertyRate, Long> {

public Optional<PropertyRate> findByPinCode(String pinCode);	
}
