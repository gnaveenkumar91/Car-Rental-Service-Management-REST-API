package com.vcube.crsapp01.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.crsapp01.exception.CustomerNotFoundException;
import com.vcube.crsapp01.model.Customer;
import com.vcube.crsapp01.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Long id) throws CustomerNotFoundException {
		return customerRepository.findById(id).orElseThrow(()->  new CustomerNotFoundException("customer not found : "));
	}


}
	
	


