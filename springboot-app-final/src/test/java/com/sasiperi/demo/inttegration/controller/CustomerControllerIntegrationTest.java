package com.sasiperi.demo.inttegration.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.sasiperi.demo.ApplicationBaseTest;
import com.sasiperi.demo.TestTypes;
import com.sasiperi.demo.entity.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Tag(TestTypes.INTEGRATION_TEST)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CustomerControllerIntegrationTest extends ApplicationBaseTest {

	@Autowired(required=true)
    TestRestTemplate testRestTemplate;
	
	@Value("${customer.getbyssn.endpoint}")
    String GET_BY_SSN_EP;

    @LocalServerPort
    String TEST_LOCAL_PORT;

	@Test
    public void testGetCustomerBySsn()
    {
        log.info("URL end point " + GET_BY_SSN_EP);
        log.info("RANDOM PORT " + TEST_LOCAL_PORT );
        //getTrackingInputMap();
        int ssn = 12345631;

        Customer customer = testRestTemplate.getForObject(GET_BY_SSN_EP, Customer.class, TEST_LOCAL_PORT,ssn);
        log.info(customer.toString());
        assertEquals(1, customer.getCustomerId());
        
        assertEquals("sasi01", customer.getFirstName());

    }

	
}
