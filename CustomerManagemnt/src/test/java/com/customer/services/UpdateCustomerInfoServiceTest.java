package com.customer.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.customer.entity.Customer;
import com.customer.exception.UserNotFoundException;
import com.customer.repository.CustomerRepository;
import com.customer.services.UpdateCustomerInfoService;


@ExtendWith(MockitoExtension.class)
class UpdateCustomerInfoServiceTest {

	@Mock
	CustomerRepository customerRepository;

	@InjectMocks
	UpdateCustomerInfoService updateCustomerInfoService;

	@Test
	void test_001() {
		Customer customerOld = new Customer();
		customerOld.setId(1);
		customerOld.setCustName("Sandesh");
		customerOld.setContactNo("8899889977");
		customerOld.setEmail("abc.com");

		Customer customerUpdated = new Customer();
		customerUpdated.setId(1);
		customerUpdated.setCustName("Sandesh");
		customerUpdated.setContactNo("00000000");
		customerUpdated.setEmail("updatedmail@test.com");
		
		when(customerRepository.findById(1)).thenReturn(Optional.of(customerOld));
		when(customerRepository.save(Mockito.any())).thenReturn(customerUpdated);
		
		try {
			Customer customerResult = updateCustomerInfoService.updateCustomerDetailes(1, customerUpdated);
			assertEquals("00000000", customerResult.getContactNo());
			assertEquals("updatedmail@test.com", customerResult.getEmail());
			withSuccess();
		}catch(Exception ex) {
			fail();
		}

		
	}
	
	@Test
	void test_002() {
		Customer customerUpdated = new Customer();
		customerUpdated.setId(1);
		customerUpdated.setCustName("Sandesh");
		customerUpdated.setContactNo("00000000");
		customerUpdated.setEmail("updatedmail@test.com");
		
	when(customerRepository.findById(1)).thenReturn(Optional.ofNullable(null));
	
	try {
		assertThrows(UserNotFoundException.class, () -> updateCustomerInfoService.updateCustomerDetailes(1,customerUpdated));
	} catch (Exception ex) {
		fail();
	}
}


}
