package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Billing;

@Repository
public interface BillingRepository extends CrudRepository<Billing,Integer>{

}