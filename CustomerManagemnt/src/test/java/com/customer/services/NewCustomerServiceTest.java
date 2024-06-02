package com.customer.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.services.NewCustomerService;


@ExtendWith(MockitoExtension.class)
class NewCustomerServiceTest {

	@Mock
	CustomerRepository customerRepository;

	@InjectMocks
	NewCustomerService newCustomerService;

	@Test
	void test() {
		Customer customer = new Customer();
		customer.setId(1);
		customer.setCustName("Sandesh");
		customer.setContactNo("00000000");
		customer.setEmail("updatedmail@test.com");
		
		when(customerRepository.save(Mockito.any())).thenReturn(customer);
		
		try {
			Customer customerResult = newCustomerService.saveCustomerDetailes(customer);
			assertEquals("00000000", customerResult.getContactNo());
			assertEquals("updatedmail@test.com", customerResult.getEmail());
			assertEquals("Sandesh", customerResult.getCustName());
			
			withSuccess();
		}catch(Exception ex) {
			fail();
		}
	}

}
