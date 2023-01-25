package com.sasiperi.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sasiperi.demo.controller.CustomerController;
import com.sasiperi.demo.entity.Customer;
import com.sasiperi.demo.repository.CustomerRepository;

import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class CustomerService {
	
	//TOD: replace with cinstructor injection
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	Tracer tracer;

	public Customer getCustomerById(Long id) {
		
		Optional<Customer> customerOp = null;
		Span newSpan = this.tracer.nextSpan().name("calculateTax");
		// Start a span and put it in scope. Putting in scope means putting the span
		// in thread local
		// and, if configured, adjust the MDC to contain tracing information
		try (Tracer.SpanInScope ws = this.tracer.withSpan(newSpan.start())) {
		    // ...
		    // You can tag a span - put a key value pair on it for better debugging
		    newSpan.tag("taxValue", id+"-01");
		    // ...
		    // You can log an event on a span - an event is an annotated timestamp
		    newSpan.event("taxCalculated");
		    log.info(" *******  " + id);
		    customerOp = customerRepo.findById(id);
		    newSpan.event("taxCalculated");
		    log.info(" *******  01 " + id);
		}
		finally {
		    // Once done remember to end the span. This will allow collecting
		    // the span to send it to a distributed tracing system e.g. Zipkin
		    newSpan.end();
		}
		
		
		//Optional<Customer> customerOp = customerRepo.findById(id);
		return customerOp.get();
	}

	public Customer updateCustomerById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer createCustomerById(Customer customer) {
		return customerRepo.save(customer);
	}

	public Customer getCustomerBySsn(int ssn) {
		
		return customerRepo.findBySsn(ssn);
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepo.findAll(Sort.by(Direction.DESC, "customerId"));
	}

}
