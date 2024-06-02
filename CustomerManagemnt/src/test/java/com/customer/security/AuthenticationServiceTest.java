package com.customer.security;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.BadCredentialsException;

import com.customer.security.AuthenticationService;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {

	@Test
	public void testGetAuthentication_001() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addHeader("X-API-KEY", "abcd");
		assertThrows(BadCredentialsException.class, () -> AuthenticationService.getAuthentication(request));

	}

	@Test
	public void testGetAuthentication_002() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addHeader("X-API-KEY", "abcde12345");
		try {
		AuthenticationService.getAuthentication(request);
		withSuccess();
		}catch(Exception ex) {
			fail();
		}
	}
}
