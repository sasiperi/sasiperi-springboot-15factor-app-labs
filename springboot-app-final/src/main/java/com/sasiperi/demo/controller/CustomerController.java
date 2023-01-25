package com.sasiperi.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sasiperi.demo.entity.Customer;
import com.sasiperi.demo.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CustomerController {
	
	//TODO : NOT ADVICED DO CONSTURCTOR INJECTION
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer/{id}")
	public Customer getCustomer(@PathVariable("id") Long id) {
		
		log.info(" Sample context logging customer-id {} ", id);
		return customerService.getCustomerById(id);
		
	}
	
	@PatchMapping("/customer/{id}")
	public Customer updateCustomer(@PathVariable("id") Long id) {
		
		log.info(" Sample context logging customer-id {} ", id);
		return customerService.updateCustomerById(id);
		
	}
	
	
	@GetMapping("/customer")
	public List<Customer> getAllCustomer() {
		
		return customerService.getAllCustomers();
		
	}
	
	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		
		return customerService.createCustomerById(customer);
		
	}
	
	
	@GetMapping("/customer/ssn/{ssn}")
	public Customer getCustomer(@PathVariable("ssn") int ssn) {
		
		return customerService.getCustomerBySsn(ssn);
		
	}
	
}
