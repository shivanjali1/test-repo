package com.hcl.mortgageapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mortgageapp.entity.Offer;

/*
 * This is OfferRepository Repository to persist Offer details
 */
@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

	public Optional<List<Offer>> findByLoanAmtLessThan(Double loanAmt);
}
