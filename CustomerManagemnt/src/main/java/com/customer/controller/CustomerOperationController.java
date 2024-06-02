package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.dto.OrdersList;
import com.customer.entity.Customer;
import com.customer.entity.Order;
import com.customer.services.AddOrderService;
import com.customer.services.GetCustomerInfoService;
import com.customer.services.NewCustomerService;
import com.customer.services.UpdateCustomerInfoService;

@RestController
@RequestMapping("/demo")
public class CustomerOperationController {

	@Autowired
	GetCustomerInfoService getCustomerInfoService;
	
	@Autowired
	NewCustomerService newCustomerService;
	
	@Autowired
	AddOrderService addOrderService;	
	
	@Autowired
	UpdateCustomerInfoService updateCustomerInfoService;

	@GetMapping("/getCustomerDetails/{id}")
	public Customer getCustomerDetails(@PathVariable("id") Integer id) {
		
		return getCustomerInfoService.getCustomerDetailes(id);

	}

	@PostMapping("/createNewCustomer")
	Customer createNew(@RequestBody Customer customer) {
		return newCustomerService.saveCustomerDetailes(customer);
	}
	
	@PostMapping("/addOrders/{customerID}")
	ResponseEntity createNew(@RequestBody OrdersList orders, @PathVariable("customerID") Integer customerID) {
		addOrderService.addOrders(orders.getOrders(), customerID);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	
	@PutMapping("/updateCustomerInfo/{id}")
	ResponseEntity updateCustomerDetailes(@PathVariable("id") Integer id, @RequestBody Customer customer) {
		updateCustomerInfoService.updateCustomerDetailes(id,customer);
		return new ResponseEntity(HttpStatus.CREATED);
	}

}
