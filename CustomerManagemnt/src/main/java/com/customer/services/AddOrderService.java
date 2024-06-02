package com.customer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.entity.Order;
import com.customer.exception.UserNotFoundException;
import com.customer.repository.CustomerRepository;

@Service
public class AddOrderService {

	@Autowired
	CustomerRepository customerRepository;
	
	public void addOrders(List<Order> orderList, Integer customerID) {
		Optional<Customer> customerOpt = customerRepository.findById(customerID);
		if (!customerOpt.isPresent()) {
			throw new UserNotFoundException("ERROR_001");
		}
		Customer customer = customerOpt.get();
		customer.setOrders(orderList);
		customerRepository.save(customer);
	}
	
}
