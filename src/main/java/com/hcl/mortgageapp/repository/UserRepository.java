package com.hcl.mortgageapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mortgageapp.entity.User;

/*
 * This is user repository to persist user details
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
