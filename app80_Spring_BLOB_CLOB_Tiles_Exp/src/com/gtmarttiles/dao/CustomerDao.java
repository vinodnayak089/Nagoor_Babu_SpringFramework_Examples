package com.gtmarttiles.dao;

import com.gtmarttiles.dto.Customer;

public interface CustomerDao {
	
	public void insertCustomer(Customer cus);
	public Customer readCustomer();

}
