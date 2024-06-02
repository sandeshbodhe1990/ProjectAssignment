package com.customer.dto;

import java.util.ArrayList;
import java.util.List;

import com.customer.entity.Order;

import lombok.Data;

@Data
public class OrdersList {

	private List<Order> orders;

    public OrdersList() {
    	orders = new ArrayList<>();
    }
    
}
