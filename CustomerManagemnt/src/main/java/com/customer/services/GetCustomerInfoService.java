package com.customer.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.exception.UserNotFoundException;
import com.customer.repository.CustomerRepository;
import com.customer.repository.OrderRepository;

@Service
public class GetCustomerInfoService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;

	public Customer getCustomerDetailes(int customerID) {
		Optional<Customer> customerOpt = customerRepository.findById(customerID);
		if (!customerOpt.isPresent()) {
			throw new UserNotFoundException("ERROR_001");
		}
		return customerOpt.get();
		
	}

}
