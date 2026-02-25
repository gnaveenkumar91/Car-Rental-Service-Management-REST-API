package com.vcube.crsapp01.service;

import java.util.List;

import com.vcube.crsapp01.exception.CustomerNotFoundException;
import com.vcube.crsapp01.model.Customer;

public interface CustomerService {

	Customer addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerById(Long id) throws CustomerNotFoundException;

}
