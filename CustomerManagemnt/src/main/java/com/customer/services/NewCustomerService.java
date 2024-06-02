package com.customer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.entity.Order;
import com.customer.repository.CustomerRepository;

@Service
public class NewCustomerService {

	@Autowired
	CustomerRepository customerRepo;
	
	public Customer saveCustomerDetailes(Customer customer) {
		return customerRepo.save(customer);
	}

	
}
