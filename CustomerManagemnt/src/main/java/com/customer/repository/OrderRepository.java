package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
