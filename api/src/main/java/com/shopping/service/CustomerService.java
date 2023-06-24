package com.shopping.service;

import java.util.List;

import com.shopping.model.Customer;

public interface CustomerService {
	
	public List<Customer> viewAllCustomers();  //Read
	
	public void addCustomer(Customer customer);  //create
	
	public void updateCustomer(Customer customer);  //update
	
	public void deleteCustomer(int id);  //delete
	
	public int loginValidation(String username,String password);

}
