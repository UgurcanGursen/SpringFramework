package com.ugurcangursen.springdemo.service;

import java.util.List;

import com.ugurcangursen.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theID);

	public void deleteCustomer(int theId);
	

}
