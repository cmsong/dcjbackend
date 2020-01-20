package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Billing;
import com.revature.services.BillingService;

@RestController
public class BillingController {
	
	@Autowired
	BillingService bs;
	@CrossOrigin(origins="*")
	@PostMapping(value="/billing", consumes="application/json")
	public Billing createUsers(@RequestBody Billing billing) {
		return bs.createBilling(billing);
	}
	@CrossOrigin(origins="*")
	@GetMapping(value="/billing/{id}")
	public Billing getBillingById(@PathVariable("id")int id) {
		return bs.getBillingById(id);
	}
	@CrossOrigin(origins="*")
	@GetMapping(value="/billing")
	public List<Billing> allBilling(){
		return bs.allBilling();
	}
	@CrossOrigin(origins="*")
	@PutMapping(value="/billing", consumes="application/json")
	public Billing updateBilling(@RequestBody Billing change) {
		return bs.updateBilling(change);
	}
	@CrossOrigin(origins="*")
	@DeleteMapping(value="/billing/{id}")
	public boolean delteBilling(@PathVariable int id) {
		bs.deleteBilling(bs.getBillingById(id));
		return true;
	}

}