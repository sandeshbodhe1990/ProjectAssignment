package com.customer.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.exception.UserNotFoundException;
import com.customer.repository.CustomerRepository;

@Service
public class UpdateCustomerInfoService {

	@Autowired
	CustomerRepository customerRepository;

	public Customer updateCustomerDetailes(Integer id, Customer customer) {
		Optional<Customer> customerOldOpt = customerRepository.findById(id);
		if (!customerOldOpt.isPresent()) {
			throw new UserNotFoundException("ERROR_001");
		}
		Customer customerOld = customerOldOpt.get();
		if (null != customerOld) {
			BeanUtils.copyProperties(customer, customerOld, "id","custName","orders");
			return customerRepository.save(customerOld);
		}
		return null;
	}
}
