package com.revature.services;

import java.util.List;

import com.revature.models.Billing;

public interface BillingService {
	
	public Billing createBilling(Billing billing);
	public Billing getBillingById(int id);
	public List<Billing> allBilling();
	public Billing updateBilling(Billing change);
	public boolean deleteBilling(Billing billing);

}