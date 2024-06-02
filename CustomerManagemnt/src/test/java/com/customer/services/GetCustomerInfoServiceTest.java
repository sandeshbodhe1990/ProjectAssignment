package com.customer.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.customer.entity.Customer;
import com.customer.entity.Order;
import com.customer.exception.UserNotFoundException;
import com.customer.repository.CustomerRepository;
import com.customer.services.GetCustomerInfoService;


@ExtendWith(MockitoExtension.class)
class GetCustomerInfoServiceTest {


	@Mock
	CustomerRepository customerRepository;

	@InjectMocks
	GetCustomerInfoService getCustomerInfoService;

	@Test
	void test_001() {
			Order order = new Order();
			order.setId(1);
			order.setProductName("product1");
			order.setProductCost(100);
			order.setDelivaryStatus("Open");

			Order order1 = new Order();
			order.setId(2);
			order.setProductName("product2");
			order.setProductCost(200);
			order.setDelivaryStatus("Open");

			List<Order> listOrders = new ArrayList<Order>();
			listOrders.add(order);
			listOrders.add(order1);

			Customer customer = new Customer();
			customer.setOrders(listOrders);
			customer.setId(1);
			customer.setCustName("Sandesh");
			customer.setContactNo("8899889977");
			customer.setEmail("abc.com");

			when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

				Customer customerResult = getCustomerInfoService.getCustomerDetailes(1);
				
				assertEquals("8899889977", customerResult.getContactNo());
				assertEquals("Sandesh", customerResult.getCustName());
				assertEquals("abc.com", customerResult.getEmail());
				assertEquals(2, customerResult.getOrders().size());
		}
	

	@Test
	void test_002() {
	
	when(customerRepository.findById(1)).thenReturn(Optional.ofNullable(null));
	
	try {
		assertThrows(UserNotFoundException.class, () -> getCustomerInfoService.getCustomerDetailes(1));
	} catch (Exception ex) {
		fail();
	}
}

}
